package com.futuristic.beerservices.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
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
    @Null
    private UUID id;

    @Null
    private Integer version;

    @Null
    private OffsetDateTime createdDate;

    @Null
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    private String beerName;

    @NotNull
    private BeerStyle beerStyle;

    @Positive
    @NotNull
    private Long upc;

    @Positive
    @NotNull
    private BigDecimal price;

    @PositiveOrZero
    private Integer quantityOnHand;
}
