package org.nobleprog.camel.middleware.domain.model;

import java.io.Serializable;

public class Trade implements Serializable{

    private String id;
    private String instrument;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
}
