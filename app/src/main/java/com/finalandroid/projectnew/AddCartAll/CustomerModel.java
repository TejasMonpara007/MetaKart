package com.finalandroid.projectnew.AddCartAll;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class CustomerModel implements Serializable
{
    @Exclude
    private String key;
    private String name;
    private String lastname;
    private String mobileNumber;
    private String address;
    private String country;

    public CustomerModel(){}
    public CustomerModel(String name, String position, String mobileNumber, String address, String country)
    {
        this.name = name;
        this.lastname = position;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.country = country;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPosition()
    {
        return lastname;
    }

    public void setPosition(String position)
    {
        this.lastname = position;
    }
    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
