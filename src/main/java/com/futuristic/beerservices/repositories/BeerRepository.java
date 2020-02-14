package com.futuristic.beerservices.repositories;

import com.futuristic.beerservices.domain.Beer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

/**
 * created by Aditya on 05-Feb-20
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

    Page<Beer> findByBeerNameAndBeerStyle(String beerName, String beerStyle, Pageable pageable);

    Page<Beer> findByBeerName(String beerName, Pageable pageable);

    Page<Beer> findByBeerStyle(String styleName, Pageable pageable);

}
