package com.database.dao;

 import java.util.List;
import com.database.po.Task;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * TaskDao数据库操作接口类
 * 
 **/

public interface TaskDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Task  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<Task>  selectTaskList  ( Task record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectTaskCount  ( Task record );

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
	int deleteTask( Task record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertTask( Task record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateTask( Task record );
}