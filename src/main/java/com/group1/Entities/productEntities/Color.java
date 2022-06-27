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
	private String colorId;
	@Column(name = "ColorName")
	private String colorName;

	public Color() {
	}

	public Color(String colorId, String colorName) {
		super();
		this.colorId = colorId;
		this.colorName = colorName;
	}

	public String getColorId() {
		return colorId;
	}

	public void setColorId(String colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

}
