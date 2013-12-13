package com.prodyna.academy.patty.domain;

import java.util.List;

/**
 * This is the interface for file manager of a virtual file system.
 * 
 * @author aheizenreder
 *
 */
public interface FileManager extends NodeObserver {

	// entry point
	public Folder getRoot();
	
	// structure methods
	public Node newNode(FileType fType);
	public Node add(Folder parent, Node aNode);
	public Node delete(Node aNode);
	public List<Node> list(Node aNode);
	
	// observer management
	public void register(NodeObserver aObserver, Node aNode);
	public void unRegister(NodeObserver aObserver);
	
}
