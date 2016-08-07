package com.database.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.po.GeneExport;
import com.database.po.RoleMenu;
import com.database.po.Roles;
import com.database.service.RoleMenuService;
import com.database.service.RolesService;
import com.database.utils.HandlerBase;
import com.database.utils.PageVo;

@Controller
@RequestMapping("/roles")
public class RolesHandler  extends HandlerBase {
	private PageVo pageVo = new PageVo();

	@Resource
	private RolesService rolesService;
	@Resource
	private RoleMenuService roleMenuService;
	
	@RequestMapping("/selectRolesList")
	@ResponseBody
	public PageVo selectRolesList(Integer page,Integer limit, Roles record){
		if(record==null){
			record=new Roles();
		}
		record.setPageSize(limit);
		record.setCurrPage(page);
		pageVo=rolesService.selectRolesList(record);
		pageVo.setSuccess(true);
		return pageVo;
	}
	@RequestMapping("/selectUserRolesList")
	@ResponseBody
	public PageVo selectUserRolesList(RoleMenu record){
		if(record==null){
			record=new RoleMenu();
		}
		pageVo=roleMenuService.selectRoleMenuList(record);
		pageVo.setSuccess(true);
		return pageVo;
	}
	
}
