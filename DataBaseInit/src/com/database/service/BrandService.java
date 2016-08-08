package com.database.service;
import com.database.po.Brand;

import com.database.dao.BrandDao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.database.utils.PageVo;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BrandService {

@Autowired
private BrandDao brandDao;

	public Boolean  insertBrand(Brand brand){

		Boolean flag=false;
		if(brandDao.insertBrand(brand)>0){
		flag=true;
		}
		return flag;
	}

	public Boolean  updateBrand(Brand brand){

		Boolean flag=false;
		if(brandDao.updateBrand(brand)>0){
		flag=true;
		}
		return flag;
	}

	public PageVo  getBrandList(Brand brand){

		PageVo  pageVo= new PageVo();
		List<Brand> list=null;
		list=brandDao.getBrandList(brand);
		pageVo.setRoot(list);
		pageVo.setTotal(brandDao.getBrandListCount(brand));
		return pageVo;
	}

	public Brand  getBrand(String id){

		Brand obj =null;
		obj=brandDao.getBrandById(id);
		return obj;
	}

}