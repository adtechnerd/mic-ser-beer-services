package com.futuristic.beerservices.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.futuristic.beerservices.service.BeerService;
import com.futuristic.beerservices.web.model.BeerDto;
import com.futuristic.beerservices.web.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    BeerService beerService;

    private static final String BEER_UPC_1 = "0987654321";
    private static final String BEER_UPC_2 = "0987654322";

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void saveBeer() throws Exception {
        when(beerService.saveBeer(BeerDto.builder().build())).thenReturn(BeerDto.builder().build());
        BeerDto beerDto = BeerDto.builder().beerName("king").beerStyle(BeerStyle.ALE).upc(BEER_UPC_1).price(new BigDecimal(1100.00)).quantityOnHand(1).build();
        String beerDtoAsString = mapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/").
                accept(MediaType.APPLICATION_JSON).
                content(beerDtoAsString.getBytes()).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        when(beerService.updateBeerById(UUID.randomUUID(), BeerDto.builder().build())).thenReturn(BeerDto.builder().build());
        BeerDto beerDto = BeerDto.builder().beerName("king").beerStyle(BeerStyle.ALE).upc(BEER_UPC_2).price(new BigDecimal(1100.00)).quantityOnHand(1).build();
        String beerDtoAsString = mapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/"+ UUID.randomUUID().toString()).
                accept(MediaType.APPLICATION_JSON).
                content(beerDtoAsString.getBytes()).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isNoContent());
    }


}