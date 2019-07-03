package com.example.airbnb.controllers;

import java.util.List;

import com.example.airbnb.entities.Payment;
import com.example.airbnb.repositories.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * PaymentController
 */
@RestController
@RequestMapping(path = "/api")
public class PaymentController {

  @Autowired
  PaymentRepository paymentRepository;

  @GetMapping(value = "/payments", produces = "application/json")
  public List<Payment> displayPayments() {
    return paymentRepository.getAllPayments();
  }

  @GetMapping(path = "/bookings/{id}/payments", produces = "application/json")
  public List<Payment> displayUsersByEmail(@PathVariable("id") String id) {
    return paymentRepository.getAllPaymentsForBooking(Integer.parseInt(id));
  }
}