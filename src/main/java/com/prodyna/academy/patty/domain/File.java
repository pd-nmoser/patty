package com.prodyna.academy.patty.domain;

import java.util.List;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class File extends Node {
	
	@Override
	void delete() {
		Folder parentFolder = (Folder) getParent();
		parentFolder.deleteChild(this);
	}
	
	@Override
	List<Node> list() {
		throw new UnsupportedOperationException();
	}
}
