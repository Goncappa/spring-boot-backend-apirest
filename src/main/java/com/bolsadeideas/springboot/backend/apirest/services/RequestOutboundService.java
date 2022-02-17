package com.bolsadeideas.springboot.backend.apirest.services;

import com.bolsadeideas.springboot.backend.apirest.models.OutBound.Motif;
import com.bolsadeideas.springboot.backend.apirest.models.OutBound.ShippingOrder;
import com.bolsadeideas.springboot.backend.apirest.util.TemplateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import static java.lang.String.format;



@Slf4j
@Service
@RequiredArgsConstructor
public class RequestOutboundService {

    Motif[] getMotifs = Motif.values();


    public Optional<String> getOutboundTemplate(Motif motif, String agent, ShippingOrder shippingOrder) {
        String template = (format ("templates/outbound/%s.html", motif.toString()));
        return Optional.of(TemplateUtil.process(template, "order",
            ShippingOrder.builder()
                .trackingInfos(shippingOrder.getTrackingInfos())
                .purpose(shippingOrder.getPurpose())
                .recipient(shippingOrder.getRecipient())
                .build()));
            }

    }

