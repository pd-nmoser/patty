/**
 * 
 */
package com.prodyna.academy.patty.domain;

import java.util.List;

import javax.annotation.PostConstruct;

/**
 * implements a file manager as a singleton.
 * 
 * @author aheizenreder
 *
 */
public class VirtualFileManager implements FileManager {

	private static FileManager fileManager;
	
	private Folder root;
	
	public synchronized static FileManager getInstance() {
		if(fileManager == null) {
			fileManager = new VirtualFileManager();
		}
		return fileManager;
	}
	
	private VirtualFileManager() {
		
	}
	
	@PostConstruct
	private void init() {
		root = FilesystemAbstractFactory.createFolder("/");
	}
	
	/* (non-Javadoc)
	 * @see com.prodyna.academy.patty.domain.NodeObserver#notifyObserver()
	 */
	public void notifyObserver() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.prodyna.academy.patty.domain.FileManager#getRoot()
	 */
	public Folder getRoot() {
		return root;
	}

	/* (non-Javadoc)
	 * @see com.prodyna.academy.patty.domain.FileManager#newNode(com.prodyna.academy.patty.domain.FileType)
	 */
	public Node newNode(FileType fType) {
		Node node;
		
		switch(fType) {
		case FOLDER:
			node = FilesystemAbstractFactory.createFolder(name);
			break;
		case IMAGE:
			node = FilesystemAbstractFactory.createImageFile(name, size, height, width);
			break;
		case TEXT:
			node = FilesystemAbstractFactory.createTextFile(name, size, textEncoding, pageCount);
			break;
		case VIDEO:
			node = FilesystemAbstractFactory.createVideoFile(name, size, height, width);
			break;
		default:
			throw new UnsupportedFileType();
			break;
		}
		
		return node;
	}

	/* (non-Javadoc)
	 * @see com.prodyna.academy.patty.domain.FileManager#add(com.prodyna.academy.patty.domain.Folder, com.prodyna.academy.patty.domain.Node)
	 */
	public Node add(Folder parent, Node aNode) {
		parent.add(aNode);
		return aNode;
	}

	/* (non-Javadoc)
	 * @see com.prodyna.academy.patty.domain.FileManager#delete(com.prodyna.academy.patty.domain.Node)
	 */
	public Node delete(Node aNode) {
		aNode.delete();
		return aNode;
	}

	/* (non-Javadoc)
	 * @see com.prodyna.academy.patty.domain.FileManager#list(com.prodyna.academy.patty.domain.Node)
	 */
	public List<Node> list(Node aNode) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.prodyna.academy.patty.domain.FileManager#register(com.prodyna.academy.patty.domain.NodeObserver, com.prodyna.academy.patty.domain.Node)
	 */
	public void register(NodeObserver aObserver, Node aNode) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.prodyna.academy.patty.domain.FileManager#unRegister(com.prodyna.academy.patty.domain.NodeObserver)
	 */
	public void unRegister(NodeObserver aObserver) {
		// TODO Auto-generated method stub

	}

}
