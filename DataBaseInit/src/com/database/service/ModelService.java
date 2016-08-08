package com.database.service;
import com.database.po.Model;

import com.database.dao.ModelDao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.database.utils.PageVo;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ModelService {

@Autowired
private ModelDao modelDao;

	public Boolean  insertModel(Model model){

		Boolean flag=false;
		if(modelDao.insertModel(model)>0){
		flag=true;
		}
		return flag;
	}

	public Boolean  updateModel(Model model){

		Boolean flag=false;
		if(modelDao.updateModel(model)>0){
		flag=true;
		}
		return flag;
	}

	public PageVo  getModelList(Model model){

		PageVo  pageVo= new PageVo();
		List<Model> list=null;
		list=modelDao.getModelList(model);
		pageVo.setRoot(list);
		pageVo.setTotal(modelDao.getModelListCount(model));
		return pageVo;
	}

	public Model  getModel(String id){

		Model obj =null;
		obj=modelDao.getModelById(id);
		return obj;
	}

}