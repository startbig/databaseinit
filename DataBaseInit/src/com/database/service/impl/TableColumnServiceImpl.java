package com.database.service.impl;
import com.database.utils.PageVo;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import com.database.service.TableColumnService;
import com.database.dao.TableColumnDao;
import com.database.po.TableColumn;

/**
 * 
 * TableColumnServiceImpl数据库操作接口类
 * 
 **/

@Service
public class TableColumnServiceImpl implements TableColumnService{

@Resource
private TableColumnDao tableColumndao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public TableColumn  selectById (  String id ){
		TableColumn tableColumn=tableColumndao.selectById (id);
		  return tableColumn;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public PageVo  selectTableColumnList  ( TableColumn record){
		PageVo  pageVo= new PageVo();
		List<TableColumn>  list=tableColumndao.selectTableColumnList( record);
		  pageVo.setRoot(list);
		  pageVo.setTotal(tableColumndao.selectTableColumnCount(record));
		  return  pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=tableColumndao.deleteById ( id );
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
	 public boolean deleteTableColumn( TableColumn record ){
		 int flag=tableColumndao.deleteTableColumn( record );
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
	 public boolean insertTableColumn( TableColumn record ){
		 int flag=tableColumndao.insertTableColumn( record );
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
	 public boolean updateTableColumn( TableColumn record ){
		 int flag=tableColumndao.updateTableColumn( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

}