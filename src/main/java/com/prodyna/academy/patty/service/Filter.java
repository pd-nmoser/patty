package com.prodyna.academy.patty.service;

import com.prodyna.academy.patty.domain.Node;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public interface Filter {
	boolean matches(Node aNode);
}
