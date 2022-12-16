package com.techelevator.dao;

import com.techelevator.model.HomeNotFoundException;
import com.techelevator.model.Home;

import java.util.List;

public interface HomeDAO {

    Home addHome(Home newHome);
    void deleteHome(String mlsId) throws HomeNotFoundException;
    List<Home> retrieveHomesForSale();
    Home retrieveHomeByMLSId(String mlsId) throws HomeNotFoundException;
}
