package com.database.service;
import com.database.po.Roles;

import com.database.dao.RolesDao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.database.utils.PageVo;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RolesService {

@Autowired
private RolesDao rolesDao;

	public Boolean  insertRoles(Roles roles){

		Boolean flag=false;
		if(rolesDao.insertRoles(roles)>0){
		flag=true;
		}
		return flag;
	}

	public Boolean  updateRoles(Roles roles){

		Boolean flag=false;
		if(rolesDao.updateRoles(roles)>0){
		flag=true;
		}
		return flag;
	}

	public PageVo  getRolesList(Roles roles){

		PageVo  pageVo= new PageVo();
		List<Roles> list=null;
		list=rolesDao.getRolesList(roles);
		pageVo.setRoot(list);
		pageVo.setTotal(rolesDao.getRolesListCount(roles));
		return pageVo;
	}

	public Roles  getRoles(String id){

		Roles obj =null;
		obj=rolesDao.getRolesById(id);
		return obj;
	}

}