package com.group1.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Color implements Serializable{
	@Id
	private String ColorID;
	private String ColorName;

	public Color() {
	}

	public Color(String colorID, String colorName) {
		super();
		ColorID = colorID;
		ColorName = colorName;
	}

	public String getColorID() {
		return ColorID;
	}

	public void setColorID(String colorID) {
		ColorID = colorID;
	}

	public String getColorName() {
		return ColorName;
	}

	public void setColorName(String colorName) {
		ColorName = colorName;
	}

	

}
