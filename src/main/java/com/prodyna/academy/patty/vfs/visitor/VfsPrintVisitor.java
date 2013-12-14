package com.prodyna.academy.patty.vfs.visitor;

import com.prodyna.academy.patty.vfs.VfsFolder;
import com.prodyna.academy.patty.vfs.VfsNode;

public class VfsPrintVisitor extends AbstractVfsVisitor {

	@Override
	public void visit(VfsNode node) {

	}

	@Override
	public void visit(VfsFolder folder) {
		super.visit(folder);
	}

}
