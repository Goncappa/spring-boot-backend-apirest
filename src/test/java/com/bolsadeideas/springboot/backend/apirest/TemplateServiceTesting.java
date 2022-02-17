package com.bolsadeideas.springboot.backend.apirest;


import com.bolsadeideas.springboot.backend.apirest.models.OutBound.Address;
import com.bolsadeideas.springboot.backend.apirest.models.OutBound.Motif;
import com.bolsadeideas.springboot.backend.apirest.models.OutBound.Recipient;
import com.bolsadeideas.springboot.backend.apirest.models.OutBound.ShippingOrder;
import com.bolsadeideas.springboot.backend.apirest.services.RequestOutboundService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
public class TemplateServiceTesting {

    @Autowired
    RequestOutboundService requestOutboundService;

    Address address = Address.builder()
            .city("Paris")
            .postalCode("75002")
            .countryCode("FR")
            .line1("4 BV des Capucines")
            .build();

    Recipient recipient = Recipient.builder()
            .address(address)
            .build();

    ShippingOrder shippingOrder = ShippingOrder.builder()
            .trackingInfos("010101010010101001")
            .purpose("GIFT")
            .recipient(recipient)
            .build();

    //String auto = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbmNyeXB0ZWQiOmZhbHNlLCJwYXlsb2FkIjoie1wiaWRcIjpcIjEwNDYzNTBcIixcInVzZXJuYW1lXCI6XCJtYXhpbWUubWFyY2Fpc0B0ZXN0LmJveHRhbC5jb21cIixcImFwaUtleVwiOlwiaGhidGF6ZDNcIixcImFjY2Vzc0tleVwiOm51bGx9IiwidXNlcl9uYW1lIjoiYm94dGFsLXNlcnZpY2UiLCJzY29wZSI6WyJib3h0YWwtc2VydmljZSJdLCJleHAiOjE5NTc4NTU2MzAsImp0aSI6ImNlMjQwMzRhLTZmNWEtNGU2YS1iMzhjLWIxZTg4NzRjMDcwYiIsImF1dGhvcml0aWVzIjpbIlJPTEVfQ1VTVE9NRVIiLCJST0xFX0FHRU5UIl0sImNsaWVudF9pZCI6ImJveHRhbC1zZXJ2aWNlIn0.jffx2DNS87mPuYwWfdLYKfHrQxOq9SnVsM3HPzB0Uw2LCkztyQZ-YMhuZkuvxpFnSOukaGmIq-fSHdNC1MrtCcVT3ppbAAiYfgzJ6IeEoeq9LabEcCvjn85bLygB4wKVHHyRRHjnbbCDp_vq-x8D4YY06DcH0PzGj2CQooHNzdpv9S9KNtbTei7M3kETOAw4rvW_ZSCW-RgNwk2j4_qSjs_TAEVpebW1U6YUJWO-beTsmcN3eX4xP_aQHe4iMlEQoDN3VqgB3pIR_d_hQz3p_8row74_9MkxvXeqDnqz2JBMaR4VDmbbJ4fa_HY_bk5gAekoX_phWMsoDJYENVvP3Q";

    @Test
    void run154658() {
        System.out.println(requestOutboundService.getOutboundTemplate(Motif.CUSTOM_DOCUMENTS, "toto", shippingOrder));
    }

    @Test
    void run123421() {
        Motif[] getMotifs = Motif.values();
        System.out.println("- My List of motifs is : " + getMotifs);
    }



}

