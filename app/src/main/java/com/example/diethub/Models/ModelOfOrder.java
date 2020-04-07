package com.example.diethub.Models;

public class ModelOfOrder {
    String Name,Dec,Number,Price;

    public ModelOfOrder(String name, String dec, String number, String price) {
        Name = name;
        Dec = dec;
        Number = number;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDec() {
        return Dec;
    }

    public void setDec(String dec) {
        Dec = dec;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
