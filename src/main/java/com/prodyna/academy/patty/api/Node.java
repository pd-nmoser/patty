package com.prodyna.academy.patty.api;

import com.prodyna.academy.patty.api.observer.NodeObservable;
import com.prodyna.academy.patty.api.visitor.NodeVisitor;

public interface Node extends NodeObservable {

	boolean exists();
	
	String getUuid();

	Folder getParent();

	String getName();

	int getSize();

	void accept(NodeVisitor visitor);
}
