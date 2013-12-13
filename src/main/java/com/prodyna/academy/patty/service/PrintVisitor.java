package com.prodyna.academy.patty.service;

import java.util.Set;

import com.prodyna.academy.patty.domain.Folder;
import com.prodyna.academy.patty.domain.ImageFile;
import com.prodyna.academy.patty.domain.Node;
import com.prodyna.academy.patty.domain.TextFile;
import com.prodyna.academy.patty.domain.VideoFile;

/**
 * visit all nodes and print attributes if filter matches
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class PrintVisitor implements Visitor {
	private Filter filter;
	private StringBuffer resultBuffer;

	@Override
	public void visit(ImageFile file) {
		if(filter.matches(file)) {
			String parentFolder = file.getParent().getName();
			String name = file.getName();
			long size = file.getSize();
			long height = file.getHeight();
			long width = file.getWidth();
			
			resultBuffer.append("[" + parentFolder + ": ");
			resultBuffer.append(name + " ");
			resultBuffer.append(size + " ");
			resultBuffer.append(height + "x" + width + "],");
		}
	}

	@Override
	public void visit(TextFile file) {
		if(filter.matches(file)) {
			String parentFolder = file.getParent().getName();
			String name = file.getName();
			long size = file.getSize();
			String textEncoding = file.getTextEncoding();
			long pageCount = file.getPageCount();
			
			resultBuffer.append("[" + parentFolder + ": ");
			resultBuffer.append(name + " ");
			resultBuffer.append(size + " ");
			resultBuffer.append(textEncoding + " ");
			resultBuffer.append(pageCount + "],");
		}
	}

	@Override
	public void visit(VideoFile file) {
		if(filter.matches(file)) {
			String parentFolder = file.getParent().getName();
			String name = file.getName();
			long size = file.getSize();
			long height = file.getHeight();
			long width = file.getWidth();
			
			resultBuffer.append("[" + parentFolder + ": ");
			resultBuffer.append(name);
			resultBuffer.append(size);
			resultBuffer.append(height + "x" + width + "],");
		}
	}

	@Override
	public void visit(Folder folder) {
		Set<Node> children = folder.getChildren();
		for (Node node : children) {
			node.accept(this);
		}
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public String getResultList() {
		return resultBuffer.toString();
	}
}