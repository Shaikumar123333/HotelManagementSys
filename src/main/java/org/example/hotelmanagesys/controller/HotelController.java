package org.example.hotelmanagesys.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hotelmanagesys.Dto.HotelDTO;
import org.example.hotelmanagesys.repository.HotelRepository;
import org.example.hotelmanagesys.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelController {

    private HotelService hotelService;

    @PostMapping
    public HotelDTO createHotel(@RequestBody HotelDTO dto){
        return hotelService.createHotel(dto);
    }

    @GetMapping
    public List<HotelDTO> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @PutMapping("/{id}")
    public HotelDTO updateHotel(@PathVariable long id,@RequestBody HotelDTO dto){
        return hotelService.updateHotel(id, dto);
    }

    @GetMapping("/{id}")
    public HotelDTO getHotelById(@PathVariable long id){
        return hotelService.getHotelbyid(id);
    }

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable long id){
        return hotelService.deleteHotel(id);
    }
}
