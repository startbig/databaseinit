package com.database.po;
 import java.util.List;
import java.io.Serializable;
import com.database.utils.Page;


/**
 * 
 * 数据库表名
 * 
 **/
@SuppressWarnings("serial")
public class Table extends Page implements Serializable {

	/****/
	private String id;

	/**表名**/
	private String tableName;

	/**表备注**/
	private String tableComment;

	/**创建人**/
	private String createUser;

	/**创建时间**/
	private java.util.Date createTime;

	private List<TableColumn> tableColumn;


	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setTableName(String tableName){
		this.tableName = tableName;
	}

	public String getTableName(){
		return this.tableName;
	}

	public void setTableComment(String tableComment){
		this.tableComment = tableComment;
	}

	public String getTableComment(){
		return this.tableComment;
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

	public List<TableColumn> getTableColumn() {
		return tableColumn;
	}

	public void setTableColumn(List<TableColumn> tableColumn) {
		this.tableColumn = tableColumn;
	}



}
