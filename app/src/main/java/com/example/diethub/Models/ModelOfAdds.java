package com.example.diethub.Models;

public class ModelOfAdds {
    boolean isChecked;
    String Name,Dec,Price;

    public ModelOfAdds(boolean isChecked, String name, String dec, String price) {
        this.isChecked = isChecked;
        Name = name;
        Dec = dec;
        Price = price;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
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

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
