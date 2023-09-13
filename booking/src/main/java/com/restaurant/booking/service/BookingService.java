package com.restaurant.booking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.restaurant.booking.dao.BookingDao;
import com.restaurant.booking.model.Booking;

public class BookingService {

	private static BookingService service;

	private BookingService() {
	}

	public static BookingService getInstance() {
		if (service == null) {
			synchronized (BookingService.class) {
				if (service == null) {
					service = new BookingService();
				}
			}
		}
		return service;
	}

	public void addBooking(Booking booking) {
		com.restaurant.booking.entity.Booking bookingEntity = new com.restaurant.booking.entity.Booking(
				booking.getName(), booking.getEmail(), booking.getTableSize(), booking.getDateTime());
		BookingDao.getInstance().saveBooking(bookingEntity);

	}

	public List<Booking> getAllBooking(LocalDateTime date) {
		if(date ==null) {
			//Use Current Date if no date is passed in the Request . 
			date =  LocalDateTime.now();
		}
		List<com.restaurant.booking.entity.Booking> bookings = BookingDao.getInstance().getAllReservations(date);

		List<Booking> bookingList = bookings.stream().map(p -> new Booking(String.valueOf(p.getId()), p.getName(),
				p.getEmail(), p.getNumGuests(), p.getDateTime())).collect(Collectors.toList());

		return bookingList;

	}
}
