package com.example.restapi.train;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/train")
public class TrainController {
        @GET
        @Path("/all")
        @Produces("text/plain")
        public String hello() {
            return "Hello, World!";
        }

}
