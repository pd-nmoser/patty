package com.prodyna.academy.patty.api;

public interface Node {

	String getUuid();

	Folder getParent();

	String getName();

	int getSize();

}
