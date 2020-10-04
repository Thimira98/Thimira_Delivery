package com.example.delivery.DATABASE;

public class Order {
    private String name;
    private String address;
    private String Disrict;
    private Integer PhoneNumber;
    private String email;

    public Order() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDisrict() {
        return Disrict;
    }

    public void setDisrict(String disrict) {
        Disrict = disrict;
    }

    public Integer getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
