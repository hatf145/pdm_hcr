package iteso.com.rentstudio.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Property implements Parcelable {
    private String address;
    private String cost;

    public Property (){

    }

    public Property(String address, String cost) {
        this.address = address;
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeString(this.cost);
    }

    protected Property(Parcel in) {
        this.address = in.readString();
        this.cost = in.readString();
    }

    public static final Creator<Property> CREATOR = new Creator<Property>() {
        @Override
        public Property createFromParcel(Parcel source) {
            return new Property(source);
        }

        @Override
        public Property[] newArray(int size) {
            return new Property[size];
        }
    };
}
