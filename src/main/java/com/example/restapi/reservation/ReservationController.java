package com.example.restapi.reservation;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/reservation")
public class ReservationController {

    ReservationRepository reservationRepo = new ReservationRepository();
    @GET
    @Path("/all")
    public Response getAllReservation() {
        return Response.status(200).entity(reservationRepo.getAll()).build();
    }

    @POST
    @Path("/add")
    public Response addReservation(@QueryParam("trainId")int trainId,@QueryParam("userId")int userId,@QueryParam("nbr_seat_first")int nbr_seat_first,@QueryParam("nbr_seat_business")int nbr_seat_business,@QueryParam("nbr_seat_standard")int nbr_seat_standard) {
        try {
            reservationRepo.addReservation(trainId,userId,nbr_seat_first,nbr_seat_business,nbr_seat_standard);
            return Response.status(200).entity(true).build();
        }  catch (Exception e) {

            return Response.status(500).entity(false).build();
        }
    }
}
