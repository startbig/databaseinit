package com.database.handler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.po.Menu;
import com.database.po.Syscode;
import com.database.po.TreeMenu;
import com.database.po.User;
import com.database.po.UserMenus;
import com.database.po.UserTreeMenu;
import com.database.service.MenuService;
import com.database.service.SyscodeService;
import com.database.service.UserService;
import com.database.utils.Constant;
import com.database.utils.HandlerBase;
import com.database.utils.PageVo;

@Controller
public class SysHandler extends HandlerBase {
	private PageVo pageVo = new PageVo();
    
	@Resource
	private UserService userService;
	@Resource
	private SyscodeService syscodeService;
	@Resource
	private MenuService menuService;

//	private List<Menu> menulist;
	
	//=================================登陆=注销================================================
	@RequestMapping("/login")
	public String login(HttpServletRequest request,
			HttpServletResponse response, User user) {
		HttpSession session = request.getSession();
		User check = userService.loginUser(user);
		if (check != null) {
			List<Menu> menulist = menuService.selectRolesMenus(check.getId());
			session.setAttribute("userMenu", menulist);
			session.setAttribute("loginUser", check);
			return "redirect:index.jsp";  
		} else {
			session.setAttribute("errorInfo", Constant.ERRORINFO_MSG);
			return "login.jsp";

		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		 return "redirect:login.jsp";  
	}
	
	//=================================用户菜单=更改用户菜单================================================

	@RequestMapping("/getMenu")
	@ResponseBody
	public TreeMenu getMenu() {
		TreeMenu purviewIds = 	initMenu();
		return purviewIds;
	}
	public TreeMenu initMenu() {
		TreeMenu purviewIds = new TreeMenu();
		purviewIds.setText("系统菜单");
		purviewIds.setId("root");
		purviewIds.setLeaf(false);
		purviewIds.setChildren(initUserMenus(getMenuListByUserId("root")));
		return purviewIds;
	}
	public List<TreeMenu> initUserMenus(List<Menu> menulist) {
		List<TreeMenu> treeList = new ArrayList<TreeMenu>();
		if (menulist.size() > 0 && menulist != null) {
			for (Menu menu : menulist) {
				TreeMenu m = new TreeMenu();
				m.setId(menu.getId());
				m.setText(menu.getMenuName());
				m.setXtype(menu.getMenuType());
				List<Menu> list =getMenuListByUserId(menu.getId());
				if (list.size() > 0 && list != null) {
					m.setLeaf(false);
					m.setExpanded(true);

				} else {
					m.setLeaf(true);
				}
				m.setChildren(initUserMenus(list));
				treeList.add(m);
			}
		}
		return treeList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Menu> getMenuListByUserId(String id){
		List<Menu> list =new   ArrayList<Menu>();
		List<Menu> menulist=(List<Menu>) session.getAttribute("userMenu");
		int size=menulist.size();
		Menu m;
		for (int i = 0; i <size; i++) {
			m=menulist.get(i);
			if(id.equals(m.getParentId())){
				list.add(m);
			}
		}
		return list;
	}

	
	@RequestMapping("/getUserMenu")
	@ResponseBody
	public UserTreeMenu getUserMenu(String id) {
		List<Menu> list = menuService.selectRolesMenus(id);
		Set<String> purviewIds = new HashSet<String>();
		for(Menu p : list){
			purviewIds.add(p.getId());
		}
		UserTreeMenu m = new UserTreeMenu();
		pageVo = new PageVo();
		Menu me = new Menu();
		me.setParentId("root");
		List<Menu> menulist = menuService.selectByParentId("root");
		m.setText("系统菜单");
		m.setId("root");
		m.setLeaf(false);
		m.setChildren(createCheckTreeMenu(menulist, purviewIds ));
		return m;
	    
	}
	
	@RequestMapping("/insertUserMenus")
	@ResponseBody
	public PageVo insertUserMenus(String[] meunsId,String userId) {
		  pageVo = new PageVo();
		  List<UserMenus> list=new ArrayList<UserMenus>();
		  UserMenus menus;
		  for (int i = 0; i < meunsId.length; i++) {
			  menus=new UserMenus();
			  menus.setUserId(userId);
			  menus.setMenuId(meunsId[i]);
			  list.add(menus);
		  }
		  menuService.deleteByUserId(userId);;
		  boolean success = menuService.insertUserMenu(list);
		  pageVo.setSuccess(success);
		return pageVo;
	    
	}
	
	
	
	public List<UserTreeMenu> createCheckTreeMenu(List<Menu> menulist,Set<String> purviewIds) {
		List<UserTreeMenu> treeList = new ArrayList<UserTreeMenu>();
		if (menulist.size() > 0 && menulist != null) {
			for (Menu menu : menulist) {
				UserTreeMenu m = new UserTreeMenu();
				m.setId(menu.getId());
				m.setText(menu.getMenuName());
				m.setXtype(menu.getMenuType());
				List<Menu> list = menuService.selectByParentId(menu.getId());
				if (list.size() > 0 && list != null) {
					m.setLeaf(false);
					m.setExpanded(true);
				} else {
					m.setLeaf(true);
				}
				if(purviewIds.contains(menu.getId())){
					m.setChecked(true);
				}else{
					m.setChecked(false);
				}
				m.setChildren(createCheckTreeMenu(list,purviewIds));
				treeList.add(m);
			}
		}
		return treeList;
	}



	

}
