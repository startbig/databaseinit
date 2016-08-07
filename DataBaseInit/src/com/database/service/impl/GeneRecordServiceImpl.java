package com.database.service.impl;
import com.database.utils.PageVo;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import com.database.service.GeneRecordService;
import com.database.dao.GeneRecordDao;
import com.database.po.GeneRecord;

/**
 * 
 * GeneRecordServiceImpl数据库操作接口类
 * 
 **/

@Service
public class GeneRecordServiceImpl implements GeneRecordService{

@Resource
private GeneRecordDao geneRecorddao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public GeneRecord  selectById (  String id ){
		GeneRecord geneRecord=geneRecorddao.selectById (id);
		  return geneRecord;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public PageVo  selectGeneRecordList  ( GeneRecord record){
		PageVo  pageVo= new PageVo();
		List<GeneRecord>  list=geneRecorddao.selectGeneRecordList( record);
		  pageVo.setRoot(list);
		  pageVo.setTotal(geneRecorddao.selectGeneRecordCount(record));
		  return  pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=geneRecorddao.deleteById ( id );
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
	 public boolean deleteGeneRecord( GeneRecord record ){
		 int flag=geneRecorddao.deleteGeneRecord( record );
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
	 public boolean insertGeneRecord( GeneRecord record ){
		 int flag=geneRecorddao.insertGeneRecord( record );
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
	 public boolean updateGeneRecord( GeneRecord record ){
		 int flag=geneRecorddao.updateGeneRecord( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

}