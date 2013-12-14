package com.prodyna.academy.patty.api;

import org.junit.Before;
import org.junit.Test;

import com.prodyna.academy.patty.api.observer.NodeRenameListener;
import com.prodyna.academy.patty.api.observer.event.NodeRenameEvent;

public class ObserverTest extends AbstractTest {

	private FileManager manager;

	private Folder root;

	@Before
	public void setUp() {
		manager = FileManager.getInstance();
		root = manager.getFileSystem().getRoot();
	}

	@Test
	public void observe() throws Exception {

		Folder foo = manager.getFileFactory().createFolder("parent");
		manager.getFileSystem().add(root, foo);

		Folder bar = manager.getFileFactory().createFolder("childA");
		manager.getFileSystem().add(foo, bar);

		TextFile text = manager.getFileFactory().createTextFile("lorem5.txt", getSampleText());
		manager.getFileSystem().add(foo, text);
		
		manager.registerListener(new SampleRenameListener());
		
		manager.getFileSystem().rename(text, "blub.txt");
	}

	private class SampleRenameListener implements NodeRenameListener {

		@Override
		public void nodeRenamed(NodeRenameEvent event) {
			System.out.println("Renamed: " + event.getSource());
			System.out.println("Old Name: " + event.getOldName());
			System.out.println("New Name: " + event.getNewName());
		}

	}

}
