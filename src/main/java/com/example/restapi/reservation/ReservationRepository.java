package com.example.restapi.reservation;

import com.example.restapi.train.Train;
import com.example.restapi.train.TrainRepository;
import com.example.restapi.utils.DbConnectionManager;

import javax.naming.NamingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {

    private final DbConnectionManager dbConnectionManager;

    private TrainRepository trainRepository = new TrainRepository();

    {
        try {
            dbConnectionManager = new DbConnectionManager();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public ReservationRepository() {
    }

    public ReservationList getAll() {
        try {
            ResultSet resultSet = dbConnectionManager.createStatement().executeQuery("SELECT * FROM reservation");
            List<Reservation> reservations = new ArrayList<>();


            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(resultSet.getInt("id"));
                reservation.setTrainId(resultSet.getInt("train_id"));
                reservation.setNbr_seat_first(resultSet.getInt("nbr_seat_first"));
                reservation.setNbr_seat_business(resultSet.getInt("nbr_seat_business"));
                reservation.setNbr_seat_standard(resultSet.getInt("nbr_seat_standard"));
                reservation.setClientId(resultSet.getInt("client_id"));

                reservations.add(reservation);
            }

            ReservationList reservationListWrapper = new ReservationList();
            reservationListWrapper.setReservations(reservations);

            return reservationListWrapper;


        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addReservation(int trainId, int userId, int nbr_seat_first, int nbr_seat_business, int nbr_seat_standard) {
        try {
            Train train = trainRepository.getTrainById(trainId);

            if (train.getNbr_seat_first() < nbr_seat_first || train.getNbr_seat_business() < nbr_seat_business || train.getNbr_seat_standard() < nbr_seat_standard) {
                throw new RuntimeException("Not enough seats");
            }

            dbConnectionManager.createStatement().executeUpdate("INSERT INTO reservation (train_id,client_id,nbr_seat_first,nbr_seat_business,nbr_seat_standard) VALUES ("+trainId+","+userId+","+nbr_seat_first+","+nbr_seat_business+","+nbr_seat_standard+")");

           trainRepository.updateTrain(trainId,train.getNbr_seat_first()-nbr_seat_first,train.getNbr_seat_business()-nbr_seat_business,train.getNbr_seat_standard()-nbr_seat_standard);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
