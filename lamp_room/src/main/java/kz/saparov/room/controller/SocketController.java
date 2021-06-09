package kz.saparov.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import kz.saparov.room.model.Ligth;
import kz.saparov.room.service.RoomService;

@Controller
public class SocketController {
	
	@Autowired
	private RoomService roomService;
	
	@MessageMapping("/getlight/{id}")
    @SendTo("/client/lamp/{id}")
    public Ligth greeting(Ligth ligth, @DestinationVariable Long id) {
		roomService.changeRoomLamp(id, ligth.isCondition());
        return ligth;
    }
	
	
}
