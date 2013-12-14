package com.prodyna.academy.patty.vfs.visitor;

import com.prodyna.academy.patty.vfs.VfsFolder;
import com.prodyna.academy.patty.vfs.VfsNode;

public interface VfsVisitor {

	void visit(VfsNode node);
	
	void visit(VfsFolder folder);
	
}
