package iteso.com.rentstudio.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Lessor implements Parcelable {
    private String name;
    private String phone;
    private String email;

    public Lessor(){

    }

    public Lessor(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.phone);
        dest.writeString(this.email);
    }

    protected Lessor(Parcel in) {
        this.name = in.readString();
        this.phone = in.readString();
        this.email = in.readString();
    }

    public static final Parcelable.Creator<Lessor> CREATOR = new Parcelable.Creator<Lessor>() {
        @Override
        public Lessor createFromParcel(Parcel source) {
            return new Lessor(source);
        }

        @Override
        public Lessor[] newArray(int size) {
            return new Lessor[size];
        }
    };
}

