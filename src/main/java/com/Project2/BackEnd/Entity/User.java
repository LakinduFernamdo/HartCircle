package com.Project2.BackEnd.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "userstest") // Change to your actual table name if needed
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID") // Match column name
    private Integer userId;

    @Column(name = "F_Name")
    private String firstName;

    @Column(name = "L_Name")
    private String lastName;

    @Column(name = "Address")
    private String address;

    @Column(name = "TPNumber")
    private String tpNumber;

    @Column(name = "NIC")
    private String nic;

    @Column(name = "Password")
    private String password;

    @Lob
    @Column(name = "Image", columnDefinition = "LONGBLOB")
    private byte[] image;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
