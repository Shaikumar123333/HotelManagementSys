package org.example.hotelmanagesys.controller;

import lombok.AllArgsConstructor;
import org.example.hotelmanagesys.Dto.RoomDTO;
import org.example.hotelmanagesys.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@AllArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public RoomDTO createRoom(@RequestBody RoomDTO roomDTO){
        return roomService.createRoom(roomDTO);
    }

    @GetMapping
    public List<RoomDTO> getAllrooms(){
        return roomService.getAllRoom();
    }

    @GetMapping("/{id}")
    public RoomDTO getbyId(@PathVariable long id){
        return roomService.getByhotelId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteroom(@PathVariable long id){
        return roomService.deleteHotel(id);
    }

}
