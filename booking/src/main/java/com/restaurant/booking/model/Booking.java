package com.restaurant.booking.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class Booking {
	public Booking() {

	}

	public Booking(@Valid String bookingId, @Valid String name, @Valid String email, @Valid Long tableSize,
			@Valid LocalDateTime dateTime) {
		super();
		this.bookingId = bookingId;
		this.name = name;
		this.email = email;
		this.tableSize = tableSize;
		this.dateTime = dateTime;
	}

	private @Valid String bookingId = null;

	private @Valid String name = null;

	private @Valid String email = null;

	private @Valid Long tableSize = null;

	private @Valid LocalDateTime dateTime = null;

	/**
	 **/
	public Booking bookingId(String bookingId) {
		this.bookingId = bookingId;
		return this;
	}

	@JsonProperty("bookingId")

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 **/
	public Booking name(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty("name")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 **/
	public Booking email(String email) {
		this.email = email;
		return this;
	}

	@JsonProperty("email")

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 **/
	public Booking tableSize(Long tableSize) {
		this.tableSize = tableSize;
		return this;
	}

	@JsonProperty("tableSize")
	@NotNull

	public Long getTableSize() {
		return tableSize;
	}

	public void setTableSize(Long tableSize) {
		this.tableSize = tableSize;
	}

	/**
	 **/
	public Booking dateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
		return this;
	}

	@JsonProperty("dateTime")
	@NotNull

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Booking booking = (Booking) o;
		return Objects.equals(bookingId, booking.bookingId) && Objects.equals(name, booking.name)
				&& Objects.equals(email, booking.email) && Objects.equals(tableSize, booking.tableSize)
				&& Objects.equals(dateTime, booking.dateTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId, name, email, tableSize, dateTime);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Booking {\n");

		sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    tableSize: ").append(toIndentedString(tableSize)).append("\n");
		sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
