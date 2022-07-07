package com.group1.dto;

import org.springframework.web.multipart.MultipartFile;

public class ColorVariantUpdateDTO {
	
	private MultipartFile[] updateFileDatas;
	private Integer forColorID;

	public ColorVariantUpdateDTO() {
	}

	public ColorVariantUpdateDTO(MultipartFile[] updateFileDatas, Integer forColorID) {
		super();
		this.updateFileDatas = updateFileDatas;
		this.forColorID = forColorID;
	}

	public MultipartFile[] getUpdateFileDatas() {
		return updateFileDatas;
	}

	public void setUpdateFileDatas(MultipartFile[] updateFileDatas) {
		this.updateFileDatas = updateFileDatas;
	}

	public Integer getForColorID() {
		return forColorID;
	}

	public void setForColorID(Integer forColorID) {
		this.forColorID = forColorID;
	}

	@Override
	public String toString() {
		return "forColorID=" + forColorID;
	}
	
	

}
