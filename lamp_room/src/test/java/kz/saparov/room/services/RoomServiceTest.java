package kz.saparov.room.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import kz.saparov.room.entity.Country;
import kz.saparov.room.entity.Room;
import kz.saparov.room.repository.RoomRepository;
import kz.saparov.room.service.RoomService;

@RunWith(MockitoJUnitRunner.class)
public class RoomServiceTest {
	
	@Mock
	RoomRepository roomRepository;
	
	@InjectMocks
	RoomService roomService;
	
	@Test
	public void getAllRoomsTest() {
		List<Room> list = new ArrayList<>();
		Country Kaz = new Country("KZ","Казахстан");
		
		list.add(new Room(1L, "num1", false, Kaz));
		list.add(new Room(2L, "num2", true, Kaz));
		list.add(new Room(3L, "num3", false, Kaz));
		
		when(roomRepository.findAll()).thenReturn(list);
		
		List<Room> roomList = roomService.getAllRooms();
		
		assertEquals(3, roomList.size());
        verify(roomRepository, times(1)).findAll();
	}
	
	@Test
	public void findRoomByIdTest() {
		Country Kaz = new Country("KZ","Казахстан");
		when(roomRepository.getById(1L)).thenReturn(new Room(1L, "num1", false, Kaz));
		
		Room room = roomService.getRoom(1L);
		
		assertEquals("num1", room.getName());
		assertEquals(Kaz, room.getCountry());
		assertEquals(false, room.isLigthOn());
	}
	
	@Test
	public void saveRoomByTest() {
		
		Country Kaz = new Country("KZ","Казахстан");
		Room room = new Room(1L, "num1", false, Kaz);
		
		roomService.save(room);
		verify(roomRepository, times(1)).save(room);
	}
}
