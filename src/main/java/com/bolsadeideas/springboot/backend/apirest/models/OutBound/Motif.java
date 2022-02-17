package com.bolsadeideas.springboot.backend.apirest.models.OutBound;

import java.util.Locale;

public enum Motif {

    CUSTOM_DOCUMENTS,
    DUTIES_TAXES_REFUSE,
    CLIENT_INFORMATION,
    WRONG_SHIPPING_ADDRESS,
    WRONG_COUNTRY,
    PICKUP_RESCHEDULE,
    PROHIBITED_GOODS;

    @Override
    public String toString() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
