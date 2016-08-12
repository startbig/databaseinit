package com.database.po;
import java.util.Date;
import java.io.Serializable;
import com.database.utils.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
public class Customer extends Page implements Serializable{

	//
	private String id;
	//客户号
	private String customerNum;
	//姓名
	private String customerName;
	//订单数
	private String orderNum;
	//电话
	private String customerPhone;
	//地址
	private String customerAddress;
	//QQ
	private String customerQq;
	//地点
	private String customerPlace;
	//创建人
	private String createUser;
	//创建时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;
	//更新人
	private String updateUser;
	//更新时间
	private String updateTime;

	public String  getId(){
		return id;
	}

	public void setId( String  id ){
		this.id=id;
	}

	public String  getCustomerNum(){
		return customerNum;
	}

	public void setCustomerNum( String  customerNum ){
		this.customerNum=customerNum;
	}

	public String  getCustomerName(){
		return customerName;
	}

	public void setCustomerName( String  customerName ){
		this.customerName=customerName;
	}

	public String  getOrderNum(){
		return orderNum;
	}

	public void setOrderNum( String  orderNum ){
		this.orderNum=orderNum;
	}

	public String  getCustomerPhone(){
		return customerPhone;
	}

	public void setCustomerPhone( String  customerPhone ){
		this.customerPhone=customerPhone;
	}

	public String  getCustomerAddress(){
		return customerAddress;
	}

	public void setCustomerAddress( String  customerAddress ){
		this.customerAddress=customerAddress;
	}

	public String  getCustomerQq(){
		return customerQq;
	}

	public void setCustomerQq( String  customerQq ){
		this.customerQq=customerQq;
	}

	public String  getCustomerPlace(){
		return customerPlace;
	}

	public void setCustomerPlace( String  customerPlace ){
		this.customerPlace=customerPlace;
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

	public String  getUpdateUser(){
		return updateUser;
	}

	public void setUpdateUser( String  updateUser ){
		this.updateUser=updateUser;
	}

	public String  getUpdateTime(){
		return updateTime;
	}

	public void setUpdateTime( String  updateTime ){
		this.updateTime=updateTime;
	}

}