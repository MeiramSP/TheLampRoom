package kz.saparov.room.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import kz.saparov.room.controller.RoomController;
import kz.saparov.room.entity.Country;
import kz.saparov.room.entity.Room;
import kz.saparov.room.service.CountryService;
import kz.saparov.room.service.RoomService;

@WebMvcTest(RoomController.class)
public class RoomControllerTest {
	
	@MockBean
	private RoomService roomService;
	
	@MockBean
	private CountryService countryService;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void showAllRoomsTest() throws Exception {
		
		List<Room> rooms = new ArrayList<>();
		
		Country Kaz = new Country("KZ","Казахстан");
		rooms.add(new Room(1L, "num1", false, Kaz));
		rooms.add(new Room(2L, "num2", true, Kaz));
		
		when(roomService.getAllRooms()).thenReturn(rooms);
		
        this.mockMvc
	        .perform(get("/room"))
	        .andExpect(status().isOk())
	        .andExpect(view().name("index"))
	        .andExpect(model().attribute("rooms", rooms));
    }
	
	
	@Test
	public void getRoomTest() throws Exception {
		
		Country Kaz = new Country("KZ","Казахстан");
		Room room = new Room(1L, "num1", false, Kaz);
		
		when(roomService.getRoom(1L)).thenReturn(room);
		
		mockMvc
	        .perform(get("/room/{id}", 1L))
	        .andExpect(status().isOk())
	        .andExpect(view().name("room"))
	        .andExpect(model().attribute("room", room));
	}
	
	@Test
	public void saveRoomTest() {
		
		Country Kaz = new Country("KZ","Казахстан");
		Room room = new Room(1L, "num1", false, Kaz);
		
		when(roomService.save(room)).thenReturn(room);
	}
	

}
