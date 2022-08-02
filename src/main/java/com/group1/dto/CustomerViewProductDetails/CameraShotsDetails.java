package com.group1.dto.CustomerViewProductDetails;

import javax.persistence.Column;
import javax.persistence.Transient;

public class CameraShotsDetails {

	private byte[] image;

	public String toShowImage;
	
	public CameraShotsDetails() {
		
	}

	public CameraShotsDetails(byte[] image) {
		super();
		this.image = image;
	}

	public CameraShotsDetails(byte[] image, String toShowImage) {
		super();
		this.image = image;
		this.toShowImage = toShowImage;
	}

	public byte[] getImage() {
		return image;
	}

	public String getToShowImage() {
		return toShowImage;
	}
	
}
