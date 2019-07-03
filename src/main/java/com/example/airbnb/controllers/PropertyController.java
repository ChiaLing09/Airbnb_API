package com.example.airbnb.controllers;

import java.util.List;

import com.example.airbnb.entities.Property;
import com.example.airbnb.entities.Review;
import com.example.airbnb.repositories.PropertyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * PropertyController
 */
@RestController
@RequestMapping(path = "/api")
public class PropertyController {

  @Autowired
  PropertyRepository propertyRepository;

  @GetMapping(value = "/properties", produces = "application/json")
  public List<Property> displayProperty() {
    return propertyRepository.getAllProperties();
  }

  @GetMapping(path = "/properties", produces = "application/json")
  public List<Property> searchProperties(@RequestParam("address") String address,
      @RequestParam("numRooms") int numRooms, @RequestParam("price") int price) {
    return propertyRepository.searchProperties(address, numRooms, price);
  }

  @GetMapping(path = "/bookedProperties", produces = "application/json")
  public List<Property> displayBookedProperties() {
    return propertyRepository.getBookedProperties();
  }

  // @GetMapping(path = "/create_property")
  // public void addProperty() {
  // propertyRepository.addProperty("address", 2, 20000, false, 4);
  // }

  // @GetMapping(path="/create_property", produces="application/json")
  // public void createProperty(
  // @RequestParam("address") String address,
  // @RequestParam("numRooms") int numRooms,
  // @RequestParam("price") int price,
  // @RequestParam("allowSmoking") boolean allowSmoking,
  // @RequestParam("maxGuestNum") int maxGuestNum
  // ){
  // Property property = new Property();
  // property.setAddress(address);
  // property.setAllowSmoking(allowSmoking);
  // property.setMaxGuestNum(maxGuestNum);
  // property.setNumRooms(numRooms);
  // property.setPrice(price);

  // propertyRepository.createProperty(property);
  // }

  @PostMapping(value = "/properties", produces = "application/json")
  public Property createProperty(@RequestBody Property property) {
    propertyRepository.createProperty(property);
    return property;
  }

  @GetMapping(path = "/update_property")
  public void updateProperty() {
    propertyRepository.updateProperty("address", "New address");
  }

  // /delete_property
  // Deletes property based on an id
  @GetMapping(path = "/delete_property")
  public void deleteProperty() {
    propertyRepository.deleteProperty(7);
  }

  @PostMapping(value = "/properties/{id}/reviews", produces = "application/json")
  public Property createPropertyReview(@PathVariable("id") int id, @RequestBody Review review) {
    propertyRepository.createPropertyReview(review);
    return review;
  }
}