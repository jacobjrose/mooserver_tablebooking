package com.restaurant.booking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


public class BaseResponse   {

  private @Valid String type = null;

public enum StatusEnum {

    SUCCESS(String.valueOf("SUCCESS")), WARN(String.valueOf("WARN")), ERROR(String.valueOf("ERROR")), FATAL(String.valueOf("FATAL"));


    private String value;

    StatusEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String v) {
        for (StatusEnum b : StatusEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid StatusEnum status = null;

  private @Valid List<StatusMessage> messages = new ArrayList<StatusMessage>();

  /**
   **/
  public BaseResponse type(String type) {
    this.type = type;
    return this;
  }

  
  @JsonProperty("type")
  @NotNull

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  /**
   * to provide status of business transaction
   **/
  public BaseResponse status(StatusEnum status) {
    this.status = status;
    return this;
  }

  
  @JsonProperty("status")
  @NotNull

  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  /**
   **/
  public BaseResponse messages(List<StatusMessage> messages) {
    this.messages = messages;
    return this;
  }

  
  @JsonProperty("messages")

  public List<StatusMessage> getMessages() {
    return messages;
  }
  public void setMessages(List<StatusMessage> messages) {
    this.messages = messages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseResponse baseResponse = (BaseResponse) o;
    return Objects.equals(type, baseResponse.type) &&
        Objects.equals(status, baseResponse.status) &&
        Objects.equals(messages, baseResponse.messages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, status, messages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BaseResponse {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
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
