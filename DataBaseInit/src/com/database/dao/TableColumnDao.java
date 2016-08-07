package com.database.dao;

 import java.util.List;
import com.database.po.TableColumn;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * TableColumnDao数据库操作接口类
 * 
 **/

public interface TableColumnDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	TableColumn  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<TableColumn>  selectTableColumnList  ( TableColumn record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectTableColumnCount  ( TableColumn record );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteById ( @Param("id") String id );

	/**
	 * 
	 * 删除（根据对象）
	 * 
	 **/
	int deleteTableColumn( TableColumn record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertTableColumn( TableColumn record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateTableColumn( TableColumn record );
}