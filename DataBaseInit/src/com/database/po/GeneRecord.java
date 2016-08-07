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
public class GeneRecord extends Page implements Serializable {

	/****/
	private String id;

	/****/
	private String geneId;

	/**修改项**/
	private String term;

	/**修改前**/
	private String oldInfo;

	/**修改后**/
	private String newInfo;

	/**修改人**/
	private String createUser;

	/**修改时间**/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	private java.util.Date createTime;

	/**修改原因**/
	private String updateReason;



	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setGeneId(String geneId){
		this.geneId = geneId;
	}

	public String getGeneId(){
		return this.geneId;
	}

	public void setTerm(String term){
		this.term = term;
	}

	public String getTerm(){
		return this.term;
	}

	public void setOldInfo(String oldInfo){
		this.oldInfo = oldInfo;
	}

	public String getOldInfo(){
		return this.oldInfo;
	}

	public void setNewInfo(String newInfo){
		this.newInfo = newInfo;
	}

	public String getNewInfo(){
		return this.newInfo;
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

	public void setUpdateReason(String updateReason){
		this.updateReason = updateReason;
	}

	public String getUpdateReason(){
		return this.updateReason;
	}

}
