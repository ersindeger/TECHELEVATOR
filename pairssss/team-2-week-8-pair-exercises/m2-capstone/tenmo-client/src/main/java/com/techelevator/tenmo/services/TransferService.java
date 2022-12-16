package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransferService {

    private final String baseUrl;
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;


    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }


    public TransferService(String url){
        this.baseUrl = url;
    }


    public Transfer createTransfer(Transfer transfer){

        Transfer returnedTransfer = null;
        returnedTransfer = restTemplate.postForObject(baseUrl + "/transfers", makeTransferEntity(transfer), Transfer.class);

            return returnedTransfer;
    }


    public List<Transfer> retrieveAllTransfers() throws ServiceException{

        Transfer[] transfers = null;
        try {
            ResponseEntity<Transfer[]> response = restTemplate.exchange(baseUrl + "/transfers/user", HttpMethod.GET, makeAuthEntity(), Transfer[].class);
            transfers = response.getBody();
        }
        catch (ResourceAccessException ex) {
            throw new ServiceException(ex.getMessage());
        }
        catch (RestClientResponseException ex1) {
            throw new ServiceException(ex1.getRawStatusCode() + " " + ex1.getStatusText());
        }

        return  Arrays.asList(transfers);
    }


    public Transfer retrieveTransferByTransferId(int transferId) throws ServiceException{
        Transfer transfer = null;
        try{
            ResponseEntity<Transfer> response = restTemplate.exchange(baseUrl + "/transfers/" + transferId, HttpMethod.GET, makeAuthEntity(), Transfer.class);
            transfer = response.getBody();
        } catch (ResourceAccessException ex2){
            throw new ServiceException(ex2.getMessage());
        }
        catch (RestClientResponseException ex3) {
            throw new ServiceException(ex3.getRawStatusCode() + " " + ex3.getStatusText());
        }
        return transfer;
    }


    private HttpEntity<Transfer> makeTransferEntity(Transfer transfer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(transfer, headers);
    }


    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }

}
