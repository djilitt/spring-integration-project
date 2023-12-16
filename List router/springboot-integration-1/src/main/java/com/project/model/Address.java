package com.project.model;

import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID=1;

    private String street;

    private String city;

    private String state;

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
