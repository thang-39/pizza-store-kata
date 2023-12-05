package com.mesoneer.pizzastore.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.mesoneer.pizzastore.openapi.model.OrderItemCreateDto;
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
 * OrderCreateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-04T18:32:41.032111976+07:00[Asia/Ho_Chi_Minh]")
public class OrderCreateDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String bookingDate;

  private String customerName;

  private String phoneNumber;

  private String deliveryTo;

  private StatusDto status;

  private Float finalAmount;

  @Valid
  private List<@Valid OrderItemCreateDto> orderItems = new ArrayList<>();

  /**
   * Default constructor
   * @deprecated Use {@link OrderCreateDto#OrderCreateDto(String, String, String, Float, List<@Valid OrderItemCreateDto>)}
   */
  @Deprecated
  public OrderCreateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrderCreateDto(String customerName, String phoneNumber, String deliveryTo, Float finalAmount, List<@Valid OrderItemCreateDto> orderItems) {
    this.customerName = customerName;
    this.phoneNumber = phoneNumber;
    this.deliveryTo = deliveryTo;
    this.finalAmount = finalAmount;
    this.orderItems = orderItems;
  }

  public OrderCreateDto id(Integer id) {
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

  public OrderCreateDto bookingDate(String bookingDate) {
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

  public OrderCreateDto customerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  /**
   * Get customerName
   * @return customerName
  */
  @NotNull 
  @Schema(name = "customerName", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("customerName")
  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public OrderCreateDto phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
  */
  @NotNull 
  @Schema(name = "phoneNumber", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("phoneNumber")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public OrderCreateDto deliveryTo(String deliveryTo) {
    this.deliveryTo = deliveryTo;
    return this;
  }

  /**
   * Get deliveryTo
   * @return deliveryTo
  */
  @NotNull 
  @Schema(name = "deliveryTo", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("deliveryTo")
  public String getDeliveryTo() {
    return deliveryTo;
  }

  public void setDeliveryTo(String deliveryTo) {
    this.deliveryTo = deliveryTo;
  }

  public OrderCreateDto status(StatusDto status) {
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

  public OrderCreateDto finalAmount(Float finalAmount) {
    this.finalAmount = finalAmount;
    return this;
  }

  /**
   * Get finalAmount
   * @return finalAmount
  */
  @NotNull 
  @Schema(name = "finalAmount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("finalAmount")
  public Float getFinalAmount() {
    return finalAmount;
  }

  public void setFinalAmount(Float finalAmount) {
    this.finalAmount = finalAmount;
  }

  public OrderCreateDto orderItems(List<@Valid OrderItemCreateDto> orderItems) {
    this.orderItems = orderItems;
    return this;
  }

  public OrderCreateDto addOrderItemsItem(OrderItemCreateDto orderItemsItem) {
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
  @NotNull @Valid 
  @Schema(name = "orderItems", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("orderItems")
  public List<@Valid OrderItemCreateDto> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<@Valid OrderItemCreateDto> orderItems) {
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
    OrderCreateDto orderCreateDto = (OrderCreateDto) o;
    return Objects.equals(this.id, orderCreateDto.id) &&
        Objects.equals(this.bookingDate, orderCreateDto.bookingDate) &&
        Objects.equals(this.customerName, orderCreateDto.customerName) &&
        Objects.equals(this.phoneNumber, orderCreateDto.phoneNumber) &&
        Objects.equals(this.deliveryTo, orderCreateDto.deliveryTo) &&
        Objects.equals(this.status, orderCreateDto.status) &&
        Objects.equals(this.finalAmount, orderCreateDto.finalAmount) &&
        Objects.equals(this.orderItems, orderCreateDto.orderItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, bookingDate, customerName, phoneNumber, deliveryTo, status, finalAmount, orderItems);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderCreateDto {\n");
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

