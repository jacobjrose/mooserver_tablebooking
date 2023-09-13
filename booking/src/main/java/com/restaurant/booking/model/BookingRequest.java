package com.restaurant.booking.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * New Booking Requestd. 
 **/
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class BookingRequest   {

  private @Valid Booking request = null;

  /**
   **/
  public BookingRequest request(Booking request) {
    this.request = request;
    return this;
  }

  
  @JsonProperty("request")
  @NotNull

  public Booking getRequest() {
    return request;
  }
  public void setRequest(Booking request) {
    this.request = request;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingRequest bookingRequest = (BookingRequest) o;
    return Objects.equals(request, bookingRequest.request);
  }

  @Override
  public int hashCode() {
    return Objects.hash(request);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingRequest {\n");
    
    sb.append("    request: ").append(toIndentedString(request)).append("\n");
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
