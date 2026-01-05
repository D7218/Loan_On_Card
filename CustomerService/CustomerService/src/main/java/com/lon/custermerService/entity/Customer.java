package com.lon.custermerService.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Entity
@Table(name = "customer_service")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;
    private String mobile;
    private String kycStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
    }

    public Customer(long id, String name, String email, String mobile, String kycStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.kycStatus = kycStatus;
    }
}
