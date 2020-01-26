package com.futuristic.beerservices.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * aditya created on 26/01/20
 */
public class BeerPageList extends PageImpl<BeerDto> {

    public BeerPageList(List<BeerDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPageList(List<BeerDto> content) {
        super(content);
    }
}
