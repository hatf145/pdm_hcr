package iteso.com.rentstudio.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by hecto on 31/03/2018.
 */

public class Rent implements Parcelable {
    private String property;
    private String lessor;
    private Date cycle;

    public Rent(){
    }

    public Rent(String property, String lessor, Date cycle) {
        this.property = property;
        this.lessor = lessor;
        this.cycle = cycle;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getLessor() {
        return lessor;
    }

    public void setLessor(String lessor) {
        this.lessor = lessor;
    }

    public Date getCycle() {
        return cycle;
    }

    public void setCycle(Date cycle) {
        this.cycle = cycle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.property);
        dest.writeString(this.lessor);
        dest.writeLong(this.cycle != null ? this.cycle.getTime() : -1);
    }

    protected Rent(Parcel in) {
        this.property = in.readString();
        this.lessor = in.readString();
        long tmpCycle = in.readLong();
        this.cycle = tmpCycle == -1 ? null : new Date(tmpCycle);
    }

    public static final Parcelable.Creator<Rent> CREATOR = new Parcelable.Creator<Rent>() {
        @Override
        public Rent createFromParcel(Parcel source) {
            return new Rent(source);
        }

        @Override
        public Rent[] newArray(int size) {
            return new Rent[size];
        }
    };
}
