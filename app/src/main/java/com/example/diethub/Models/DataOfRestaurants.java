package com.example.diethub.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class DataOfRestaurants implements Parcelable {
    private String Name, Dec, Rating, MenuId;
    private int Icon;
    private  boolean isfree;

    public DataOfRestaurants(String name, String dec, String rating, String menuId, int icon, boolean isfree) {
        Name = name;
        Dec = dec;
        Rating = rating;
        MenuId = menuId;
        Icon = icon;
        this.isfree = isfree;
    }

    protected DataOfRestaurants(Parcel in) {
        Name = in.readString();
        Dec = in.readString();
        Rating = in.readString();
        MenuId = in.readString();
        Icon = in.readInt();
        isfree = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Dec);
        dest.writeString(Rating);
        dest.writeString(MenuId);
        dest.writeInt(Icon);
        dest.writeByte((byte) (isfree ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataOfRestaurants> CREATOR = new Creator<DataOfRestaurants>() {
        @Override
        public DataOfRestaurants createFromParcel(Parcel in) {
            return new DataOfRestaurants(in);
        }

        @Override
        public DataOfRestaurants[] newArray(int size) {
            return new DataOfRestaurants[size];
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

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public boolean isIsfree() {
        return isfree;
    }

    public void setIsfree(boolean isfree) {
        this.isfree = isfree;
    }

    public static Creator<DataOfRestaurants> getCREATOR() {
        return CREATOR;
    }
}