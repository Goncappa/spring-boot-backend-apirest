package com.bolsadeideas.springboot.backend.apirest.models.OutBound;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShippingOrder {
    private Long id;
    private String carrierCode;
    private String serviceCode;
    private String carrierReference;
    private Recipient recipient;
    private Long bridgeId;

    private String trackingInfos;
    private String purpose;


}

