package com.database.dao;

 import java.util.List;

import com.database.po.allmut;

/**
 * 
 * allmutDao数据库操作接口类
 * 
 **/

public interface allmutDao{



	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
	List<allmut>  selectallmutList  ();

}