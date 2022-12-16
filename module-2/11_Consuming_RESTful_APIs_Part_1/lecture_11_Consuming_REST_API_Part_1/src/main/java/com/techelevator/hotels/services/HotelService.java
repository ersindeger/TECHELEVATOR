package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    //localhost:3000/hotels
    public Hotel[] listHotels() {
        Hotel[] foundHotels = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
        return foundHotels;
    }

    public Review[] listReviews() {
        Review[] reviews = restTemplate.getForObject(API_BASE_URL + "reviews", Review[].class);
        return reviews;
    }

    public Hotel getHotelById(int id) {
        Hotel foundHotel =  restTemplate.getForObject(API_BASE_URL + "hotels/" + id, Hotel.class);
        return foundHotel;
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        Review[] reviews = restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelID + "/reviews", Review[].class);
        return reviews;
    }

    //localhost:3000/hotels?stars=3
    public Hotel[] getHotelsByStarRating(int stars) {
        Hotel[] hotelsByStarRating = restTemplate.getForObject(API_BASE_URL + "hotels?stars=" + stars, Hotel[].class);
        return hotelsByStarRating;
    }

    public City getWithCustomQuery(){
        return null;
    }

}
