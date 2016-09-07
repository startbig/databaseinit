package com.database.po;
import java.util.Date;
import java.io.Serializable;
import com.database.utils.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
public class RolesResources extends Page implements Serializable{

	//
	private String id;
	//
	private String roleId;
	//
	private String resourceId;
	
	private String resourceName;
	private String resourceUrl;
	public String  getId(){
		return id;
	}

	public void setId( String  id ){
		this.id=id;
	}

	public String  getRoleId(){
		return roleId;
	}

	public void setRoleId( String  roleId ){
		this.roleId=roleId;
	}

	public String  getResourceId(){
		return resourceId;
	}

	public void setResourceId( String  resourceId ){
		this.resourceId=resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

}