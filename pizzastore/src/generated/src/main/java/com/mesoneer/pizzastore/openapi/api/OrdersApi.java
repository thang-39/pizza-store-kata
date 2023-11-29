/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.mesoneer.pizzastore.openapi.api;

import com.mesoneer.pizzastore.openapi.model.OrderCreateDto;
import com.mesoneer.pizzastore.openapi.model.OrderResponseDto;
import com.mesoneer.pizzastore.openapi.model.OrderStatusDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-29T10:26:08.761836926+07:00[Asia/Ho_Chi_Minh]")
@Validated
@Tag(name = "orders", description = "the orders API")
public interface OrdersApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PATCH /orders/change-status/{id} : change status of order
     *
     * @param id  (required)
     * @param orderStatusDto  (optional)
     * @return order status has been changed successfully (status code 200)
     *         or API not found (status code 404)
     */
    @Operation(
        operationId = "changeOrderStatus",
        summary = "change status of order",
        tags = { "orders" },
        responses = {
            @ApiResponse(responseCode = "200", description = "order status has been changed successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponseDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "API not found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Object.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/orders/change-status/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<OrderResponseDto> _changeOrderStatus(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
        @Parameter(name = "OrderStatusDto", description = "") @Valid @RequestBody(required = false) OrderStatusDto orderStatusDto
    ) {
        return changeOrderStatus(id, orderStatusDto);
    }

    // Override this method
    default  ResponseEntity<OrderResponseDto> changeOrderStatus(Integer id, OrderStatusDto orderStatusDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"deliveryTo\" : \"deliveryTo\", \"phoneNumber\" : \"phoneNumber\", \"finalAmount\" : 6.0274563, \"bookingDate\" : \"bookingDate\", \"id\" : 0, \"orderItems\" : [ { \"totalAmount\" : 2.302136, \"quantity\" : 5, \"orderId\" : 5, \"id\" : 1, \"productName\" : \"productName\" }, { \"totalAmount\" : 2.302136, \"quantity\" : 5, \"orderId\" : 5, \"id\" : 1, \"productName\" : \"productName\" } ], \"customerName\" : \"customerName\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /orders/prepare : order Pizza and/or Drink
     *
     * @param orderCreateDto  (optional)
     * @return place order successfully (status code 201)
     */
    @Operation(
        operationId = "placeOrder",
        summary = "order Pizza and/or Drink",
        tags = { "orders" },
        responses = {
            @ApiResponse(responseCode = "201", description = "place order successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponseDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/orders/prepare",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<OrderResponseDto> _placeOrder(
        @Parameter(name = "OrderCreateDto", description = "") @Valid @RequestBody(required = false) OrderCreateDto orderCreateDto
    ) {
        return placeOrder(orderCreateDto);
    }

    // Override this method
    default  ResponseEntity<OrderResponseDto> placeOrder(OrderCreateDto orderCreateDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"deliveryTo\" : \"deliveryTo\", \"phoneNumber\" : \"phoneNumber\", \"finalAmount\" : 6.0274563, \"bookingDate\" : \"bookingDate\", \"id\" : 0, \"orderItems\" : [ { \"totalAmount\" : 2.302136, \"quantity\" : 5, \"orderId\" : 5, \"id\" : 1, \"productName\" : \"productName\" }, { \"totalAmount\" : 2.302136, \"quantity\" : 5, \"orderId\" : 5, \"id\" : 1, \"productName\" : \"productName\" } ], \"customerName\" : \"customerName\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
