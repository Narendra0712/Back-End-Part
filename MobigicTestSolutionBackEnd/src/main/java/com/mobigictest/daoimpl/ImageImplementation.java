package com.mobigictest.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mobigictest.dao.ImageDao;
import com.mobigictest.pojo.Image;
import com.mobigictest.repository.ImageRepository;

@Service
public class ImageImplementation implements ImageDao{

	@Autowired 
	ImageRepository imageRepository;
	 
	@Override
	public List<Image> getAllFiles() {
		
		List<Image> allfiles = imageRepository.findAll();
		
		return allfiles;
	}

	@Override
	public void saveFileFromUser(Image file) {
		imageRepository.save(file);
	}

	@Override
	public boolean deleteImage(int imageid) {
		try {
			Optional<Image> opt = imageRepository.findById(imageid);
			
			if (opt.isPresent()) {
				imageRepository.deleteById(imageid);
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
