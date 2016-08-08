package com.database.po;
import java.util.Date;
import java.io.Serializable;
import com.database.utils.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
public class Model extends Page implements Serializable{

	//
	private String id;
	//型号
	private String modelName;
	//品牌id
	private String brandId;
	//品牌名称
	private String brandName;
	//创建人
	private String createUser;
	//创建时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;

	public String  getId(){
		return id;
	}

	public void setId( String  id ){
		this.id=id;
	}

	public String  getModelName(){
		return modelName;
	}

	public void setModelName( String  modelName ){
		this.modelName=modelName;
	}

	public String  getBrandId(){
		return brandId;
	}

	public void setBrandId( String  brandId ){
		this.brandId=brandId;
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
  
}