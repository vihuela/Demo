package com.hadlink.design_patterns.prototype.model;

/**
 * @author Created by lyao on 2016/3/21.
 */
public class Address {
    public String city;//城市

    public Address(String city) {
        this.city = city;
    }

    @Override public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
