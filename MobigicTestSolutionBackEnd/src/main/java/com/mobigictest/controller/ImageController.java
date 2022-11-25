package com.mobigictest.controller;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.mobigictest.daoimpl.ImageImplementation;
import com.mobigictest.pojo.Image;

@RestController
@RequestMapping("/image")
@CrossOrigin("*")
public class ImageController {

	@Autowired
	ImageImplementation imageImplementation;

	// http://localhost:9009/image/getImages
	@GetMapping("/getImages")
	public List<Image> getAllFiles() {
		return imageImplementation.getAllFiles();
	}

	// http://localhost:9009/image/uploadImage
	@PostMapping("/uploadImage")
	public String uploadImage(@RequestParam("file") MultipartFile file, Model modal) {
		try {

			String fileContentType = file.getContentType();
			String sourceFileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
			String fileName = file.getOriginalFilename();
			Integer uniqueCode = generateUniqueCode();
			Image fileModal = new Image(fileName, sourceFileContent, fileContentType, uniqueCode);

			imageImplementation.saveFileFromUser(fileModal);

		} catch (Exception e) {
			e.printStackTrace();
		}

		modal.addAttribute("allFiles", imageImplementation.getAllFiles());

		return "File Upload Successful !";
	}

	private Integer generateUniqueCode() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return Integer.parseInt(String.format("%06d", number));
	}

	//http://localhost:9009/image/delete?imageid=1
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Map<String, String>> delete(@RequestParam("imageid") String imageid) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		int id = Integer.parseInt(imageid);
		
		if(imageImplementation.deleteImage(id))
			hmap.put("msg", "Image Deleted");
		else
			hmap.put("msg", "Deletion Fail");
		
		return ResponseEntity.ok(hmap);
	}

}
