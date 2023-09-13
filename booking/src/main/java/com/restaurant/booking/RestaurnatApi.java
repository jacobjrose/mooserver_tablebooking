package com.restaurant.booking;

import java.time.LocalDateTime;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.restaurant.booking.model.BookingListResponse;
import com.restaurant.booking.model.BookingRequest;
import com.restaurant.booking.service.BookingService;

import io.muserver.rest.ApiResponse;
import io.muserver.rest.ApiResponses;
import jakarta.validation.Valid;

@Path("/restaurnat")

public class RestaurnatApi {

	@POST
	@Path("/addNewBooking")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@ApiResponses(value = { @ApiResponse(code = "201", message = "Success Status (Created)"),
			@ApiResponse(code = "409", message = "Conflict < Table Not available for the time"),
			@ApiResponse(code = "200", message = "unexpected error") })
	public Response bookTable(@Valid BookingRequest body, @HeaderParam("Request-Id") String requestId) {
		BookingService.getInstance().addBooking(body.getRequest());
		return Response.ok().entity("Dooked.. !").build();
	}

	@GET
	@Path("/getAllBooking")
	@Produces({ "application/json" })
	@ApiResponses(value = { @ApiResponse(code = "200", message = "BookingListResponse"),
			@ApiResponse(code = "401", message = "Unauthorized"), @ApiResponse(code = "404", message = "Not Found"),
			@ApiResponse(code = "200", message = "unexpected error") })
	public Response getAllBooking(@HeaderParam("Request-Id") String requestId, @QueryParam("date") LocalDateTime date) {

		BookingListResponse bookingListResponse = new BookingListResponse();
		try {

			bookingListResponse.setResponse(BookingService.getInstance().getAllBooking(date));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.ok().entity(bookingListResponse).build();
	}
}
