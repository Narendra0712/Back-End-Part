package com.mobigictest.dao;

import java.util.List;

import com.mobigictest.pojo.Image;

public interface ImageDao {
	List<Image> getAllFiles();
	void saveFileFromUser(Image fileList);
	boolean deleteImage(int imageid);
}
