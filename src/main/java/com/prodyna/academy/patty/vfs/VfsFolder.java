package com.prodyna.academy.patty.vfs;

import java.util.SortedSet;
import java.util.TreeSet;

import com.prodyna.academy.patty.api.File;
import com.prodyna.academy.patty.api.Folder;
import com.prodyna.academy.patty.api.Node;
import com.prodyna.academy.patty.api.visitor.NodeVisitor;

public class VfsFolder extends VfsNode implements Folder {

	private SortedSet<VfsNode> children = new TreeSet<VfsNode>();

	VfsFolder() {

	}

	public SortedSet<VfsNode> getChildren() {
		return children;
	}

	@Override
	public int getSize() {
		int out = 0;
		for (VfsNode node : children) {
			out += node.getSize();
		}
		return out;
	}

	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public SortedSet<File> listFiles() {
		SortedSet<File> out = new TreeSet<File>();
		for (VfsNode node : children) {
			if (node instanceof File) {
				out.add((File) node);
			}
		}
		return out;
	}

	@Override
	public SortedSet<Node> list() {
		return new TreeSet<Node>(children);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(super.toString());
		for (Node node : this.list()) {
			result.append("-");
			result.append(node.getName() + "\n");
		}
		return result.toString();
	}
}
