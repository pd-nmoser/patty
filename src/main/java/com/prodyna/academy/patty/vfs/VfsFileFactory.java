package com.prodyna.academy.patty.vfs;

import com.prodyna.academy.patty.api.FileFactory;
import com.prodyna.academy.patty.api.Folder;

public class VfsFileFactory implements FileFactory {

	@Override
	public VfsTextFile createTextFile(String name, String content) {
		if (content == null)
			throw new NullPointerException("Content cannot be null.");
		VfsTextFile out = new VfsTextFile();
		out.setName(name);
		out.setContent(content);
		return out;
	}

	@Override
	public VfsImageFile createImageFile(String name, byte[] content) {
		if (content == null)
			throw new NullPointerException("Content cannot be null.");
		VfsImageFile out = new VfsImageFile();
		out.setName(name);
		out.setContent(content);
		return out;
	}

	@Override
	public VfsVideoFile createVideoFile(String name, byte[] content) {
		if (content == null)
			throw new NullPointerException("Content cannot be null.");
		VfsVideoFile out = new VfsVideoFile();
		out.setName(name);
		out.setContent(content);
		return out;
	}

	@Override
	public Folder createFolder(String name) {
		VfsFolder folder = new VfsFolder();
		folder.setName(name);
		return folder;
	}

}
