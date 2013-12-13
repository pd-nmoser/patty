package com.prodyna.academy.patty.domain;

public class File extends Node {
	
	@Override
	void delete() {
		Folder parentFolder = (Folder) getParent();
		parentFolder.deleteChild(this);
	}
}
