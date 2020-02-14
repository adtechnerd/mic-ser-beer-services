package com.futuristic.beerservices.web.mapper;

import com.futuristic.beerservices.domain.Beer;
import com.futuristic.beerservices.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * created by Aditya on 14-Feb-20
 */
@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
