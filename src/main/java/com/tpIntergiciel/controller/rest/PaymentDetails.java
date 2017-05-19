package com.tpIntergiciel.controller.rest;


import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "payment")
@XmlAccessorType(XmlAccessType.NONE)
public class PaymentDetails implements Serializable {
    @XmlAttribute
    private String identifier;
    @XmlElement
    private String amount;
    @XmlElement
    private String account;
    @XmlElement
    private String nameClient;
    @XmlElement
    private String type;

    public PaymentDetails() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
