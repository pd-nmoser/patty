package com.prodyna.academy.patty.service;

import com.prodyna.academy.patty.domain.ImageFile;
import com.prodyna.academy.patty.domain.Node;

/**
 * return true in case node is a ImageFile
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class ImageFilter implements Filter {

	@Override
	public boolean matches(final Node aNode) {
		return (aNode instanceof ImageFile);
	}
}
