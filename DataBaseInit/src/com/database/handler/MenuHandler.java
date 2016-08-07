package com.database.handler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.po.Menu;
import com.database.po.Resources;
import com.database.po.Task;
import com.database.po.TreeMenu;
import com.database.po.User;
import com.database.service.MenuService;
import com.database.service.ResourcesService;
import com.database.utils.PageVo;

@Controller
@RequestMapping("/menu")
public class MenuHandler {
	private PageVo pageVo = new PageVo();
	@Resource
	private MenuService menuService;
	@Resource
	private ResourcesService resourcesService;

	public PageVo getPageVo() {
		return pageVo;
	}

	public void setPageVo(PageVo pageVo) {
		this.pageVo = pageVo;
	}

	@RequestMapping("/selectResourcesList")
	@ResponseBody
	public PageVo selectResourcesList(Integer page, Integer limit,
			Resources resources) {
		if (resources == null) {
			resources = new Resources();
		}
		resources.setPageSize(limit);
		resources.setCurrPage(page);
		pageVo = resourcesService.selectResourcesList(resources);
		pageVo.setSuccess(true);
		return pageVo;
	}

	@RequestMapping("/selectRolesMenus")
	@ResponseBody
	public TreeMenu selectRolesMenus(String id) {
		List<Menu> list = menuService.selectRolesMenus(id);
		Set<String> purviewIds = new HashSet<String>();
		for(Menu p : list){
			purviewIds.add(p.getId());
		}
		TreeMenu m = new TreeMenu();
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

	


	


	@RequestMapping("/getMenu")
	@ResponseBody
	public TreeMenu getMenu() {
		TreeMenu m = new TreeMenu();
		pageVo = new PageVo();
		Menu me = new Menu();
		me.setParentId("root");
		List<Menu> menulist = menuService.selectByParentId("root");
		m.setText("系统菜单");
		m.setId("root");
		m.setLeaf(false);
		m.setChildren(createTreeMenu(menulist));
		return m;
	}

	@RequestMapping("/getJsonMenu")
	@ResponseBody
	public PageVo getJsonMenu() {
		Menu record = new Menu();
		List<Menu> menulist = menuService.selectMenuList(record);
		pageVo.setRoot(menulist);
		pageVo.setSuccess(true);
		pageVo.setTotal(20);
		return pageVo;
	}

	public List<TreeMenu> createTreeMenu(List<Menu> menulist) {
		List<TreeMenu> treeList = new ArrayList<TreeMenu>();
		if (menulist.size() > 0 && menulist != null) {
			for (Menu menu : menulist) {
				TreeMenu m = new TreeMenu();
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
	
	public List<TreeMenu> createCheckTreeMenu(List<Menu> menulist,Set<String> purviewIds) {
		List<TreeMenu> treeList = new ArrayList<TreeMenu>();
		if (menulist.size() > 0 && menulist != null) {
			for (Menu menu : menulist) {
				TreeMenu m = new TreeMenu();
				m.setId(menu.getId());
				m.setText(menu.getMenuName());
				m.setXtype(menu.getMenuType());
				List<Menu> list = menuService.selectByParentId(menu.getId());
				if (list.size() > 0 && list != null) {
					m.setLeaf(false);
				} else {
					m.setLeaf(true);
				}
//				if(purviewIds.contains(menu.getId())){
//					m.setChecked(true);
//				}else{
//					m.setChecked(false);
//				}
				m.setChildren(createTreeMenu(list));
				treeList.add(m);
			}
		}
		return treeList;
	}

	@RequestMapping("/insertMenu")
	@ResponseBody
	public PageVo insertUser(Menu menu) {
		pageVo = new PageVo();
		boolean flag = menuService.insertMenu(menu);
		pageVo.setSuccess(flag);
		return pageVo;
	}

	@RequestMapping("/updateMenu")
	@ResponseBody
	public PageVo updateMenu(Menu menu) {
		pageVo = new PageVo();
		boolean flag = menuService.updateMenu(menu);
		pageVo.setSuccess(flag);
		return pageVo;
	}

	@RequestMapping("/insertResources")
	@ResponseBody
	public PageVo insertResources(Resources resources) {
		pageVo = new PageVo();
		boolean flag = resourcesService.insertResources(resources);
		pageVo.setSuccess(flag);
		return pageVo;
	}

	@RequestMapping("/updateResources")
	@ResponseBody
	public PageVo updateResources(@RequestBody Resources resources) {
		pageVo = new PageVo();
		boolean flag = resourcesService.updateResources(resources);
		pageVo.setSuccess(flag);
		return pageVo;
	}

	@RequestMapping("/deleteResources")
	@ResponseBody
	public PageVo deleteResources(@RequestBody Resources resources) {
		pageVo = new PageVo();
		System.out.println(resources.getResourceName() + "===");
		boolean flag = resourcesService.deleteResources(resources);
		pageVo.setSuccess(flag);
		return pageVo;
	}

}
