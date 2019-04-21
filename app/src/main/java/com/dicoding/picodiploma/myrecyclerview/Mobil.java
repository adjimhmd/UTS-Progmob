package com.dicoding.picodiploma.myrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class Mobil implements Parcelable {
    private String name, remarks, photo, deskripsi;

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {

        return remarks;
    }

    public void setRemarks(String remarks) {

        this.remarks = remarks;
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
    }

    public Mobil() {
    }
    protected Mobil(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
    }
    public static final Parcelable.Creator<Mobil> CREATOR = new Parcelable.Creator<Mobil>() {
        @Override
        public Mobil createFromParcel(Parcel source) {
            return new Mobil(source);
        }
        @Override
        public Mobil[] newArray(int size) {
            return new Mobil[size];
        }
    };
}
