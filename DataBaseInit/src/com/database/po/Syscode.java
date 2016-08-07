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
public class Syscode extends Page implements Serializable {

	/****/
	private String id;

	/**key**/
	private String key;

	/**value**/
	private String value;

	/**类型**/
	private String type;

	/**备注**/
	private String remark;



	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return this.key;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return this.value;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

}
