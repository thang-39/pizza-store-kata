/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.mesoneer.pizzastore.openapi.api;

import com.mesoneer.pizzastore.openapi.model.ProductDto;
import java.util.UUID;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-04T18:32:41.032111976+07:00[Asia/Ho_Chi_Minh]")
@Validated
@Tag(name = "products", description = "the products API")
public interface ProductsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /products : add product
     *
     * @param productDto  (optional)
     * @return add new pizza successfully (status code 201)
     */
    @Operation(
        operationId = "addProduct",
        summary = "add product",
        tags = { "products" },
        responses = {
            @ApiResponse(responseCode = "201", description = "add new pizza successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/products",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ProductDto> _addProduct(
        @Parameter(name = "ProductDto", description = "") @Valid @RequestBody(required = false) ProductDto productDto
    ) {
        return addProduct(productDto);
    }

    // Override this method
    default  ResponseEntity<ProductDto> addProduct(ProductDto productDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"images\" : [ \"images\", \"images\" ], \"price\" : 0.8008282, \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"category\" : \"category\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /products/{id} : delete product by Id
     *
     * @param id  (required)
     * @return delete existing pizza successfully (status code 204)
     */
    @Operation(
        operationId = "deleteProductById",
        summary = "delete product by Id",
        tags = { "products" },
        responses = {
            @ApiResponse(responseCode = "204", description = "delete existing pizza successfully", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/products/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<String> _deleteProductById(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") UUID id
    ) {
        return deleteProductById(id);
    }

    // Override this method
    default  ResponseEntity<String> deleteProductById(UUID id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /product-list : get All Products
     *
     * @return get all products (status code 200)
     */
    @Operation(
        operationId = "getAll",
        summary = "get All Products",
        tags = { "products" },
        responses = {
            @ApiResponse(responseCode = "200", description = "get all products", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/product-list",
        produces = { "application/json" }
    )
    default ResponseEntity<List<ProductDto>> _getAll(
        
    ) {
        return getAll();
    }

    // Override this method
    default  ResponseEntity<List<ProductDto>> getAll() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"images\" : [ \"images\", \"images\" ], \"price\" : 0.8008282, \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"category\" : \"category\" }, { \"images\" : [ \"images\", \"images\" ], \"price\" : 0.8008282, \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"category\" : \"category\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /product-list/{category} : get product by category
     *
     * @param category  (required)
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "getProductByCategory",
        summary = "get product by category",
        tags = { "products" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/product-list/{category}",
        produces = { "application/json" }
    )
    default ResponseEntity<List<ProductDto>> _getProductByCategory(
        @Parameter(name = "category", description = "", required = true, in = ParameterIn.PATH) @PathVariable("category") String category
    ) {
        return getProductByCategory(category);
    }

    // Override this method
    default  ResponseEntity<List<ProductDto>> getProductByCategory(String category) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"images\" : [ \"images\", \"images\" ], \"price\" : 0.8008282, \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"category\" : \"category\" }, { \"images\" : [ \"images\", \"images\" ], \"price\" : 0.8008282, \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"category\" : \"category\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
