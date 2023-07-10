package com.eb.HotelManagementSystem.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Predicate;

@Entity
@Table(name = "t_reservation")
public class Reservation
{
    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",
    sequenceName = "reservation_id",
    initialValue = 1000,
    allocationSize = 10)
    private Long id;

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private LocalDate checkOutDate;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    public Long getId() {
        return id;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", guest=" + guest +
                ", room=" + room +
                '}';
    }
}
