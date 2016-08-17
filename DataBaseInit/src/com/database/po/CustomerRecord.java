package com.database.po;
import java.util.Date;
import java.io.Serializable;
import com.database.utils.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
public class CustomerRecord extends Page implements Serializable{

	//
	private String id;
	//
	private String customerId;
	//
	private String createUser;
	//
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;
	//
	private String updateContent;

	public String  getId(){
		return id;
	}

	public void setId( String  id ){
		this.id=id;
	}

	public String  getCustomerId(){
		return customerId;
	}

	public void setCustomerId( String  customerId ){
		this.customerId=customerId;
	}

	public String  getCreateUser(){
		return createUser;
	}

	public void setCreateUser( String  createUser ){
		this.createUser=createUser;
	}

	public Date  getCreateTime(){
		return createTime;
	}

	public void setCreateTime( Date  createTime ){
		this.createTime=createTime;
	}

	public String  getUpdateContent(){
		return updateContent;
	}

	public void setUpdateContent( String  updateContent ){
		this.updateContent=updateContent;
	}

}