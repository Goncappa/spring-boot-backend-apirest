package com.bolsadeideas.springboot.backend.apirest.models.OutBound;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Address {

    private Long id;

    private String line1;

    private String line2;

    private String postalCode;

    private String city;

    private String countryCode;

}
