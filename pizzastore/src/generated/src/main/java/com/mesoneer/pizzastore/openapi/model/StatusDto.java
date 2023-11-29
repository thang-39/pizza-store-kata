package com.mesoneer.pizzastore.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets StatusDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-29T10:26:08.761836926+07:00[Asia/Ho_Chi_Minh]")
public enum StatusDto {
  
  PENDING("PENDING"),
  
  CONFIRMED("CONFIRMED"),
  
  COOKED("COOKED"),
  
  DONE("DONE");

  private String value;

  StatusDto(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static StatusDto fromValue(String value) {
    for (StatusDto b : StatusDto.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

