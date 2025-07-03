package com.Project2.BackEnd.Dto;

public class UserSummaryDTO {
    private String firstName;
    private String lastName;
    private String tpNumber;
    private String address;

    public UserSummaryDTO(String firstName, String lastName, String tpNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tpNumber = tpNumber;
        this.address = address;
    }

    public UserSummaryDTO() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTpNumber() {
        return tpNumber;
    }

    public void setTpNumber(String tpNumber) {
        this.tpNumber = tpNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
