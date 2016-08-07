package com.database.service.impl;
import com.database.utils.PageVo;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import com.database.service.BrandService;
import com.database.dao.BrandDao;
import com.database.po.Brand;

/**
 * 
 * BrandServiceImpl数据库操作接口类
 * 
 **/

@Service
public class BrandServiceImpl implements BrandService{

@Resource
private BrandDao branddao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public Brand  selectById (  String id ){
		Brand brand=branddao.selectById (id);
		  return brand;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public PageVo  selectBrandList  ( Brand record){
		PageVo  pageVo= new PageVo();
		List<Brand>  list=branddao.selectBrandList( record);
		  pageVo.setRoot(list);
		  pageVo.setTotal(branddao.selectBrandCount(record));
		  return  pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=branddao.deleteById ( id );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }	 }

	/**
	 * 
	 * 删除（根据对象）
	 * 
	 **/
	 public boolean deleteBrand( Brand record ){
		 int flag=branddao.deleteBrand( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	 public boolean insertBrand( Brand record ){
		 int flag=branddao.insertBrand( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	 public boolean updateBrand( Brand record ){
		 int flag=branddao.updateBrand( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

}