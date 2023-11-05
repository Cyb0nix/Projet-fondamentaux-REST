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

    public TrainRepository() {
    }

    public TrainList getAll() {
        try {
            DbConnectionManager dbConnectionManager = new DbConnectionManager();
            ResultSet resultSet = dbConnectionManager.createStatement("sql").executeQuery("SELECT * FROM train");
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

        }catch (NamingException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public TrainList getTrainFilter(String departure, String arrival, String date, String time) {
        try {
            DbConnectionManager dbConnectionManager = new DbConnectionManager();
            ResultSet resultSet = dbConnectionManager.createStatement ("sql").executeQuery( "SELECT * FROM train WHERE departure = '" + departure + "' AND arrival = '" + arrival + "' AND date = '" + date + "' AND time = '" + time + "'");
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

        }catch (NamingException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
