package com.hotel.backend.controller;

import com.hotel.backend.entity.Booking;
import com.hotel.backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/{roomId}")
    public Booking book(@PathVariable Long roomId, @RequestParam String email) {
        return bookingService.bookRoom(roomId, email);
    }

    @GetMapping
    public List<Booking> myBookings(@RequestParam String email) {
        return bookingService.getUserBookings(email);
    }
}
