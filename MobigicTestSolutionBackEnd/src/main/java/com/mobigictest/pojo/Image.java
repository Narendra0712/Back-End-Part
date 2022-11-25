package com.mobigictest.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    int id;
	
    @Column(name = "name")
    String fileName;
    
    @Lob
    @Column(name = "content")
    String content;
    
    @Column(name = "filetype")
    private String fileType;
    
    @Column(name = "uniquecode")
    private int uniqueCode;
    
	public Image() {
		
	}

	public Image(String fileName, String content, String fileType, int uniqueCode) {
		super();
		this.fileName = fileName;
		this.content = content;
		this.fileType = fileType;
		this.uniqueCode = uniqueCode;
		
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(int uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

}
