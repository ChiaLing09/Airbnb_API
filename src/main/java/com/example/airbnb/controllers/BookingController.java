package com.example.airbnb.controllers;

import java.util.List;

import com.example.airbnb.entities.Booking;
import com.example.airbnb.repositories.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BookingController
 */
@RestController
@RequestMapping(path = "/api")
public class BookingController {

  @Autowired
  BookingRepository bookingRepository;

  @GetMapping(value = "/bookings", produces = "application/json")
  public List<Booking> displayUsers() {
    return bookingRepository.getAllBookings();
  }

  @GetMapping(path = "/properties/{id}/bookings", produces = "application/json")
  public List<Booking> displayBookingsByPropertyId(@PathVariable("id") int id) {
    return bookingRepository.getBookingsByPropertyId(id);
  }

  @GetMapping(path = "/bookings/{id}")
  public void updateUser(@PathVariable("id") int id) {
    bookingRepository.updateTotalPrice(123, 1);
  }
}