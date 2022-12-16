package com.techelevator.locations.services;

import com.techelevator.locations.model.Location;
import org.springframework.web.client.RestTemplate;

public class LocationService {

    private static final String API_BASE_URL = "http://localhost:3000/locations/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Location[] getAll() {
        Location[] locations = restTemplate.getForObject(API_BASE_URL, Location[].class);
        return locations;
    }

    public Location getOne(int id) {
        Location location = restTemplate.getForObject(API_BASE_URL + id, Location.class);
        return location;
    }

}
