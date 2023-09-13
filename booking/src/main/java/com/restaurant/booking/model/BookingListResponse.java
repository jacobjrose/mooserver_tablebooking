package com.restaurant.booking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * response
 **/
import jakarta.validation.Valid;

public class BookingListResponse extends BaseResponse {

	private @Valid List<Booking> response = new ArrayList<Booking>();

	/**
	 **/
	public BookingListResponse response(List<Booking> response) {
		this.response = response;
		return this;
	}

	@JsonProperty("response")

	public List<Booking> getResponse() {
		return response;
	}

	public void setResponse(List<Booking> response) {
		this.response = response;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BookingListResponse bookingListResponse = (BookingListResponse) o;
		return Objects.equals(response, bookingListResponse.response);
	}

	@Override
	public int hashCode() {
		return Objects.hash(response);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BookingListResponse {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    response: ").append(toIndentedString(response)).append("\n");
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
