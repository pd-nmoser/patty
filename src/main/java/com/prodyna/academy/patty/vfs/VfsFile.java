package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.visitor.NodeVisitor;

public abstract class VfsFile extends VfsNode {

	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
