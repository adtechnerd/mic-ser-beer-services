package com.futuristic.beerservices.service;

import com.futuristic.beerservices.web.model.BeerDto;
import com.futuristic.beerservices.web.model.BeerPageList;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

/**
 * created by Aditya on 14-Feb-20
 */
public interface BeerService {

    BeerPageList listBeers(String beerName, String beerStyle, PageRequest of);

    BeerDto getBeerById(UUID beerId);

    BeerDto saveBeer(BeerDto beerDto);

    BeerDto updateBeerById(UUID id, BeerDto beerDto);

}
