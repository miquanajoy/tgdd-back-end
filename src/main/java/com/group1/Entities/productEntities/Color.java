package com.group1.Entities.productEntities;

import java.io.Serializable;
//mqfixed
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ColorID")
	private Integer colorID;
	@Column(name = "ColorName")
	private String colorName;

	public Color() {
	}

	public Color(Integer colorID, String colorName) {
		super();
		this.colorID = colorID;
		this.colorName = colorName;
	}

	public Integer getColorID() {
		return colorID;
	}

	public void setColorID(Integer colorID) {
		this.colorID = colorID;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

}
