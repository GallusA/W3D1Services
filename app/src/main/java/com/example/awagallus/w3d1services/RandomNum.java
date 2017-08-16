package com.example.awagallus.w3d1services;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by HP on 8/16/2017.
 */

public class RandomNum implements Parcelable {
    String random;


    public RandomNum(String random) {
        this.random = random;
    }

    protected RandomNum(Parcel in) {
        random = in.readString();
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(random);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<RandomNum> CREATOR = new Creator<RandomNum>() {
        @Override
        public RandomNum createFromParcel(Parcel in) {
            return new RandomNum(in);
        }

        @Override
        public RandomNum[] newArray(int size) {
            return new RandomNum[size];
        }
    };
}