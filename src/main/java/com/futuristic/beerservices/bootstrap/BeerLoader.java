package com.futuristic.beerservices.bootstrap;

import com.futuristic.beerservices.domain.Beer;
import com.futuristic.beerservices.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

/**
 * created by Aditya on 05-Feb-20
 */
public class BeerLoader implements CommandLineRunner {

    private static final String BEER_UPC_1 = "0987654321";
    private static final String BEER_UPC_2 = "0987654322";

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObject();
    }

    private void loadBeerObject() {
        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder().beerName("Mango bobs").beerStyle("IPA").qualityToBrew(200000).minOnHand(12)
                    .upc(BEER_UPC_1).price(new BigDecimal("12.23")).build());
            beerRepository.save(Beer.builder().beerName("Galaxy Cat").beerStyle("PALE_ALE").qualityToBrew(400000).minOnHand(12)
                    .upc(BEER_UPC_2).price(new BigDecimal("11.40")).build());
        }
        System.out.println("total count is: " +beerRepository.count());
    }
}
