package com.database.service.impl;
import com.database.utils.PageVo;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;
import com.database.service.SyscodeService;
import com.database.dao.SyscodeDao;
import com.database.po.Syscode;

/**
 * 
 * SyscodeServiceImpl数据库操作接口类
 * 
 **/

@Service
public class SyscodeServiceImpl implements SyscodeService{

@Resource
private SyscodeDao syscodedao;

	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	 public Syscode  selectById (  String id ){
		Syscode syscode=syscodedao.selectById (id);
		  return syscode;
	}

	/**
	 * 
	 * 查询（根据条件查询集合）
	 * 
	 **/
		 public PageVo  selectSyscodeList  ( Syscode record){
		PageVo  pageVo= new PageVo();
		List<Syscode>  list=syscodedao.selectSyscodeList( record);
		  pageVo.setRoot(list);
		  pageVo.setTotal(syscodedao.selectSyscodeCount(record));
		  return  pageVo;
	}

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	 public boolean deleteById (  String id ){
		 int flag=syscodedao.deleteById ( id );
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
	 public boolean deleteSyscode( Syscode record ){
		 int flag=syscodedao.deleteSyscode( record );
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
	 public boolean insertSyscode( Syscode record ){
		 int flag=syscodedao.insertSyscode( record );
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
	 public boolean updateSyscode( Syscode record ){
		 int flag=syscodedao.updateSyscode( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	 }

	@Override
	public boolean insertSyscodeList(List<Syscode> record) {
		// TODO Auto-generated method stub
		 int flag=syscodedao.insertSyscodeList( record );
		 if(flag>0){
		 return true;
		 }
		 else{
		 return false;
		 }
	}

}