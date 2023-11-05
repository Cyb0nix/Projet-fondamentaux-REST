package com.example.restapi.train;

import com.example.restapi.utils.DbConnectionManager;
import jakarta.ws.rs.core.Response;

import javax.naming.NamingException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainRepository {

    private final DbConnectionManager dbConnectionManager;

    {
        try {
            dbConnectionManager = new DbConnectionManager();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public TrainRepository() {

    }

    public TrainList getAll() {
        try {

            ResultSet resultSet = dbConnectionManager.createStatement().executeQuery("SELECT * FROM train");
            List<Train> trains = new ArrayList<>();

            while (resultSet.next()) {
                Train train = new Train();
                train.setId(resultSet.getInt("id"));
                train.setDeparture(resultSet.getString("departure"));
                train.setArrival(resultSet.getString("arrival"));
                train.setDate(resultSet.getString("date"));
                train.setTime(resultSet.getString("time"));
                train.setNbr_seat_first(resultSet.getInt("nbr_seat_first"));
                train.setNbr_seat_business(resultSet.getInt("nbr_seat_business"));
                train.setNbr_seat_standard(resultSet.getInt("nbr_seat_standard"));

                trains.add(train);

            }

            TrainList trainListWrapper = new TrainList();
            trainListWrapper.setTrains(trains);

            return trainListWrapper;

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public TrainList getTrainFilter(String departure, String arrival, String date, String time) {
        try {
            ResultSet resultSet = dbConnectionManager.createStatement ().executeQuery( "SELECT * FROM train WHERE departure = '" + departure + "' AND arrival = '" + arrival + "' AND date = '" + date + "' AND time = '" + time + "'");
            List<Train> trains = new ArrayList<>();

            while (resultSet.next()) {
                Train train = new Train();
                train.setId(resultSet.getInt("id"));
                train.setDeparture(resultSet.getString("departure"));
                train.setArrival(resultSet.getString("arrival"));
                train.setDate(resultSet.getString("date"));
                train.setTime(resultSet.getString("time"));
                train.setNbr_seat_first(resultSet.getInt("nbr_seat_first"));
                train.setNbr_seat_business(resultSet.getInt("nbr_seat_business"));
                train.setNbr_seat_standard(resultSet.getInt("nbr_seat_standard"));
                trains.add(train);



            }

            TrainList trainListWrapper = new TrainList();
            trainListWrapper.setTrains(trains);

            return trainListWrapper;

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateTrain(int id, int nbr_seat_first, int nbr_seat_business, int nbr_seat_standard) {
        try {
            dbConnectionManager.createStatement().executeUpdate("UPDATE train SET nbr_seat_first = "+nbr_seat_first+", nbr_seat_business = "+nbr_seat_business+", nbr_seat_standard = "+nbr_seat_standard+" WHERE id = "+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Train getTrainById(int id) {
        try {
            ResultSet resultSet = dbConnectionManager.createStatement().executeQuery("SELECT * FROM train WHERE id = "+id);
            Train train = new Train();
            while (resultSet.next()) {
                train.setId(resultSet.getInt("id"));
                train.setDeparture(resultSet.getString("departure"));
                train.setArrival(resultSet.getString("arrival"));
                train.setDate(resultSet.getString("date"));
                train.setTime(resultSet.getString("time"));
                train.setNbr_seat_first(resultSet.getInt("nbr_seat_first"));
                train.setNbr_seat_business(resultSet.getInt("nbr_seat_business"));
                train.setNbr_seat_standard(resultSet.getInt("nbr_seat_standard"));
            }
            return train;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
