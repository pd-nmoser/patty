package com.prodyna.academy.patty.domain;

import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public abstract class Node {
	private String name;
	private long size;
	private Folder parent;
	
	public String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	public long getSize() {
		return size;
	}
	void setSize(long size) {
		this.size = size;
	}
	public Node getParent() {
		return parent;
	}
	void setParent(Folder parent) {
		this.parent = parent;
	}
	void delete() {
		
	}
	List<Node> list() {
		return Collections.emptyList();
	}
}
