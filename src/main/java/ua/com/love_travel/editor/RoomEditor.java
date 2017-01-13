package ua.com.love_travel.editor;

import java.beans.PropertyEditorSupport;

import ua.com.love_travel.service.RoomService;

public class RoomEditor extends PropertyEditorSupport{

	private final RoomService roomService;

	public RoomEditor(RoomService roomService) {
		this.roomService = roomService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(roomService.findOne(Integer.parseInt(text)));
	}
	
	
}
