package com.futuristic.beerservices.service.impl;

import com.futuristic.beerservices.domain.Beer;
import com.futuristic.beerservices.repositories.BeerRepository;
import com.futuristic.beerservices.service.BeerService;
import com.futuristic.beerservices.web.controller.NotFoundException;
import com.futuristic.beerservices.web.mapper.BeerMapper;
import com.futuristic.beerservices.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * aditya created on 12/02/20
 */
@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    private final BeerMapper mapper;

    @Override
    public BeerDto getBeerById(UUID id) {
        Optional<Beer> beerById = beerRepository.findById(id);
        if(beerById.isPresent()) {
            Beer beer = beerById.get();
            BeerDto beerDto = mapper.beerToBeerDto(beer);
            return beerDto;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return mapper.beerToBeerDto(beerRepository.save(mapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeerById(UUID id, BeerDto beerDto) {
        Optional<Beer> beerById = beerRepository.findById(id);
        if(beerById.isPresent()) {
            Beer beer = beerById.get();
            beer.setBeerName(beerDto.getBeerName());
            beer.setBeerStyle(beerDto.getBeerStyle().name());
            beer.setPrice(beerDto.getPrice());
            beer.setUpc(beerDto.getUpc());

            Beer saveBeer = beerRepository.save(beer);
            return mapper.beerToBeerDto(saveBeer);
        } else {
            throw new NotFoundException();
        }
    }
}
