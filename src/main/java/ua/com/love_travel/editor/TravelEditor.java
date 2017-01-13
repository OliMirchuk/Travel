package ua.com.love_travel.editor;

import java.beans.PropertyEditorSupport;

import ua.com.love_travel.service.TravelService;

public class TravelEditor extends PropertyEditorSupport{

	private final TravelService travelService;

	public TravelEditor(TravelService travelService) {
		this.travelService = travelService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(travelService.findOne(Integer.parseInt(text)));
	}
	
	
}
