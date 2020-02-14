package com.futuristic.beerservices.web.controller;

import com.futuristic.beerservices.service.BeerService;
import com.futuristic.beerservices.web.model.BeerDto;
import com.futuristic.beerservices.web.model.BeerPageList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * aditya created on 26/01/20
 */
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    @Autowired
    private BeerService beerService;

    private static final Integer PAGE_NUMBER = 0;
    private static final Integer PAGE_SIZE = 10;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BeerPageList> listBeers(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                  @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                  @RequestParam(value = "beerName", required = false) String beerName,
                                                  @RequestParam(value = "beerStyle", required = false) String beerStyle,
                                                  @RequestParam(value = "quantityOnHand", required = false) Boolean quantityOnHand) {
        if(quantityOnHand == null) {
            quantityOnHand = false;
        }

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 0) {
            pageSize = PAGE_SIZE;
        }

        BeerPageList beerList = beerService.listBeers(beerName, beerStyle, PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(beerList, HttpStatus.OK);
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId,
                                               @RequestParam(value = "quantityOnHand", required = false) Boolean quantityOnHand) {
        if(quantityOnHand == null) {
            quantityOnHand = false;
        }
        BeerDto beerById = beerService.getBeerById(beerId);
        return new ResponseEntity<>(beerById, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody @Valid BeerDto beerDto) {
        return new ResponseEntity(beerService.saveBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto) {
        beerService.updateBeerById(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
