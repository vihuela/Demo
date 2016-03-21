package com.hadlink.design_patterns.prototype.model;

/**
 * @author Created by lyao on 2016/2/25.
 */
public class User implements Cloneable {

    public int age;
    public String name;
    public Address address;

    @Override public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    @Override public Object clone() throws CloneNotSupportedException {
        User user = null;
        try {
            user = (User) super.clone();
            user.age = this.age;
            user.name = this.name;
            user.address = this.address;//尽量使用深拷贝
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
