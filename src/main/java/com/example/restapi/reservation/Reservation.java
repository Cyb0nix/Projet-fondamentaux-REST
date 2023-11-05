package com.example.restapi.reservation;

import jakarta.xml.bind.annotation.XmlElement;

public class Reservation {

    private int id;
    private int trainId;

    private int userId;
    private int nbr_seat_first;
    private int nbr_seat_business;
    private int nbr_seat_standard;



    public Reservation() {
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    @XmlElement
    public int getNbr_seat_first() {
        return nbr_seat_first;
    }

    public void setNbr_seat_first(int nbr_seat_first) {
        this.nbr_seat_first = nbr_seat_first;
    }

    @XmlElement
    public int getNbr_seat_business() {
        return nbr_seat_business;
    }

    public void setNbr_seat_business(int nbr_seat_business) {
        this.nbr_seat_business = nbr_seat_business;
    }

    @XmlElement
    public int getNbr_seat_standard() {
        return nbr_seat_standard;
    }

    public void setNbr_seat_standard(int nbr_seat_standard) {
        this.nbr_seat_standard = nbr_seat_standard;
    }

    @XmlElement
    public int getClientId() {
        return userId;
    }

    public void setClientId(int clientId) {
        this.userId = clientId;
    }




}
