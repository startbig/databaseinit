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

	@RequestMapping("/login")
	public String login(HttpServletRequest request,
			HttpServletResponse response, User user) {
		HttpSession session = request.getSession();
		User check = userService.loginUser(user);
		if (check != null) {
			List<Menu> list = menuService.selectRolesMenus(check.getId());
			Set<String> purviewIds = new HashSet<String>();
			for(Menu p : list){
				purviewIds.add(p.getId());
			}
			session.setAttribute("loginUser", check);
			session.setAttribute("userMenus", purviewIds);
			return "redirect:index.jsp";  
		} else {
			session.setAttribute("errorInfo", Constant.ERRORINFO_MSG);
			return "login.jsp";

		}
	}

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
				} else {
					m.setLeaf(true);
				}
				if(purviewIds.contains(menu.getId())){
					m.setChecked(true);
				}else{
					m.setChecked(false);
				}
				m.setChildren(createTreeMenu(list));
				treeList.add(m);
			}
		}
		return treeList;
	}
	
	public List<UserTreeMenu> createTreeMenu(List<Menu> menulist) {
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
				} else {
					m.setLeaf(true);
				}
				m.setChildren(createTreeMenu(list));
				treeList.add(m);
			}
		}
		return treeList;
	}

}
