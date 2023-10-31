package com.example.restapi.train;

import com.example.restapi.utils.DbConnectionManager;

import javax.naming.NamingException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainRepository {

    public TrainRepository() {
    }

    public List<Train> getAll() {
        try {
            DbConnectionManager dbConnectionManager = new DbConnectionManager();
            ResultSet resultSet = dbConnectionManager.executeQuery("SELECT * FROM train");
            List<Train> trains = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String departure = resultSet.getString("departure");
                String arrival = resultSet.getString("arrival");
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                int nbr_seat_first = resultSet.getInt("nbr_seat_first");
                int nbr_seat_buisiness = resultSet.getInt("nbr_seat_buisiness");
                int nbr_seat_standard = resultSet.getInt("nbr_seat_standard");
                System.out.println("id : "+id);
                System.out.println("departure : " + departure);
                System.out.println("arrival : " + arrival);
                System.out.println("date : " + date);
                System.out.println("time : " + time);
                System.out.println("nbr_seat_first : "+nbr_seat_first);
                System.out.println("nbr_seat_buisiness : "+nbr_seat_buisiness);
                System.out.println("nbr_seat_standard : "+nbr_seat_standard);

                trains.add(new Train(id, departure, arrival, date, time, nbr_seat_first, nbr_seat_buisiness, nbr_seat_standard));


            }

            return trains;

        }catch (NamingException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public List<Train> getTrainFilter(String departure, String arrival, String date, String time) {
        try {
            DbConnectionManager dbConnectionManager = new DbConnectionManager();
            ResultSet resultSet = dbConnectionManager.executeQuery("SELECT * FROM train WHERE departure = '"+departure+"' AND arrival = '"+arrival+"' AND date = '"+date+"' AND time = '"+time+"'");
            List<Train> trains = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String departure1 = resultSet.getString("departure");
                String arrival1 = resultSet.getString("arrival");
                String date1 = resultSet.getString("date");
                String time1 = resultSet.getString("time");
                int nbr_seat_first = resultSet.getInt("nbr_seat_first");
                int nbr_seat_buisiness = resultSet.getInt("nbr_seat_buisiness");
                int nbr_seat_standard = resultSet.getInt("nbr_seat_standard");


                trains.add(new Train(id, departure1, arrival1, date1, time1, nbr_seat_first, nbr_seat_buisiness, nbr_seat_standard));


            }
            return trains;

        }catch (NamingException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
