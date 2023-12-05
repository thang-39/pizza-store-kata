package com.mesoneer.pizzastore.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.mesoneer.pizzastore.openapi.model.OrderItemResponseDto;
import com.mesoneer.pizzastore.openapi.model.StatusDto;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * OrderResponseDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-04T18:32:41.032111976+07:00[Asia/Ho_Chi_Minh]")
public class OrderResponseDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String bookingDate;

  private String customerName;

  private String phoneNumber;

  private String deliveryTo;

  private StatusDto status;

  private Float finalAmount;

  @Valid
  private List<@Valid OrderItemResponseDto> orderItems;

  public OrderResponseDto id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public OrderResponseDto bookingDate(String bookingDate) {
    this.bookingDate = bookingDate;
    return this;
  }

  /**
   * Get bookingDate
   * @return bookingDate
  */
  
  @Schema(name = "bookingDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bookingDate")
  public String getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(String bookingDate) {
    this.bookingDate = bookingDate;
  }

  public OrderResponseDto customerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  /**
   * Get customerName
   * @return customerName
  */
  
  @Schema(name = "customerName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("customerName")
  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public OrderResponseDto phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
  */
  
  @Schema(name = "phoneNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phoneNumber")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public OrderResponseDto deliveryTo(String deliveryTo) {
    this.deliveryTo = deliveryTo;
    return this;
  }

  /**
   * Get deliveryTo
   * @return deliveryTo
  */
  
  @Schema(name = "deliveryTo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("deliveryTo")
  public String getDeliveryTo() {
    return deliveryTo;
  }

  public void setDeliveryTo(String deliveryTo) {
    this.deliveryTo = deliveryTo;
  }

  public OrderResponseDto status(StatusDto status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public StatusDto getStatus() {
    return status;
  }

  public void setStatus(StatusDto status) {
    this.status = status;
  }

  public OrderResponseDto finalAmount(Float finalAmount) {
    this.finalAmount = finalAmount;
    return this;
  }

  /**
   * Get finalAmount
   * @return finalAmount
  */
  
  @Schema(name = "finalAmount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("finalAmount")
  public Float getFinalAmount() {
    return finalAmount;
  }

  public void setFinalAmount(Float finalAmount) {
    this.finalAmount = finalAmount;
  }

  public OrderResponseDto orderItems(List<@Valid OrderItemResponseDto> orderItems) {
    this.orderItems = orderItems;
    return this;
  }

  public OrderResponseDto addOrderItemsItem(OrderItemResponseDto orderItemsItem) {
    if (this.orderItems == null) {
      this.orderItems = new ArrayList<>();
    }
    this.orderItems.add(orderItemsItem);
    return this;
  }

  /**
   * Get orderItems
   * @return orderItems
  */
  @Valid 
  @Schema(name = "orderItems", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("orderItems")
  public List<@Valid OrderItemResponseDto> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<@Valid OrderItemResponseDto> orderItems) {
    this.orderItems = orderItems;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderResponseDto orderResponseDto = (OrderResponseDto) o;
    return Objects.equals(this.id, orderResponseDto.id) &&
        Objects.equals(this.bookingDate, orderResponseDto.bookingDate) &&
        Objects.equals(this.customerName, orderResponseDto.customerName) &&
        Objects.equals(this.phoneNumber, orderResponseDto.phoneNumber) &&
        Objects.equals(this.deliveryTo, orderResponseDto.deliveryTo) &&
        Objects.equals(this.status, orderResponseDto.status) &&
        Objects.equals(this.finalAmount, orderResponseDto.finalAmount) &&
        Objects.equals(this.orderItems, orderResponseDto.orderItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, bookingDate, customerName, phoneNumber, deliveryTo, status, finalAmount, orderItems);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderResponseDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    bookingDate: ").append(toIndentedString(bookingDate)).append("\n");
    sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    deliveryTo: ").append(toIndentedString(deliveryTo)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    finalAmount: ").append(toIndentedString(finalAmount)).append("\n");
    sb.append("    orderItems: ").append(toIndentedString(orderItems)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

