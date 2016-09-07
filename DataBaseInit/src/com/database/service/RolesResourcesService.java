package com.database.service;
import com.database.po.RolesResources;

import com.database.dao.RolesResourcesDao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.database.utils.PageVo;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RolesResourcesService {

@Autowired
private RolesResourcesDao rolesresourcesDao;

	public Boolean  insertRolesResources(RolesResources rolesResources){

		Boolean flag=false;
		if(rolesresourcesDao.insertRolesResources(rolesResources)>0){
		flag=true;
		}
		return flag;
	}

	public Boolean  updateRolesResources(RolesResources rolesResources){

		Boolean flag=false;
		if(rolesresourcesDao.updateRolesResources(rolesResources)>0){
		flag=true;
		}
		return flag;
	}

	public PageVo  getRolesResourcesList(RolesResources rolesResources){

		PageVo  pageVo= new PageVo();
		List<RolesResources> list=null;
		list=rolesresourcesDao.getRolesResourcesList(rolesResources);
		pageVo.setRoot(list);
		pageVo.setTotal(rolesresourcesDao.getRolesResourcesListCount(rolesResources));
		return pageVo;
	}

	public List<RolesResources>  getRolesResourcesById(String id){
		List<RolesResources> list=null;
		list=rolesresourcesDao.getRolesResourcesById(id);
		return list;
	}

}