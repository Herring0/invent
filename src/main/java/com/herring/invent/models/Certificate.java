package com.herring.invent.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigInteger;
import java.util.Date;

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

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getNotAfter() {
        return notAfter;
    }

    public void setNotAfter(Date notAfter) {
        this.notAfter = notAfter;
    }

    public ECertType getType() {
        return type;
    }

    public void setType(ECertType type) {
        this.type = type;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
