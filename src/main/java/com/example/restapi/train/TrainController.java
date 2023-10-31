package com.example.restapi.train;

import jakarta.ws.rs.*;

import java.util.List;

@Path("/train")
public class TrainController {

        TrainRepository trainRepo = new TrainRepository();
        @GET
        @Path("/all")
        @Produces("application/json")
        public List<Train> getAllTrain() {
                return trainRepo.getAll();
        }

        @GET
        @Path("/filter")
        @Produces("application/json")
        public List<Train> getTrainFilter(@QueryParam("departure")String departure,@QueryParam("arrival")String arrival, @QueryParam("date")String date, @QueryParam("time")String time) {
                return trainRepo.getTrainFilter(departure, arrival, date, time);
        }



}
