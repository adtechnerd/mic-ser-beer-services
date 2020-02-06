package com.futuristic.beerservices.repositories;

import com.futuristic.beerservices.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * created by Aditya on 05-Feb-20
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
