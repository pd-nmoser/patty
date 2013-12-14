package com.prodyna.academy.patty.api;

import com.prodyna.academy.patty.api.observer.NodeObservable;

public interface FileSystem extends NodeObservable {

	Folder getRoot();

	void add(Folder f, Node n);

	void rename(Node n, String name);

	void move(Node n, Folder target);

	void delete(Node n);

}
