package com.prodyna.academy.patty.api.visitor;

import com.prodyna.academy.patty.vfs.VfsFolder;
import com.prodyna.academy.patty.vfs.VfsNode;

public class NodePrintVisitor extends AbstractNodeVisitor {

	@Override
	public void visit(VfsNode node) {
		System.out.println("Node: " + node.getName());
	}

	@Override
	public void visit(VfsFolder folder) {
		System.out.println("Folder: " + folder.getName());

		super.visit(folder);
	}

}
