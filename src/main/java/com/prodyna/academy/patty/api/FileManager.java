package com.prodyna.academy.patty.api;

import com.prodyna.academy.patty.api.observer.NodeChangeListener;
import com.prodyna.academy.patty.api.observer.NodeObservable;
import com.prodyna.academy.patty.api.observer.NodeObserver;
import com.prodyna.academy.patty.api.observer.NodeRenameListener;
import com.prodyna.academy.patty.api.observer.OberverSupport;
import com.prodyna.academy.patty.api.observer.event.NodeChangeEvent;
import com.prodyna.academy.patty.api.observer.event.NodeRenameEvent;
import com.prodyna.academy.patty.vfs.VfsFileFactory;
import com.prodyna.academy.patty.vfs.VfsFileSystem;

public class FileManager implements NodeObservable, NodeChangeListener, NodeRenameListener {

	private static final FileManager FILE_MANAGER = new FileManager();

	private FileFactory fileFactory;

	private FileSystem fileSystem;

	private OberverSupport oberverSupport = new OberverSupport();

	private FileManager() {
		fileFactory = new VfsFileFactory();
		fileSystem = new VfsFileSystem();
		fileSystem.registerListener(this);
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

	@Override
	public void registerListener(NodeObserver listener) {
		oberverSupport.addListener(listener);
	}

	@Override
	public void unregisterListener(NodeObserver listener) {
		oberverSupport.removeListener(listener);
	}

	@Override
	public void nodeChange(NodeChangeEvent event) {
		oberverSupport.fireChangeEvent(event);
	}

	@Override
	public void nodeRenamed(NodeRenameEvent event) {
		oberverSupport.fireRenameEvent(event);
	}
}
