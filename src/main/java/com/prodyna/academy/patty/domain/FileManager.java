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
	Node newTextFileNode(FileType fType, String name, long size,
			String textEncoding, long pageCount) throws UnsupportedFileType;
	Node newMediaFileNode(FileType fType, String name, long size, long height,
			long width) throws UnsupportedFileType;
	Node newFolderNode(FileType fType, String name) throws UnsupportedFileType;
	public Node add(Folder parent, Node aNode);
	public Node delete(Node aNode);
	public List<Node> list(Node aNode);
	
	// observer management
	void register(NodeObserver aObserver, Node aNode);
	void unRegister(NodeObserver aObserver, Node aNode);
}
