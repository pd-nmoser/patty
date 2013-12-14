package com.prodyna.academy.patty.vfs.visitor;

import com.prodyna.academy.patty.vfs.VfsFolder;
import com.prodyna.academy.patty.vfs.VfsNode;

public abstract class AbstractVfsVisitor implements VfsVisitor {

	@Override
	public void visit(VfsFolder folder) {
		for (VfsNode node : folder.getChildren()) {
			node.accept(this);
		}

	}

}
