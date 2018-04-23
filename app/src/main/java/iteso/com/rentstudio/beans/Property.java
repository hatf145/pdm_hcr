package iteso.com.rentstudio.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Property implements Parcelable {
    private String address;
    private Integer cost;
    private String lessor;
    private String name;
    private Integer payday;
    private String state;
    private String town;
    private String user;

    public Property(){

    }

    public Property(String address, int cost, String lessor, String name, int payday, String state, String town, String user) {
        this.address = address;
        this.cost = cost;
        this.lessor = lessor;
        this.name = name;
        this.payday = payday;
        this.state = state;
        this.town = town;
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getLessor() {
        return lessor;
    }

    public void setLessor(String lessor) {
        this.lessor = lessor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPayday() {
        return payday;
    }

    public void setPayday(int payday) {
        this.payday = payday;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeInt(this.cost);
        dest.writeString(this.lessor);
        dest.writeString(this.name);
        dest.writeInt(this.payday);
        dest.writeString(this.state);
        dest.writeString(this.town);
        dest.writeString(this.user);
    }

    protected Property(Parcel in) {
        this.address = in.readString();
        this.cost = in.readInt();
        this.lessor = in.readString();
        this.name = in.readString();
        this.payday = in.readInt();
        this.state = in.readString();
        this.town = in.readString();
        this.user = in.readString();
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
