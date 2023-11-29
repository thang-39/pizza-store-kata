package com.mesoneer.pizzastore.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * OrderItemResponseDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-29T10:26:08.761836926+07:00[Asia/Ho_Chi_Minh]")
public class OrderItemResponseDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private Integer orderId;

  private String productName;

  private Integer quantity;

  private Float totalAmount;

  public OrderItemResponseDto id(Integer id) {
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

  public OrderItemResponseDto orderId(Integer orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
  */
  
  @Schema(name = "orderId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("orderId")
  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public OrderItemResponseDto productName(String productName) {
    this.productName = productName;
    return this;
  }

  /**
   * Get productName
   * @return productName
  */
  
  @Schema(name = "productName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productName")
  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public OrderItemResponseDto quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public OrderItemResponseDto totalAmount(Float totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  /**
   * Get totalAmount
   * @return totalAmount
  */
  
  @Schema(name = "totalAmount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalAmount")
  public Float getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Float totalAmount) {
    this.totalAmount = totalAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItemResponseDto orderItemResponseDto = (OrderItemResponseDto) o;
    return Objects.equals(this.id, orderItemResponseDto.id) &&
        Objects.equals(this.orderId, orderItemResponseDto.orderId) &&
        Objects.equals(this.productName, orderItemResponseDto.productName) &&
        Objects.equals(this.quantity, orderItemResponseDto.quantity) &&
        Objects.equals(this.totalAmount, orderItemResponseDto.totalAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, orderId, productName, quantity, totalAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItemResponseDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
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

