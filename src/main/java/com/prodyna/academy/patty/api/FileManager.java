package com.prodyna.academy.patty.api;

import com.prodyna.academy.patty.vfs.VfsFileFactory;
import com.prodyna.academy.patty.vfs.VfsFileSystem;

public class FileManager {

	private static FileManager FILE_MANAGER = new FileManager();

	private FileFactory fileFactory;

	private FileSystem fileSystem;

	private FileManager() {
		fileFactory = new VfsFileFactory();
		fileSystem = new VfsFileSystem();
	}

	public static FileManager getInstance() {
		return FILE_MANAGER;
	}

	public FileSystem getFileSystem() {
		return fileSystem;
	}

	public FileFactory getFileFactory() {
		return fileFactory;
	}

}
