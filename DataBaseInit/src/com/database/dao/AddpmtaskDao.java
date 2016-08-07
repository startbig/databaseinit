package com.database.dao;

 import java.util.List;
import com.database.po.Addpmtask;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * AddpmtaskDao数据库操作接口类
 * 
 **/

public interface AddpmtaskDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Addpmtask  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<Addpmtask>  selectAddpmtaskList  ( Addpmtask record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectAddpmtaskCount  ( Addpmtask record );

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
	int deleteAddpmtask( Addpmtask record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertAddpmtask( Addpmtask record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateAddpmtask( Addpmtask record );
}