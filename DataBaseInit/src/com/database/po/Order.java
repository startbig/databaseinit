package com.database.po;
import java.util.Date;
import java.io.Serializable;

import com.database.utils.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
public class Order extends Page implements Serializable{

	//
	private String id;
	//设备id
	private String deviceId;
	//起租时间
	@JsonFormat(pattern="yyyy-MM-dd ",timezone = "GMT+8")
	private Date startrentTime;
	//退租时间
	@JsonFormat(pattern="yyyy-MM-dd ",timezone = "GMT+8")
	private Date endrentTime;
	//客户
	private String customer;
	//客户姓名
	private String customerName;
	//客户电话
	private String customerPhone;
	//客户地址
	private String customerAddress;
	//备注
	private String remark;
	//创建人
	private String createUser;
	//创建时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;

	private String brandName;
	
	private String modelName;
	
	/**设备名称**/
	private String deviceNum;
	
	
	private String customerQq;
	public String  getId(){
		return id;
	}

	public void setId( String  id ){
		this.id=id;
	}

	public String  getDeviceId(){
		return deviceId;
	}

	public void setDeviceId( String  deviceId ){
		this.deviceId=deviceId;
	}

	public Date  getStartrentTime(){
		return startrentTime;
	}

	public void setStartrentTime( Date  startrentTime ){
		this.startrentTime=startrentTime;
	}

	public Date  getEndrentTime(){
		return endrentTime;
	}

	public void setEndrentTime( Date  endrentTime ){
		this.endrentTime=endrentTime;
	}

	public String  getCustomer(){
		return customer;
	}

	public void setCustomer( String  customer ){
		this.customer=customer;
	}

	public String  getCustomerName(){
		return customerName;
	}

	public void setCustomerName( String  customerName ){
		this.customerName=customerName;
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

	public String  getRemark(){
		return remark;
	}

	public void setRemark( String  remark ){
		this.remark=remark;
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

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getDeviceNum() {
		return deviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}

	public String getCustomerQq() {
		return customerQq;
	}

	public void setCustomerQq(String customerQq) {
		this.customerQq = customerQq;
	}

}