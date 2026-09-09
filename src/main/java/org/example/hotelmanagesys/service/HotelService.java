package org.example.hotelmanagesys.service;

import lombok.AllArgsConstructor;
import org.example.hotelmanagesys.Dto.HotelDTO;
import org.example.hotelmanagesys.entity.Hotel;
import org.example.hotelmanagesys.mapper.HotelMapper;
import org.example.hotelmanagesys.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    //hoteladd
    public HotelDTO createHotel(HotelDTO dto){
        Hotel hotel = HotelMapper.toEntity(dto);

        Hotel savedHotel = hotelRepository.save(hotel);

        return HotelMapper.toDTO(savedHotel);
    }

    //getall

    public List<HotelDTO> getAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(HotelMapper::toDTO)
                .toList();
    }
    //getbyid

    public HotelDTO getHotelbyid(long id){
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("hotel not found"));

        return HotelMapper.toDTO(hotel);

    }

    //update

    public HotelDTO updateHotel(long id, HotelDTO dto){
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("hotel not found"));

        hotel.setName(dto.getName());
        hotel.setLocation(dto.getLocation());
        hotel.setTotalRooms(dto.getTotalRooms());

        Hotel updatedHotel = hotelRepository.save(hotel);
        return HotelMapper.toDTO(updatedHotel);
    }

    public String  deleteHotel(long id){
        hotelRepository.deleteById(id);

        return "hotel deleted successfully";
    }
}
