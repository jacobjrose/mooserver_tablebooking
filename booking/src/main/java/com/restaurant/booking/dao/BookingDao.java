package com.restaurant.booking.dao;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.restaurant.booking.entity.Booking;

public class BookingDao {
	private static BookingDao dao;

	private BookingDao() {
	}

	public static BookingDao getInstance() {
		if (dao == null) {
			synchronized (BookingDao.class) {
				if (dao == null) {
					dao = new BookingDao();
				}
			}
		}
		return dao;
	}

	public void saveBooking(Booking booking) {
		try (Session session = DatabaseUtiil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.persist(booking);
			transaction.commit();
		}
	}

	public List<Booking> getAllReservations(LocalDateTime localDateTime) {
		Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
		 
		 
        // 4. convert java.util.Date to java.util.Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date fromDate = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date toDate = calendar.getTime();

        
        
		try (Session session = DatabaseUtiil.getSessionFactory().openSession()) {
			return session.createQuery("FROM Booking", Booking.class).list();
		}
	}

}
