package com.database.po;

import java.util.List;

public class UserTreeMenu {
	
	private String id;
	private String text;
	private String xtype;
	private boolean leaf;
	private boolean checked;
	private boolean  expanded;
	private List<UserTreeMenu> children;
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
	public List<UserTreeMenu> getChildren() {
		return children;
	}
	public void setChildren(List<UserTreeMenu> children) {
		this.children = children;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	

}
