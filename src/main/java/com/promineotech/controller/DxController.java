package com.promineotech.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.clinic.entity.Dx;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Dx")
@OpenAPIDefinition(info = @Info(title = "Dx Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface DxController {
  
//@formatter:off
  @Operation(
      summary = "Returns a list of dx",
      description = "Returns a list of dx given a required dxId",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of dx is returned.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Dx.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No dx were found with the input criteria.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "dxId",
              allowEmptyValue = false,
              required = false,
              description = "The dxId (i.e., 'fever_low')")
      }
    )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Dx> fetchDx(
      @RequestParam(required = false)
      String dxId);
  

  
  @Operation(
      summary = "Creates a dx",
      description = "Creates a dx given a required dxId, dxName, and description",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A dx is created.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Dx.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Unable to create a dx with the input criteria.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "dxId",
              allowEmptyValue = false,
              required = false,
              description = "The dxId (i.e., 'fever_low')"),
          @Parameter(
              name = "dxName",
              allowEmptyValue = false,
              required = false,
              description = "The dx's name (ie 'Low Grade Fever')"),
          @Parameter(
              name = "description",
              allowEmptyValue = false,
              required = false,
              description = "The dx's description")
      }
    )
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Dx> createDx(
      @RequestParam(required = false)
      String dxId,
      @RequestParam(required = false)
      String dxName,
      @RequestParam(required = false)
      String description);
  
  @Operation(
      summary = "Updates a dx",
      description = "Updates a dx given a required dxId, dxName, and description",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A dx is updated.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Dx.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Unable to update a dx with the input criteria.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "dxId",
              allowEmptyValue = false,
              required = false,
              description = "The dxId (i.e., 'fever_low')"),
          @Parameter(
              name = "dxName",
              allowEmptyValue = false,
              required = false,
              description = "The dx's name (ie 'Low Grade Fever')"),
          @Parameter(
              name = "description",
              allowEmptyValue = false,
              required = false,
              description = "The dx's description")
      }
    )
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Dx> updateDx(
      @RequestParam(required = false)
      String dxId,
      @RequestParam(required = false)
      String dxName,
      @RequestParam(required = false)
      String description);
  
  @Operation(
      summary = "Deletes a dx",
      description = "Deletes a dx given a required dxId, and dxName",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A dx is deleted.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Dx.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Unable to delete a dx with the input criteria.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "dxId",
              allowEmptyValue = false,
              required = false,
              description = "The dxId (i.e., 'fever_low')")
        
      }
    )
  
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Dx> deleteDx(
      @RequestParam(required = false)
      String dxId);


  //@formatter:on
  

}
