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
public class TableColumn extends Page implements Serializable {

	/****/
	private String id;

	/**表id**/
	private String tableId;

	/**字段名称**/
	private String columnName;

	/**字段类型**/
	private String columnType;

	/**表备注**/
	private String columnComment;



	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setTableId(String tableId){
		this.tableId = tableId;
	}

	public String getTableId(){
		return this.tableId;
	}

	public void setColumnName(String columnName){
		this.columnName = columnName;
	}

	public String getColumnName(){
		return this.columnName;
	}

	public void setColumnType(String columnType){
		this.columnType = columnType;
	}

	public String getColumnType(){
		return this.columnType;
	}

	public void setColumnComment(String columnComment){
		this.columnComment = columnComment;
	}

	public String getColumnComment(){
		return this.columnComment;
	}

}
