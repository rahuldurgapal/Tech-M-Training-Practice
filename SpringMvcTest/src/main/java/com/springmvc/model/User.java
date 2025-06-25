package com.springmvc.model;

public class User {

    public String email1;
    public String password1;
    public int age;
    public String address;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email1;
    }

    public void setEmail(String email) {
        this.email1 = email;
    }

    public String getPassword() {
        return password1;
    }

    public void setPassword(String password) {
        this.password1 = password;
    }
}
