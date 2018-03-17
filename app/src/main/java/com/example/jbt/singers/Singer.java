package com.example.jbt.singers;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jbt on 05/12/2017.
 */

public class Singer implements Parcelable {

    String name;
    boolean isMale;

    public Singer(String name, boolean isMale) {
        this.name = name;
        this.isMale = isMale;
    }

    protected Singer(Parcel in) {
        name = in.readString();
        isMale = in.readByte() != 0;
    }

    public static final Creator<Singer> CREATOR = new Creator<Singer>() {
        @Override
        public Singer createFromParcel(Parcel in) {
            return new Singer(in);
        }

        @Override
        public Singer[] newArray(int size) {
            return new Singer[size];
        }
    };

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeByte((byte) (isMale ? 1 : 0));
    }
}
