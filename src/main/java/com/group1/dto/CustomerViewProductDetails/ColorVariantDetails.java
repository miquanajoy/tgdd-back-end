package com.group1.dto.CustomerViewProductDetails;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.group1.entities.product.Color;

public class ColorVariantDetails {

	private Integer colorID;
	
	public String colorName;
	
	private byte[] image;
	
	public String toShowImage;
	
	public ColorVariantDetails() {

	}
	
	public ColorVariantDetails(String colorName) {
		super();
		this.colorName = colorName;
	}

	public ColorVariantDetails(Integer colorID, byte[] image) {
		super();
		this.colorID = colorID;
		this.image = image;
	}

	public ColorVariantDetails(Integer colorID, String colorName, byte[] image) {
		super();
		this.colorID = colorID;
		this.colorName = colorName;
		this.image = image;
	}

	public ColorVariantDetails(Integer colorID, String colorName, byte[] image, String toShowImage) {
		super();
		this.colorID = colorID;
		this.colorName = colorName;
		this.image = image;
		this.toShowImage = toShowImage;
	}

	public Integer getColorID() {
		return colorID;
	}

	public String getColorName() {
		return colorName;
	}

	public byte[] getImage() {
		return image;
	}

	public String getToShowImage() {
		return toShowImage;
	}

	@Override
	public String toString() {
		return "colorID=" + colorID + "\n       colorName=" + colorName ;
	}

}
