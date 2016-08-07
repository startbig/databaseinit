package com.database.utils;

public class Page {
	/**
	 * 查询页码显示条数
	 */
	private Integer pageSize=20;//每页条数
	/**
	 * 查询当前页码
	 */
	private Integer currPage=1;//当前页
	/**
	 * 查询起始行号
	 */
	private Integer startRow;//起始行号（根据当前页码自动计算）
	/**
	 * 查询截止行号
	 */
	private Integer endRow;//截止行号（根据当前页码自动计算）

	

	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStartRow() {
		startRow=(currPage-1)*pageSize;
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getEndRow() {
		endRow=currPage*pageSize;
		return endRow;
	}
	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}

}
