package com.database.po;
 import java.util.List;
import java.io.Serializable;

import com.database.utils.Page;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class GeneExport extends Page implements Serializable {

	/****/
	private String id;

	/**导出数**/
	private Integer exportNum;
	
	private Integer sumNum;

	/**创建人**/
	private String createUser;

	/**创建时间**/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	private java.util.Date createTime;
	
	@SuppressWarnings("rawtypes")
	private List exportList;



	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setExportNum(Integer exportNum){
		this.exportNum = exportNum;
	}

	public Integer getExportNum(){
		return this.exportNum;
	}

	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}

	public String getCreateUser(){
		return this.createUser;
	}

	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}

	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public List getExportList() {
		return exportList;
	}

	public void setExportList(List exportList) {
		this.exportList = exportList;
	}

	public Integer getSumNum() {
		return sumNum;
	}

	public void setSumNum(Integer sumNum) {
		this.sumNum = sumNum;
	}

}
