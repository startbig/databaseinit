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

	private List<Menu> menulist;
	@RequestMapping("/login")
	public String login(HttpServletRequest request,
			HttpServletResponse response, User user) {
		HttpSession session = request.getSession();
		User check = userService.loginUser(user);
		if (check != null) {
			menulist = menuService.selectRolesMenus(check.getId());
			session.setAttribute("loginUser", check);
			return "redirect:index.jsp";  
		} else {
			session.setAttribute("errorInfo", Constant.ERRORINFO_MSG);
			return "login.jsp";

		}
	}
	
	@RequestMapping("/getMenu")
	@ResponseBody
	public TreeMenu getMenu() {
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
	
	public List<Menu> getMenuListByUserId(String id){
		List<Menu> list =new   ArrayList<Menu>();
		
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
//	public TreeMenu initUserMenus(List<Menu> list){
//		TreeMenu m = new TreeMenu();
//		List<TreeMenu> mlist = new ArrayList<TreeMenu>();
//		Menu fmenu;
//		Menu smenu;
//		for (int i = 0; i < list.size(); i++) {
//		  fmenu=list.get(i);
//		  String fatherId = fmenu.getParentId();
//		  if(fatherId.equals("root")){
//			   TreeMenu userm = new TreeMenu();
//				m.setId(fmenu.getId());
//				m.setText(fmenu.getMenuName());
//				m.setXtype(fmenu.getMenuType());
//				for (int j = 0; j < list.size(); j++) {
//					smenu=list.get(i);
//					String sfatherId = smenu.getParentId();
//					if(fmenu.getId().equals(sfatherId)){
//						m.setLeaf(false);
//						m.setChildren(children);
//					}else{
//						m.setLeaf(true);
//					}
//				}
//				mlist.add(userm);
//		  }
//		}
//		m.setChildren(mlist);
//		return m;
//	}

	@RequestMapping("/selectSyscodeList")
	@ResponseBody
	public PageVo selectSyscodeList(Integer page, Integer limit, Syscode syscode) {
		if (syscode == null) {
			syscode = new Syscode();
		}
		syscode.setPageSize(limit);
		syscode.setCurrPage(page);
		pageVo = syscodeService.selectSyscodeList(syscode);
		pageVo.setSuccess(true);
		return pageVo;
	}
	
	

	@RequestMapping("/updateSyscode")
	@ResponseBody
	public PageVo updateSyscode(@RequestBody Syscode syscode) {
		pageVo = new PageVo();
		boolean flag = syscodeService.updateSyscode(syscode);
		pageVo.setSuccess(flag);
		return pageVo;
	}

	@RequestMapping("/insertSyscode")
	@ResponseBody
	public PageVo insertSyscode(@RequestBody List<Syscode> syscode) {
		   pageVo = new PageVo();
			boolean success = syscodeService.insertSyscodeList(syscode);
			pageVo.setSuccess(success);
		
		return pageVo;
	}

	@RequestMapping("/deleteSyscode")
	@ResponseBody
	public PageVo deleteSyscode(@RequestBody Syscode syscode) {
		pageVo = new PageVo();
		boolean flag = syscodeService.deleteSyscode(syscode);
		pageVo.setSuccess(flag);
		return pageVo;
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		 return "redirect:login.jsp";  
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
