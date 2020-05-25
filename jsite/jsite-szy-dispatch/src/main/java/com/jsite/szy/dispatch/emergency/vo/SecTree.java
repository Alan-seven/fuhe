package com.jsite.szy.dispatch.emergency.vo;

import java.util.List;

/**
 * 断面树形
 * @author admin
 *
 */
public class SecTree {
	
	private String id;
	
	private String text;
	
	private boolean leaf;
	
	private boolean expanded;
	
	private List<SecTree> children;
	
	public SecTree(String id,String text,boolean leaf,boolean expanded,List<SecTree> children){
		this.id = id;
		this.text = text;
		this.leaf = leaf;
		this.expanded = expanded;
		this.children = children;
	}

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

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public List<SecTree> getChildren() {
		return children;
	}

	public void setChildren(List<SecTree> children) {
		this.children = children;
	}

}
