/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.mesoneer.pizzastore.openapi.api;

import com.mesoneer.pizzastore.openapi.model.StaffRequestDto;
import com.mesoneer.pizzastore.openapi.model.StaffResponseDto;
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
@Tag(name = "staffs", description = "the staffs API")
public interface StaffsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /staff : create staff
     *
     * @param staffRequestDto  (optional)
     * @return OK (status code 201)
     */
    @Operation(
        operationId = "createStaff",
        summary = "create staff",
        tags = { "staffs" },
        responses = {
            @ApiResponse(responseCode = "201", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = StaffResponseDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/staff",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<StaffResponseDto> _createStaff(
        @Parameter(name = "StaffRequestDto", description = "") @Valid @RequestBody(required = false) StaffRequestDto staffRequestDto
    ) {
        return createStaff(staffRequestDto);
    }

    // Override this method
    default  ResponseEntity<StaffResponseDto> createStaff(StaffRequestDto staffRequestDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"role\" : \"role\", \"id\" : 0, \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /staff/{username} : get staff by username
     *
     * @param username  (required)
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "getUserByUsername",
        summary = "get staff by username",
        tags = { "staffs" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = StaffResponseDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/staff/{username}",
        produces = { "application/json" }
    )
    default ResponseEntity<StaffResponseDto> _getUserByUsername(
        @Parameter(name = "username", description = "", required = true, in = ParameterIn.PATH) @PathVariable("username") String username
    ) {
        return getUserByUsername(username);
    }

    // Override this method
    default  ResponseEntity<StaffResponseDto> getUserByUsername(String username) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"role\" : \"role\", \"id\" : 0, \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
