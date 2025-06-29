package com.Project2.BackEnd.Dto;

import org.springframework.web.multipart.MultipartFile;

public class UserRegisterDTO {

    private Integer userID;
    private String firstName;
    private String lastName;
    private String address;
    private String tpNumber;
    private String nic;
    private String password;
    private MultipartFile image;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTpNumber() {
        return tpNumber;
    }

    public void setTpNumber(String tpNumber) {
        this.tpNumber = tpNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
