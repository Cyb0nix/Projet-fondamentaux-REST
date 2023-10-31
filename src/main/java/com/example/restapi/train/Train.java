package com.example.restapi.train;

public class Train {

    public int id;

    public String departure;

    public String arrival;

    public String date;

    public String time;

    public int nbr_seat_first;

    public int nbr_seat_buisiness;

    public int nbr_seat_standard;

    public Train(int id, String departure, String arrival, String date, String time, int nbr_seat_first, int nbr_seat_buisiness, int nbr_seat_standard) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.date = date;
        this.time = time;
        this.nbr_seat_first = nbr_seat_first;
        this.nbr_seat_buisiness = nbr_seat_buisiness;
        this.nbr_seat_standard = nbr_seat_standard;

    }

}
