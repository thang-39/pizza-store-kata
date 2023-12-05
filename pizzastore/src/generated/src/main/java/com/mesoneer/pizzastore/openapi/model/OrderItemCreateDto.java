package com.mesoneer.pizzastore.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * OrderItemCreateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-04T18:32:41.032111976+07:00[Asia/Ho_Chi_Minh]")
public class OrderItemCreateDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private Integer orderId;

  private UUID productId;

  private Integer quantity;

  private Float totalAmount;

  /**
   * Default constructor
   * @deprecated Use {@link OrderItemCreateDto#OrderItemCreateDto(UUID, Integer, Float)}
   */
  @Deprecated
  public OrderItemCreateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrderItemCreateDto(UUID productId, Integer quantity, Float totalAmount) {
    this.productId = productId;
    this.quantity = quantity;
    this.totalAmount = totalAmount;
  }

  public OrderItemCreateDto id(Integer id) {
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

  public OrderItemCreateDto orderId(Integer orderId) {
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

  public OrderItemCreateDto productId(UUID productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  @NotNull @Valid 
  @Schema(name = "productId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("productId")
  public UUID getProductId() {
    return productId;
  }

  public void setProductId(UUID productId) {
    this.productId = productId;
  }

  public OrderItemCreateDto quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  @NotNull 
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public OrderItemCreateDto totalAmount(Float totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  /**
   * Get totalAmount
   * @return totalAmount
  */
  @NotNull 
  @Schema(name = "totalAmount", requiredMode = Schema.RequiredMode.REQUIRED)
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
    OrderItemCreateDto orderItemCreateDto = (OrderItemCreateDto) o;
    return Objects.equals(this.id, orderItemCreateDto.id) &&
        Objects.equals(this.orderId, orderItemCreateDto.orderId) &&
        Objects.equals(this.productId, orderItemCreateDto.productId) &&
        Objects.equals(this.quantity, orderItemCreateDto.quantity) &&
        Objects.equals(this.totalAmount, orderItemCreateDto.totalAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, orderId, productId, quantity, totalAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItemCreateDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
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

