package org.example.hotelmanagesys.service;

import lombok.AllArgsConstructor;
import org.example.hotelmanagesys.Dto.RoomDTO;
import org.example.hotelmanagesys.entity.Hotel;
import org.example.hotelmanagesys.entity.Room;
import org.example.hotelmanagesys.exception.ResourceNotFoundException;
import org.example.hotelmanagesys.mapper.RoomMapper;
import org.example.hotelmanagesys.repository.HotelRepository;
import org.example.hotelmanagesys.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@AllArgsConstructor
public class  RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;

    //create room
    public RoomDTO createRoom(RoomDTO roomDTO){

        Hotel hotel = hotelRepository.findById(roomDTO.getHotelId())
                .orElseThrow(()-> new ResourceNotFoundException(" hotel not found"));

        Room room = RoomMapper.toEntity(roomDTO,hotel);
        Room savedRoom = roomRepository.save(room);
        return RoomMapper.toDTO(savedRoom);

    }

    //getallrooms

    public List<RoomDTO> getAllRoom(){
        return roomRepository.findAll()
                .stream()
                .map(RoomMapper::toDTO)
                .toList();
    }

    //getbyhotelid

    public RoomDTO getByhotelId(long id){
        Room room = roomRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("room not found"));
                return RoomMapper.toDTO(room);

    }
    //delete

    public String deleteHotel(long id){
         roomRepository.deleteById(id);
         return "rooom deleted successfully";

    }
}
