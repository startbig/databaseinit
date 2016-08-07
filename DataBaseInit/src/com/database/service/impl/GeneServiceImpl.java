package com.database.service.impl;
import com.database.utils.PageVo;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.database.service.GeneService;
import com.database.dao.GeneDao;
import com.database.po.Gene;

/**
 * 
 * GeneServiceImpl数据库操作接口类
 * 
 **/

@Service
public class GeneServiceImpl implements GeneService{

@Resource
private GeneDao genedao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public Gene  selectById (  String id ){
		Gene gene=genedao.selectById (id);
		  return gene;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public PageVo  selectGeneList  ( Gene record){
		PageVo  pageVo= new PageVo();
		List<Gene>  list=genedao.selectGeneList( record);
		  pageVo.setRoot(list);
		  pageVo.setTotal(genedao.selectGeneCount(record));
		  return  pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=genedao.deleteById ( id );
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
	 public boolean deleteGene( Gene record ){
		 int flag=genedao.deleteGene( record );
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
	 public boolean insertGene( Gene record ){
		 int flag=genedao.insertGene( record );
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
	 public boolean updateGene( Gene record ){
		 int flag=genedao.updateGene( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

	@Override
	public void insertGeneList(Map map) {
		// TODO Auto-generated method stub
		genedao.insertGeneList(map);
//		System.out.println(map.get("flag"));
	}

}