package com.example.airbnb.controllers;

import java.util.List;

import com.example.airbnb.entities.Review;
import com.example.airbnb.repositories.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ReviewController
 */
@RestController
@RequestMapping(path = "/api")
public class ReviewController {

  @Autowired
  ReviewRepository reviewRepository;

  @GetMapping(value = "/reviews", produces = "application/json")
  public List<Review> displayReviews() {
    return reviewRepository.getAllReviews();
  }

  @GetMapping(path = "/properties/{id}/reviews", produces = "application/json")
  public List<Review> displayReviewsByPropertyId(@PathVariable("id") int id) {
    return reviewRepository.getReviewsByPropertyId(id);
  }
}