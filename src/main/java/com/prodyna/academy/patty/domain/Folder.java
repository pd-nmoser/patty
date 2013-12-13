package com.prodyna.academy.patty.domain;

import java.util.HashSet;
import java.util.Set;

public class Folder extends Node{
	private Set<Node> children = new HashSet<Node>();
	
	void add(Node node) {
		children.add(node);
	}
	
	void delete(Node node) {
		children.remove(node);
	}
}
