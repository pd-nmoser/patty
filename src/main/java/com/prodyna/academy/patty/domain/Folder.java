package com.prodyna.academy.patty.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Folder extends Node{
	private Set<Node> children = new HashSet<Node>();
	
	Folder(String name) {
		super.setName(name);
	}
	
	void add(Node node) {
		children.add(node);
	}
	
	void delete(Node node) {
		children.remove(node);
	}
	
	List<Node> list() {
		return new ArrayList<Node> (children);
	}
}
