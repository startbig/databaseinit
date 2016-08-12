package com.database.service;
import com.database.po.Syscode;

import com.database.dao.SyscodeDao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.database.utils.PageVo;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SyscodeService {

@Autowired
private SyscodeDao syscodeDao;

	public Boolean  insertSyscode(Syscode syscode){

		Boolean flag=false;
		if(syscodeDao.insertSyscode(syscode)>0){
		flag=true;
		}
		return flag;
	}

	public Boolean  updateSyscode(Syscode syscode){

		Boolean flag=false;
		if(syscodeDao.updateSyscode(syscode)>0){
		flag=true;
		}
		return flag;
	}

	public PageVo  getSyscodeList(Syscode syscode){

		PageVo  pageVo= new PageVo();
		List<Syscode> list=null;
		list=syscodeDao.getSyscodeList(syscode);
		pageVo.setRoot(list);
		pageVo.setTotal(syscodeDao.getSyscodeListCount(syscode));
		return pageVo;
	}

	public Syscode  getSyscode(String id){

		Syscode obj =null;
		obj=syscodeDao.getSyscodeById(id);
		return obj;
	}
	public boolean   deleteSyscode(String id){

		Boolean flag=false;
		if(syscodeDao.deleteSyscode(id)>0){
		flag=true;
		}
		return flag;
	}
	

}