package com.database.service.impl;
import com.database.utils.PageVo;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import com.database.service.GeneExportService;
import com.database.dao.GeneExportDao;
import com.database.po.GeneExport;

/**
 * 
 * GeneExportServiceImpl数据库操作接口类
 * 
 **/

@Service
public class GeneExportServiceImpl implements GeneExportService{

@Resource
private GeneExportDao geneExportdao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public GeneExport  selectById (  String id ){
		GeneExport geneExport=geneExportdao.selectById (id);
		  return geneExport;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public PageVo  selectGeneExportList  ( GeneExport record){
		  PageVo  pageVo= new PageVo();
		  List<GeneExport>  list=geneExportdao.getUGeneExportList(record);
		  pageVo.setRoot(list);
		  pageVo.setTotal(geneExportdao.selectGeneExportCount(record));
		  return  pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=geneExportdao.deleteById ( id );
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
	 public boolean deleteGeneExport( GeneExport record ){
		 int flag=geneExportdao.deleteGeneExport( record );
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
	 public boolean insertGeneExport( GeneExport record ){
		 int flag=geneExportdao.insertGeneExport( record );
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
	 public boolean updateGeneExport( GeneExport record ){
		 int flag=geneExportdao.updateGeneExport( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

}