package com.group1.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group1.entities.product.Color;
import com.group1.repositories.product.ColorRepo;

@Service
public class ColorService {

	@Resource
	ColorRepo  colorReposit;
	
	public List<Color> retrieveAllColors()
	{
		List<Color> colorList = colorReposit.getColorList();
		return colorList;
	}
}
