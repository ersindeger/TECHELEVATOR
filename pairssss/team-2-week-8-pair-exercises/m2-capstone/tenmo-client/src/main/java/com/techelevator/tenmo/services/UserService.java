package com.techelevator.tenmo.services;


import com.techelevator.tenmo.model.User;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

public class UserService {

    private final String baseUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    private String authToken = null;

    public UserService(String url){
        this.baseUrl = url;
    }

    public List<User> retrieveAllUsers() throws ServiceException{

        User[] users = null;
        try {
            ResponseEntity<User[]> response = restTemplate.exchange(baseUrl + "users",HttpMethod.GET, makeAuthEntity(), User[].class);
            users = response.getBody();
        }
        catch (ResourceAccessException ex) {
            throw new ServiceException(ex.getMessage());
        }
        catch (RestClientResponseException ex1) {
            throw new ServiceException(ex1.getRawStatusCode() + " " + ex1.getStatusText());
        }
        return  Arrays.asList(users);
    }

    public BigDecimal getUserBalance() {

        ResponseEntity<BigDecimal> response = restTemplate.exchange(baseUrl + "account", HttpMethod.GET, makeAuthEntity(), BigDecimal.class);
        BigDecimal balance = response.getBody();
        return balance;

    }

    /**
     * Returns an HttpEntity with the `Authorization: Bearer:` header
     */
    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }


}
