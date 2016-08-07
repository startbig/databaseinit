package com.database.po;
 import java.util.List;
import java.io.Serializable;
import com.database.utils.Page;


/**
 * 
 * 品牌表
 * 
 **/
@SuppressWarnings("serial")
public class Brand extends Page implements Serializable {

	/****/
	private String id;

	/**品牌名称**/
	private String brandName;

	/**创建人**/
	private String createUser;

	/**创建时间**/
	private java.util.Date createTime;

	/**修改人**/
	private String updateUser;

	/**修改时间**/
	private String updateTime;



	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setBrandName(String brandName){
		this.brandName = brandName;
	}

	public String getBrandName(){
		return this.brandName;
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

	public void setUpdateUser(String updateUser){
		this.updateUser = updateUser;
	}

	public String getUpdateUser(){
		return this.updateUser;
	}

	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}

	public String getUpdateTime(){
		return this.updateTime;
	}

}
