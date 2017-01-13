package ua.com.love_travel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.love_travel.entity.Room;

public interface RoomDao extends JpaRepository<Room, Integer>{

}
