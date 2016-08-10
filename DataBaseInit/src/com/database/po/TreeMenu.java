package com.database.po;

import java.util.List;

public class TreeMenu {
	
	private String id;
	private String text;
	private String xtype;
	private boolean leaf;
	private boolean  expanded;
	private List<TreeMenu> children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getXtype() {
		return xtype;
	}
	public void setXtype(String xtype) {
		this.xtype = xtype;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public List<TreeMenu> getChildren() {
		return children;
	}
	public void setChildren(List<TreeMenu> children) {
		this.children = children;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	

}
