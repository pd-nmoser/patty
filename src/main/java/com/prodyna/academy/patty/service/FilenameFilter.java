package com.prodyna.academy.patty.service;

import com.prodyna.academy.patty.domain.Node;

/**
 * return true in case of an exact match of filename
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class FilenameFilter implements Filter {
	private String filename;
	
	public FilenameFilter(String filename) {
		this.filename = filename;
	}

	@Override
	public boolean matches(Node aNode) {
		String nodeName = aNode.getName();
		
		return nodeName.equals(filename);
	}

	public String getFilename() {
		return filename;
	}
}
