package ua.com.love_travel.editor;

import java.beans.PropertyEditorSupport;

import ua.com.love_travel.service.HotelService;



public class HotelEditor extends PropertyEditorSupport {

	private final HotelService hotelService;

	public HotelEditor(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(hotelService.findOne(Integer.parseInt(text)));
	}
}
