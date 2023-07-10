package com.eb.HotelManagementSystem.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_Guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Address address;

    private LocalDateTime createdDate;// we want see persist /save date

    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<Guest> guests = new ArrayList<>();

    @PrePersist
    public void PrePersist(){
        createdDate =LocalDateTime.now();
    }


    //getter and setter


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", createdDate=" + createdDate +
                '}';
    }
}