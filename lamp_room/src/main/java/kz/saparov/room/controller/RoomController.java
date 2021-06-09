package kz.saparov.room.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kz.saparov.room.entity.Country;
import kz.saparov.room.entity.Room;
import kz.saparov.room.service.CountryService;
import kz.saparov.room.service.RequestService;
import kz.saparov.room.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	private RoomService roomService;
	private CountryService countryService;
	private RequestService requestService;

	@Autowired
	public RoomController(RoomService roomService, CountryService countryService, RequestService requestService) {
		this.roomService = roomService;
		this.countryService = countryService;
		this.requestService = requestService;
	}
	
	@GetMapping()
	public String showAll(Model model) {
		List<Room> rooms = roomService.getAllRooms();
		model.addAttribute("rooms", rooms);
		return "room/index";
	}
	
	@GetMapping("{id}")
    public String findRoom(@PathVariable Long id, Model model, HttpServletRequest request) {
		
		Country clientCountry = countryService.getClientCountryByIp(
				requestService.getClientIp(request));
		
		System.out.println(clientCountry.getCode());		
		Room room = roomService.getRoom(id);
		if(room.getCountry().equals(clientCountry)) {
			model.addAttribute("room", room);
			return "room/room";
		}
		return "room/error";
    }
	
	@GetMapping("new")
    public String createRoom(Model model) {
		model.addAttribute("room", new Room());
		model.addAttribute("countries", countryService.showAll());
		return "room/create_room";
    }
	
	@PostMapping() 
	public String createRoom(@ModelAttribute Room room) {
		roomService.save(room);
		return "redirect:room";
	}
}
