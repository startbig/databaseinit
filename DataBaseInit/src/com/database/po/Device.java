package com.database.po;
 import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.database.utils.Page;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class Device extends Page implements Serializable {

	/****/
	private String id;

	/**设备名称**/
	private String deviceNum;

	/**价格**/
	private java.math.BigDecimal price;

	/**创建时间**/
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  
	private Date createTime;

	/**创建人**/
	private String createUser;

	/**状态**/
	private String status;

	/**成色**/
	private String deviceCondition;

	/**uv镜**/
	private String uvmirror;

	/****/
	private 	java.math.BigDecimal rate;

	/**遮光罩**/
	private String lenshood;

	/**供应商**/
	private String supplier;

	/****/
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")  
	private Date storageTime;

	/****/
	private String remark;



	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setDeviceNum(String deviceNum){
		this.deviceNum = deviceNum;
	}

	public String getDeviceNum(){
		return this.deviceNum;
	}

	public void setPrice(java.math.BigDecimal price){
		this.price = price;
	}

	public java.math.BigDecimal getPrice(){
		return this.price;
	}

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public Date getCreateTime(){
		return this.createTime;
	}

	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}

	public String getCreateUser(){
		return this.createUser;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return this.status;
	}



	public String getDeviceCondition() {
		return deviceCondition;
	}

	public void setDeviceCondition(String deviceCondition) {
		this.deviceCondition = deviceCondition;
	}

	public String getUvmirror() {
		return uvmirror;
	}

	public void setUvmirror(String uvmirror) {
		this.uvmirror = uvmirror;
	}

	public java.math.BigDecimal getRate() {
		return rate;
	}

	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
	}

	public void setLenshood(String lenshood){
		this.lenshood = lenshood;
	}

	public String getLenshood(){
		return this.lenshood;
	}

	public void setSupplier(String supplier){
		this.supplier = supplier;
	}

	public String getSupplier(){
		return this.supplier;
	}

	public void setStorageTime(Date storageTime){
		this.storageTime = storageTime;
	}

	public Date getStorageTime(){
		return this.storageTime;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

}
