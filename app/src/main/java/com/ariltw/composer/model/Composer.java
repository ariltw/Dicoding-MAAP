package com.ariltw.composer.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Composer implements Parcelable {
    private String name;
    private String year;
    private String description;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.year);
        parcel.writeString(this.description);
        parcel.writeInt(this.image);
    }

    public Composer (String name, String year, String desc, int img) {
        this.name = name;
        this.year = year;
        this.description = desc;
        this.image = img;
    }

    private Composer (Parcel in) {
        this.name = in.readString();
        this.year = in.readString();
        this.description = in.readString();
        this.image = in.readInt();
    }

    public static final Creator<Composer> CREATOR = new Creator<Composer>() {
        @Override
        public Composer createFromParcel(Parcel in) {
            return new Composer(in);
        }

        @Override
        public Composer[] newArray(int size) {
            return new Composer[size];
        }
    };
}
