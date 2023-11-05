package com.example.restapi.train;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/train")
public class TrainController {

        TrainRepository trainRepo = new TrainRepository();
        @GET
        @Path("/all")
        @Produces("application/json")
        public Response getAllTrain() {
                return Response.status(200).entity(trainRepo.getAll()).build();
        }

        @GET
        @Path("/filter")
        @Produces("application/json")
        public Response getTrainFilter(@QueryParam("departure")String departure,@QueryParam("arrival")String arrival, @QueryParam("date")String date, @QueryParam("time")String time) {
                return Response.status(200).entity(trainRepo.getTrainFilter(departure,arrival,date,time)).build();
        }



}
