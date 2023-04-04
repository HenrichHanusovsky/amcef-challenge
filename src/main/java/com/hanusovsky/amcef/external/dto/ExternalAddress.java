package com.hanusovsky.amcef.external.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalAddress {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private ExternalGeo geo;
}
