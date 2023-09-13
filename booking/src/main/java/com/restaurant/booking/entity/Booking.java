package com.restaurant.booking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Booking")
public class Booking {

	public Booking() {

	}

	public Booking(String name, String email, Long numGuests, LocalDateTime dateTime) {
		super();
		this.name = name;
		this.email = email;
		this.numGuests = numGuests;
		this.dateTime = dateTime;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private Long numGuests;
	private LocalDateTime dateTime;
	@ManyToOne
	private DineTable table;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumGuests() {
		return numGuests;
	}

	public void setNumGuests(Long numGuests) {
		this.numGuests = numGuests;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public DineTable getTable() {
		return table;
	}

	public void setTable(DineTable table) {
		this.table = table;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
