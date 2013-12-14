package com.prodyna.academy.patty.api.visitor;

import com.prodyna.academy.patty.vfs.VfsFolder;
import com.prodyna.academy.patty.vfs.VfsNode;

public abstract class AbstractNodeVisitor implements NodeVisitor {

	@Override
	public void visit(VfsFolder folder) {
		for (VfsNode node : folder.getChildren()) {
			node.accept(this);
		}

	}

}
