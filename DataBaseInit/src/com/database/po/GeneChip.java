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
public class GeneChip extends Page implements Serializable {

	/****/
	private String id;

	/****/
	private String geneId;

	/**上机芯片**/
	private String chip;

	/**创建人**/
	private String createUser;

	/**创建时间**/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	private java.util.Date createTime;



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

	public void setChip(String chip){
		this.chip = chip;
	}

	public String getChip(){
		return this.chip;
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

}
