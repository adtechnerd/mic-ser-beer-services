package com.futuristic.beerservices.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * aditya created on 26/01/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerDto {
    private UUID id;
    private Integer version;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;
    private String beeNname;
    private BeerStyle beerStyle;
    private Long upc;
    private BigDecimal price;
    private Integer quantityOnHand;
}
