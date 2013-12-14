package com.prodyna.academy.patty.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.prodyna.academy.patty.api.visitor.NodePrintVisitor;

public class VisitorTest extends AbstractTest {

	private FileManager manager;

	private Folder root;

	@Before
	public void setUp() {
		manager = FileManager.getInstance();
		root = manager.getFileSystem().getRoot();
	}

	@Test
	public void visit() throws Exception {

		Folder lorem = manager.getFileFactory().createFolder("parent");
		manager.getFileSystem().add(root, lorem);

		Folder childA = manager.getFileFactory().createFolder("childA");
		manager.getFileSystem().add(lorem, childA);

		Folder childB = manager.getFileFactory().createFolder("childB");
		manager.getFileSystem().add(lorem, childB);

		TextFile t1 = manager.getFileFactory().createTextFile("lorem1.txt", getSampleText());
		TextFile t2 = manager.getFileFactory().createTextFile("lorem2.txt", getSampleText());
		TextFile t3 = manager.getFileFactory().createTextFile("lorem3.txt", getSampleText());
		TextFile t4 = manager.getFileFactory().createTextFile("lorem4.txt", getSampleText());
		TextFile t5 = manager.getFileFactory().createTextFile("lorem5.txt", getSampleText());

		manager.getFileSystem().add(lorem, t1);
		manager.getFileSystem().add(childA, t2);
		manager.getFileSystem().add(childA, t3);
		manager.getFileSystem().add(childB, t4);
		manager.getFileSystem().add(childB, t5);
		Assert.assertEquals(2955, root.getSize());

		NodePrintVisitor visitor = new NodePrintVisitor();
		root.accept(visitor);
	}

}
