package com.mesoneer.pizzastore.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.mesoneer.pizzastore.openapi.model.StatusDto;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * OrderStatusDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-29T10:26:08.761836926+07:00[Asia/Ho_Chi_Minh]")
public class OrderStatusDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private StatusDto status;

  /**
   * Default constructor
   * @deprecated Use {@link OrderStatusDto#OrderStatusDto(StatusDto)}
   */
  @Deprecated
  public OrderStatusDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrderStatusDto(StatusDto status) {
    this.status = status;
  }

  public OrderStatusDto status(StatusDto status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusDto getStatus() {
    return status;
  }

  public void setStatus(StatusDto status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderStatusDto orderStatusDto = (OrderStatusDto) o;
    return Objects.equals(this.status, orderStatusDto.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderStatusDto {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

