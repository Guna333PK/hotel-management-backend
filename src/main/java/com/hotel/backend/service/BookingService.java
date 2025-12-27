package com.hotel.backend.service;

import com.hotel.backend.entity.Booking;
import com.hotel.backend.entity.Room;
import com.hotel.backend.repository.BookingRepository;
import com.hotel.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Booking bookRoom(Long roomId, String email) {
        Room room = roomRepository.findById(roomId).orElseThrow();

        room.setAvailable(false);
        roomRepository.save(room);

        Booking booking = new Booking();
        booking.setUserEmail(email);
        booking.setRoomNumber(room.getRoomNumber());
        booking.setRoomType(room.getType());
        booking.setPrice(room.getPrice());

        return bookingRepository.save(booking);
    }

    public List<Booking> getUserBookings(String email) {
        return bookingRepository.findByUserEmail(email);
    }
}
