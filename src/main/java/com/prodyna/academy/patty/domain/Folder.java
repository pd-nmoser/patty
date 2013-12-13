package com.prodyna.academy.patty.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class Folder extends Node{
	private final Set<Node> children = new HashSet<Node>();
	
	Folder(final String name) {
		super.setName(name);
	}
	
	public void add(final Node node) {
		node.setParent(this);
		children.add(node);
	}
	
	public void deleteChild(final Node node) {
		children.remove(node);
	}
	
	@Override
	public void delete() {
		for (final Node child : children) {
			child.delete();
		}
		
		final Folder parentFolder = (Folder) getParent();
		parentFolder.deleteChild(this);
	}
	
	@Override
	public List<Node> list() {
		return new ArrayList<Node> (children);
	}
}
