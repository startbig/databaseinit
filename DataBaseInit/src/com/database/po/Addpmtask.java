package com.database.po;
 import java.util.List;
import java.io.Serializable;

import com.database.utils.Page;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class Addpmtask extends Page implements Serializable {

	/****/
	private String id;

	/****/
	private String replyContent;

	/****/
	private String createUser;

	/****/
	private java.util.Date createTime;

	/****/
	private String taskId;

	/****/
	private String type;


    private String mark;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setReplyContent(String replyContent){
		this.replyContent = replyContent;
	}

	public String getReplyContent(){
		return this.replyContent;
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

	public void setTaskId(String taskId){
		this.taskId = taskId;
	}

	public String getTaskId(){
		return this.taskId;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
	}
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}
}
