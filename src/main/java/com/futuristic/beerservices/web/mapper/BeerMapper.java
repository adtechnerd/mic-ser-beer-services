package com.futuristic.beerservices.web.mapper;

import com.futuristic.beerservices.domain.Beer;
import com.futuristic.beerservices.web.model.BeerDto;
import com.futuristic.brewery.web.mappers.DateMapper;
import org.mapstruct.Mapper;

/**
 * aditya created on 09/02/20
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
