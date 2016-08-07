package com.database.service.impl;
import com.database.utils.PageVo;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import com.database.service.TableService;
import com.database.dao.TableDao;
import com.database.po.Table;

/**
 * 
 * TableServiceImpl数据库操作接口类
 * 
 **/

@Service
public class TableServiceImpl implements TableService{

@Resource
private TableDao tabledao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public Table  selectById (  String id ){
		Table table=tabledao.selectById (id);
		  return table;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public PageVo  selectTableList  ( Table record){
		PageVo  pageVo= new PageVo();
		List<Table>  list=tabledao.selectTableList( record);
		  pageVo.setRoot(list);
		  pageVo.setTotal(tabledao.selectTableCount(record));
		  return  pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=tabledao.deleteById ( id );
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
	 public boolean deleteTable( Table record ){
		 int flag=tabledao.deleteTable( record );
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
	 public boolean insertTable( Table record ){
		 int flag=tabledao.insertTable( record );
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
	 public boolean createTable(String sql ){
		 int flag=tabledao.createTable( sql );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

}