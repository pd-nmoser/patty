package com.prodyna.academy.patty.domain;

import java.util.Collections;
import java.util.List;

import com.prodyna.academy.patty.service.Visitor;

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

	void setName(final String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	void setSize(final long size) {
		this.size = size;
	}

	public Folder getParent() {
		return parent;
	}

	void setParent(final Folder parent) {
		this.parent = parent;
	}

	public void delete() {

	}

	public List<Node> list() {
		return Collections.emptyList();
	}

	public void accept(Visitor visitor) {

	}
}