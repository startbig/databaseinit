package com.database.po;
import java.util.Date;
import java.io.Serializable;
import com.database.utils.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
public class Syscode extends Page implements Serializable{

	//
	private String id;
	//Code
	private String syscode;
	//类型
	private String systype;
	//创建人
	private String createUser;
	//创建时间
	private String createTime;

	public String  getId(){
		return id;
	}

	public void setId( String  id ){
		this.id=id;
	}

	public String  getSyscode(){
		return syscode;
	}

	public void setSyscode( String  syscode ){
		this.syscode=syscode;
	}

	public String  getSystype(){
		return systype;
	}

	public void setSystype( String  systype ){
		this.systype=systype;
	}

	public String  getCreateUser(){
		return createUser;
	}

	public void setCreateUser( String  createUser ){
		this.createUser=createUser;
	}

	public String  getCreateTime(){
		return createTime;
	}

	public void setCreateTime( String  createTime ){
		this.createTime=createTime;
	}

}