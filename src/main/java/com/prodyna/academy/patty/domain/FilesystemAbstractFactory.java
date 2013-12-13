package com.prodyna.academy.patty.domain;

/**
 * 
 * @author Martin Monshausen, PRODYNA AG
 */
public class FilesystemAbstractFactory {
	
	public static Folder createFolder(String name) {
		return new Folder(name);
	}
	
	public static ImageFile createImageFile(String name, long size, long height, long width) {
		return new ImageFile(name, size, height, width);
	}
	
	public static TextFile createTextFile(String name, long size, String textEncoding, long pageCount) {
		return new TextFile(name, size, textEncoding, pageCount);
	}
	
	public static VideoFile createVideoFile(String name, long size, long height, long width) {
		return new VideoFile(name,size,height,width);
	}
}
