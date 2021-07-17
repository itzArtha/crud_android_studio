package com.example.mobprob;

import android.os.Parcel;
import android.os.Parcelable;

public class Startup implements Parcelable {
    protected Startup(Parcel in) {
        nama = in.readString();
    }

    public static final Creator<Startup> CREATOR = new Creator<Startup>() {
        @Override
        public Startup createFromParcel(Parcel in) {
            return new Startup(in);
        }

        @Override
        public Startup[] newArray(int size) {
            return new Startup[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    String nama;

    public Startup(String nama) {
        this.nama = nama;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
    }
}
