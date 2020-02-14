package com.futuristic.beerservices.service;

import com.futuristic.beerservices.domain.Beer;
import com.futuristic.beerservices.repositories.BeerRepository;
import com.futuristic.beerservices.web.controller.NotFoundException;
import com.futuristic.beerservices.web.mapper.BeerMapper;
import com.futuristic.beerservices.web.model.BeerDto;
import com.futuristic.beerservices.web.model.BeerPageList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * created by Aditya on 14-Feb-20
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerPageList listBeers(String beerName, String beerStyle, PageRequest of) {
        log.debug("calling repo to get paged beer details");
        Page<Beer> beerPage = null;
        if ((beerName == null || beerName.isEmpty()) && (beerStyle != null && beerStyle.isEmpty())) {
            beerPage = beerRepository.findByBeerStyle(beerStyle, of);
        } else if ((beerStyle == null || beerStyle.isEmpty()) && (beerName != null && beerName.isEmpty())) {
            beerPage = beerRepository.findByBeerName(beerName, of);
        } else if ((beerStyle != null && beerStyle.isEmpty()) && (beerName != null && beerName.isEmpty())) {
            beerPage = beerRepository.findByBeerNameAndBeerStyle(beerName, beerStyle, of);
        } else {
            beerPage = beerRepository.findAll(of);
        }
        List<Beer> content = beerPage.getContent();
        List<BeerDto> collect = content.stream().map(beerMapper::beerToBeerDto).collect(Collectors.toList());
        return new BeerPageList(collect);
    }

    @Override
    public BeerDto getBeerById(UUID beerId) {
        log.debug("calling repo to get beer by id");
        return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }
}
