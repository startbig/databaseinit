package com.database.service.impl;
import com.database.utils.PageVo;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import com.database.service.TaskService;
import com.database.dao.TaskDao;
import com.database.po.Task;

/**
 * 
 * TaskServiceImpl数据库操作接口类
 * 
 **/

@Service
public class TaskServiceImpl implements TaskService{

@Resource
private TaskDao taskdao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public Task  selectById (  String id ){
		Task task=taskdao.selectById (id);
		  return task;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public PageVo  selectTaskList  ( Task record){
		PageVo  pageVo= new PageVo();
		List<Task>  list=taskdao.selectTaskList( record);
		  pageVo.setRoot(list);
		  pageVo.setTotal(taskdao.selectTaskCount(record));
		  return  pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=taskdao.deleteById ( id );
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
	 public boolean deleteTask( Task record ){
		 int flag=taskdao.deleteTask( record );
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
	 public boolean insertTask( Task record ){
		 int flag=taskdao.insertTask( record );
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
	 public boolean updateTask( Task record ){
		 int flag=taskdao.updateTask( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

}