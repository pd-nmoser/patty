package com.prodyna.academy.patty.api.visitor;

import com.prodyna.academy.patty.vfs.VfsFolder;
import com.prodyna.academy.patty.vfs.VfsNode;

public interface NodeVisitor {

	void visit(VfsNode node);

	void visit(VfsFolder folder);

}
