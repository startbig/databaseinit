package com.database.dao;

 import java.util.List;
import com.database.po.Syscode;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * SyscodeDao数据库操作接口类
 * 
 **/

public interface SyscodeDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Syscode  selectById ( @Param("id") String id );
	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<Syscode>  selectSyscodeList  ( Syscode record);
	/**
	 * 
	 * 查询（根据条件查询集合总数）
	 * 
	 **/
	 int  selectSyscodeCount  ( Syscode record );

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
	int deleteSyscode( Syscode record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertSyscode( Syscode record );
	int insertSyscodeList( List<Syscode> record );
	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateSyscode( Syscode record );
}