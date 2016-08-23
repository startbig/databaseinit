package com.database.handler;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.database.po.Roles;
import com.database.service.RolesService;
import com.database.utils.Constant;
import com.database.utils.HandlerBase;
import com.database.utils.PageVo;

@Controller
@RequestMapping("/roles")
public class RolesHandler  extends HandlerBase{
	private PageVo pageVo = new PageVo();
	@Resource 
	private RolesService rolesService;

	@RequestMapping("/getRolesList")
	@ResponseBody
	public PageVo getRolesList(Integer page,Integer limit, Roles roles){
		if(roles==null){
			roles=new Roles();
		}
		roles.setPageSize(limit);
		roles.setCurrPage(page);
		pageVo=rolesService.getRolesList(roles);
		pageVo.setSuccess(true);
		return pageVo;
	}
	@RequestMapping("/insertRoles")
	@ResponseBody
	public PageVo insertRoles(Roles roles){
		pageVo = new PageVo();
		String userName=Constant.getUserName(request);
		roles.setCreateUser(userName);
		boolean success=rolesService.insertRoles(roles);
		pageVo.setSuccess(success);
		return pageVo;
	}
	@RequestMapping("/updateRoles")
	@ResponseBody
	public PageVo updateRoles(Roles roles){
		pageVo = new PageVo();
		boolean success=rolesService.updateRoles(roles);
		pageVo.setSuccess(success);
		return pageVo;
	}
}