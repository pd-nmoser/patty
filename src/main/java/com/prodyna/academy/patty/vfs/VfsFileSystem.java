package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.FileSystem;
import com.prodyna.academy.patty.api.Folder;
import com.prodyna.academy.patty.api.Node;
import com.prodyna.academy.patty.api.observer.NodeChangeListener;
import com.prodyna.academy.patty.api.observer.NodeObserver;
import com.prodyna.academy.patty.api.observer.NodeRenameListener;
import com.prodyna.academy.patty.api.observer.OberverSupport;
import com.prodyna.academy.patty.api.observer.NodeObservable;
import com.prodyna.academy.patty.api.observer.event.NodeChangeEvent;
import com.prodyna.academy.patty.api.observer.event.NodeChangeType;
import com.prodyna.academy.patty.api.observer.event.NodeRenameEvent;

public class VfsFileSystem implements FileSystem, NodeChangeListener, NodeRenameListener, NodeObservable {

	private final VfsFolder root;

	private OberverSupport oberverSupport = new OberverSupport();

	public VfsFileSystem() {
		root = new VfsFolder();
		root.setName("/");

		root.registerListener(this);
	}

	@Override
	public VfsFolder getRoot() {
		return root;
	}

	@Override
	public void add(Folder f, Node n) {
		VfsNode node = (VfsNode) n;
		node.setParent(f);

		node.registerListener(this);

		oberverSupport.fireChangeEvent(n, NodeChangeType.CREATE);
	}

	@Override
	public void rename(Node n, String name) {
		checkExistence(n);
		VfsNode node = (VfsNode) n;
		node.setName(name);
	}

	@Override
	public void move(Node n, Folder target) {
		checkExistence(n);
		VfsFolder parent = (VfsFolder) n.getParent();
		parent.getChildren().remove(n);
		VfsNode node = (VfsNode) n;
		node.setParent(target);
	}

	@Override
	public void delete(Node n) {
		checkExistence(n);

		VfsFolder parent = (VfsFolder) n.getParent();
		parent.getChildren().remove(n);

		VfsNode node = (VfsNode) n;
		node.setExist(false);

		oberverSupport.fireChangeEvent(n, NodeChangeType.DELETE);
	}

	private void checkExistence(Node n) {
		if (!n.exists()) {
			throw new IllegalStateException("File does not exist!");
		}
	}

	@Override
	public void registerListener(NodeObserver listener) {
		oberverSupport.addListener(listener);
	}

	@Override
	public void unregisterListener(NodeObserver listener) {
		oberverSupport.removeListener(listener);
	}

	@Override
	public void nodeChange(NodeChangeEvent event) {
		oberverSupport.fireChangeEvent(event);
	}

	@Override
	public void nodeRenamed(NodeRenameEvent event) {
		oberverSupport.fireRenameEvent(event);
	}

}
