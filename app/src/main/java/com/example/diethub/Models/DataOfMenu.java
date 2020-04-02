package com.example.diethub.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class DataOfMenu implements Parcelable {
    private String Name, Dec, Rating, MenuId, Price;
    private int Icon;

    public DataOfMenu(String name, String dec, String rating, String menuId, String price, int icon) {
        Name = name;
        Dec = dec;
        Rating = rating;
        MenuId = menuId;
        Price = price;
        Icon = icon;
    }

    protected DataOfMenu(Parcel in) {
        Name = in.readString();
        Dec = in.readString();
        Rating = in.readString();
        MenuId = in.readString();
        Price = in.readString();
        Icon = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Dec);
        dest.writeString(Rating);
        dest.writeString(MenuId);
        dest.writeString(Price);
        dest.writeInt(Icon);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataOfMenu> CREATOR = new Creator<DataOfMenu>() {
        @Override
        public DataOfMenu createFromParcel(Parcel in) {
            return new DataOfMenu(in);
        }

        @Override
        public DataOfMenu[] newArray(int size) {
            return new DataOfMenu[size];
        }
    };

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

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public static Creator<DataOfMenu> getCREATOR() {
        return CREATOR;
    }
}