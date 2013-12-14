package com.prodyna.academy.patty.api;

import java.util.SortedSet;

public interface Folder extends Node {

	SortedSet<Node> list();

	SortedSet<File> listFiles();

}
