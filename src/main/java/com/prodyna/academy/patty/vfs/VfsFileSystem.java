package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.FileSystem;
import com.prodyna.academy.patty.api.Folder;
import com.prodyna.academy.patty.api.Node;

public class VfsFileSystem implements FileSystem {

	private final VfsFolder root;

	public VfsFileSystem() {
		root = new VfsFolder();
		root.setName("");
	}

	@Override
	public VfsFolder getRoot() {
		return root;
	}

	@Override
	public void add(Folder f, Node n) {
		VfsNode node = (VfsNode) n;
		node.setParent(f);
	}

	@Override
	public void rename(Node n, String name) {
		VfsNode node = (VfsNode) n;
		node.setName(name);
	}

	@Override
	public void move(Node n, Folder target) {
		VfsFolder parent = (VfsFolder) n.getParent();
		parent.getChildren().remove(n);
		VfsNode node = (VfsNode) n;
		node.setParent(target);
	}

	@Override
	public void delete(Node n) {
		VfsFolder parent = (VfsFolder) n.getParent();
		parent.getChildren().remove(n);
	}

}
