package com.futuristic.beerservices.service;

import com.futuristic.beerservices.web.model.BeerDto;

import java.util.UUID;

/**
 * aditya created on 12/02/20
 */
public interface BeerService {

    BeerDto getBeerById(UUID id);

    BeerDto saveBeer(BeerDto beerDto);

    BeerDto updateBeerById(UUID id, BeerDto beerDto);

}
