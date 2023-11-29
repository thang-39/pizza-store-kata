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
 * ImageDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-29T10:26:08.761836926+07:00[Asia/Ho_Chi_Minh]")
public class ImageDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private UUID id;

  private String name;

  private String contentType;

  private String base64Content;

  private UUID productId;

  /**
   * Default constructor
   * @deprecated Use {@link ImageDto#ImageDto(String, String)}
   */
  @Deprecated
  public ImageDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ImageDto(String contentType, String base64Content) {
    this.contentType = contentType;
    this.base64Content = base64Content;
  }

  public ImageDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ImageDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ImageDto contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * Get contentType
   * @return contentType
  */
  @NotNull 
  @Schema(name = "contentType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("contentType")
  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public ImageDto base64Content(String base64Content) {
    this.base64Content = base64Content;
    return this;
  }

  /**
   * Get base64Content
   * @return base64Content
  */
  @NotNull 
  @Schema(name = "base64Content", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("base64Content")
  public String getBase64Content() {
    return base64Content;
  }

  public void setBase64Content(String base64Content) {
    this.base64Content = base64Content;
  }

  public ImageDto productId(UUID productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  @Valid 
  @Schema(name = "productId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productId")
  public UUID getProductId() {
    return productId;
  }

  public void setProductId(UUID productId) {
    this.productId = productId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImageDto imageDto = (ImageDto) o;
    return Objects.equals(this.id, imageDto.id) &&
        Objects.equals(this.name, imageDto.name) &&
        Objects.equals(this.contentType, imageDto.contentType) &&
        Objects.equals(this.base64Content, imageDto.base64Content) &&
        Objects.equals(this.productId, imageDto.productId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, contentType, base64Content, productId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    base64Content: ").append(toIndentedString(base64Content)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
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

