package kz.saparov.room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kz.saparov.room.entity.Room;
import kz.saparov.room.repository.RoomRepository;

@Service
public class RoomService {
	
	private RoomRepository roomRepository;
	
	@Autowired
	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

	public Room getRoom(Long id) {
		return roomRepository.getById(id);
	}
	
	public Room save(Room room) {
		return roomRepository.save(room);
	}
	
	@Transactional
	public void changeRoomLamp(Long id, boolean ligth) {
		roomRepository.changeRoomLigth(id, ligth);
	}
}
