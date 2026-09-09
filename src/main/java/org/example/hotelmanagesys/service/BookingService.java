package org.example.hotelmanagesys.service;

import lombok.AllArgsConstructor;
import org.example.hotelmanagesys.Dto.BookingDTO;
import org.example.hotelmanagesys.entity.Booking;
import org.example.hotelmanagesys.entity.Room;
import org.example.hotelmanagesys.entity.User;
import org.example.hotelmanagesys.exception.ResourceNotFoundException;
import org.example.hotelmanagesys.exception.RoomAlreadyBookedException;
import org.example.hotelmanagesys.mapper.BookingMapper;
import org.example.hotelmanagesys.repository.BookingRepository;
import org.example.hotelmanagesys.repository.RoomRepository;
import org.example.hotelmanagesys.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {

   private BookingRepository bookingRepository;
   private UserRepository userRepository;
   private RoomRepository roomRepository;


   public BookingDTO createbooking(BookingDTO dto){
       User user = userRepository.findById(dto.getUserId())
               .orElseThrow(() -> new RuntimeException("USER NOT FOUND"));

       Room room = roomRepository.findById(dto.getRoomId())
               .orElseThrow(()-> new ResourceNotFoundException("Room not found"));

       List<Booking> conflicts =
               bookingRepository.findConflictingBookings(
                       dto.getRoomId(),
                       dto.getCheckIn(),
                       dto.getCheckOut()
               );

       if(!conflicts.isEmpty()){
           throw new RoomAlreadyBookedException("room already booked for dates");
       }
       Booking booking = BookingMapper.toEntity(dto, user, room);

       Booking savedBooking = bookingRepository.save(booking);

       return BookingMapper.toDTO(savedBooking);

   }
   //getallbooking
   public List<BookingDTO> getallBookings(){
       return bookingRepository.findAll()
               .stream()
               .map(BookingMapper::toDTO)
               .toList();
   }

   //getbookinngbbyid

    public BookingDTO getbookingbyid(long id){
       Booking booking =  bookingRepository.findById(id)
               .orElseThrow(()->new RuntimeException("booking not found"));
       return BookingMapper.toDTO(booking);


    }

    //deletebooking

    public String deleteBoking(long id){
       bookingRepository.deleteById(id);
       return "deleted successfully";
    }

    //update booking

    public BookingDTO updateBooking(long id,BookingDTO dto){
       Booking booking = bookingRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("booking not found"));

       booking.setCheckIn(dto.getCheckIn());
       booking.setCheckOut(dto.getCheckOut());
       booking.setStatus(dto.getStatus());

       Booking updated = bookingRepository.save(booking);
       return BookingMapper.toDTO(updated);
    }
}




