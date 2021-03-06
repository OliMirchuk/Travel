package ua.com.love_travel.editor;

import java.beans.PropertyEditorSupport;

import ua.com.love_travel.service.CityService;

public class CityEditor extends PropertyEditorSupport{
	
	private final CityService cityService;

	public CityEditor(CityService cityService) {
		this.cityService = cityService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(cityService.findOne(Integer.parseInt(text)));
		
	}
	
	
}
