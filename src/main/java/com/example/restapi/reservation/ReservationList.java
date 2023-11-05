package com.example.restapi.reservation;

import com.example.restapi.train.Train;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class ReservationList {

    private List<Reservation> reservationList;

    public ReservationList() {
    }

    @XmlElement(name="train")
    public List<Reservation> getReservations() {
        return reservationList;
    }

    public void setReservations(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

}
