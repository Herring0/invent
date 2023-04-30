package com.herring.invent.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Certificate {

    private String SN;

    private String owner;

    private Date notAfter;

    private ECertType type;

    private boolean isValid;

    public Certificate(String SN, String owner, Date notAfter, ECertType type, boolean isValid) {
        this.SN = SN;
        this.owner = owner;
        this.notAfter = notAfter;
        this.type = type;
        this.isValid = isValid;
    }

    public Certificate(String SN, String owner, Date notAfter, boolean isValid) {
        this.SN = SN;
        this.owner = owner;
        this.notAfter = notAfter;
        this.isValid = isValid;
    }
}
