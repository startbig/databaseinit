package com.database.utils;

import java.util.List;

/**
 * 通用数据封装
 * @author 张杰明 2013-3-30 下午05:59:46
 * @company 华大健康科技 All Rights Reserved
 * 
 */
public class PageVo {
	
	@SuppressWarnings("unchecked")
	private List root;//结构数据
	private boolean success;//返回状态  返回false页面会显示加载失败
	private String msg;//交互消息
	private Integer total;//总记录数 不分页不需要
	public PageVo()
	{	}
	@SuppressWarnings("unchecked")
	public PageVo(Integer total,List root)
	{
		this.total=total;
		this.root=root;
	}
	@SuppressWarnings("unchecked")
	public List getRoot() {
		return root;
	}

	@SuppressWarnings("unchecked")
	public void setRoot(List root) {
		this.root = root;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
