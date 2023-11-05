package com.example.restapi.train;

import jakarta.xml.bind.annotation.XmlElement;


public class Train {

    private int id;
    private String departure;
    private String arrival;
    private String date;
    private String time;
    private int nbr_seat_first;
    private int nbr_seat_business;
    private int nbr_seat_standard;

    public Train() {


    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @XmlElement
    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    @XmlElement
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

}
