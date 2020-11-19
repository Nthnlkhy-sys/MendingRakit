package com.mendingrakit;

import android.os.Parcel;
import android.os.Parcelable;

public class data_Package implements Parcelable {
    private String namapaket, harga, key, photo;

    public data_Package() {
    }

    public String getNamapaket() {
        return namapaket;
    }

    public void setNamapaket(String namapaket) {
        this.namapaket = namapaket;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(this.key);
        dest.writeString(this.namapaket);
        dest.writeString(this.harga);
        dest.writeString(this.photo);
    }

    protected data_Package(Parcel in){
        this.key        = in.readString();
        this.namapaket  = in.readString();
        this.harga      = in.readString();
        this.photo      = in.readString();
    }

    public static final Parcelable.Creator<data_Package> CREATOR = new Parcelable.Creator<data_Package>() {
        @Override
        public data_Package createFromParcel(Parcel source) {
            return new data_Package(source);
        }

        @Override
        public data_Package[] newArray(int size) {
            return new data_Package[size];
        }
    };
}
