package org.example.hotelmanagesys.controller;

import lombok.AllArgsConstructor;
import org.example.hotelmanagesys.Dto.BookingDTO;
import org.example.hotelmanagesys.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public BookingDTO createBooking(@RequestBody BookingDTO bookingDTO){
        return bookingService.createbooking(bookingDTO);
    }

    @GetMapping
    public List<BookingDTO> getAllBooking(){
        return bookingService.getallBookings();
    }

    @GetMapping("/{id}")
    public BookingDTO getById(@PathVariable long id){
        return bookingService.getbookingbyid(id);
    }

    @PutMapping("/update")
    public BookingDTO updateBooking(@PathVariable long id,@RequestBody BookingDTO bookingDTO){
        return bookingService.updateBooking(id, bookingDTO);

    }
}
