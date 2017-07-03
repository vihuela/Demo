package com.hadlink.measure;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ricky.yao on 2017/7/3.
 */

public class UserInfo implements Parcelable {
    //基本类型
    public String name;
    public String sex;
    public String title;
    public String des;
    //复杂类型
    public List<UserDes> more;
    public UserDes userDes;

    public UserInfo(String name, String sex, String title, String des) {
        this.name = name;
        this.sex = sex;
        this.title = title;
        this.des = des;
    }

    public UserInfo() {
    }

    public static class UserDes implements Parcelable {
        public String Des1;
        public String Des2;

        public UserDes(String des1, String des2) {
            Des1 = des1;
            Des2 = des2;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.Des1);
            dest.writeString(this.Des2);
        }

        protected UserDes(Parcel in) {
            this.Des1 = in.readString();
            this.Des2 = in.readString();
        }

        public static final Creator<UserDes> CREATOR = new Creator<UserDes>() {
            @Override
            public UserDes createFromParcel(Parcel source) {
                return new UserDes(source);
            }

            @Override
            public UserDes[] newArray(int size) {
                return new UserDes[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.sex);
        dest.writeString(this.title);
        dest.writeString(this.des);
        dest.writeList(this.more);
        dest.writeParcelable(this.userDes, flags);
    }

    protected UserInfo(Parcel in) {
        this.name = in.readString();
        this.sex = in.readString();
        this.title = in.readString();
        this.des = in.readString();
        this.more = new ArrayList<UserDes>();
        in.readList(this.more, UserDes.class.getClassLoader());
        this.userDes = in.readParcelable(UserDes.class.getClassLoader());
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
}
