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
import com.promineotech.clinic.entity.Customers;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Customers")
@OpenAPIDefinition(info = @Info(title = "Customers Service"),
    servers = {@Server(url = "http://localhost:8080", description = "local server")})

public interface CustomersController {
  //@formatter:off
  @Operation(
      summary = "Returns a list of customers",
      description = "Returns a list of customers given a required customerId",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of customers is returned.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Customers.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No customers were found with the input criteria.",
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
              name = "customerId",
              allowEmptyValue = false,
              required = false,
              description = "The customerId (i.e., 'petparker5')")
      }
    )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Customers> fetchCustomers(
      @RequestParam(required = false)
      String customerId);
  
  @Operation(
      summary = "Creates a customer",
      description = "Creates a customer given a required customerId, fName, lName, address and phone",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A customer is created.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Customers.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Unable to create customer with the input criteria.",
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
              name = "customerId",
              allowEmptyValue = false,
              required = false,
              description = "The customerId (i.e., 'petparker5')"),
          @Parameter(
              name = "fName",
              allowEmptyValue = false,
              required = false,
              description = "The customer's first name (ie Sally)"),
          @Parameter(
              name = "lName",
              allowEmptyValue = false,
              required = false,
              description = "The customer's last name (ie Smith)"),
          @Parameter(
              name = "phone",
              allowEmptyValue = false,
              required = false,
              description = "The customer's phone number (ie 555-555-5555)"),
          @Parameter(
              name = "address",
              allowEmptyValue = false,
              required = false,
              description = "The customer's address (ie 123 Main St.)"),
      }
    )
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Customers> createCustomers(
      @RequestParam(required = false)
      String customerId,
      @RequestParam(required = false)
      String fName,
      @RequestParam(required = false)
      String lName,
      @RequestParam(required = false)
      String phone,
      @RequestParam(required = false)
      String address);
  
  @Operation(
      summary = "Updates a customer",
      description = "Updates a customer given a required customerId, fName, lName, address and phone",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A customer is updated.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Customers.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Unable to update customer with the input criteria.",
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
              name = "customerId",
              allowEmptyValue = false,
              required = false,
              description = "The customerId (i.e., 'petparker5')"),
          @Parameter(
              name = "fName",
              allowEmptyValue = false,
              required = false,
              description = "The customer's first name (ie Sally)"),
          @Parameter(
              name = "lName",
              allowEmptyValue = false,
              required = false,
              description = "The customer's last name (ie Smith)"),
          @Parameter(
              name = "phone",
              allowEmptyValue = false,
              required = false,
              description = "The customer's phone number (ie 555-555-5555)"),
          @Parameter(
              name = "address",
              allowEmptyValue = false,
              required = false,
              description = "The customer's address (ie 123 Main St.)")
      }
    )
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Customers> updateCustomers(
      @RequestParam(required = false)
      String customerId,
      @RequestParam(required = false)
      String fName,
      @RequestParam(required = false)
      String lName,
      @RequestParam(required = false)
      String phone,
      @RequestParam(required = false)
      String address);
  
  @Operation(
      summary = "Deletes a customer",
      description = "Deletes a customer given a required customerId",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A customer is deleted.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Customers.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Unable to delete customer with the input criteria.",
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
              name = "customerId",
              allowEmptyValue = false,
              required = false,
              description = "The customerId (i.e., 'petparker5')"),
          
      }
    )
  
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Customers> deleteCustomers(
      @RequestParam(required = false)
      String customerId);
      
  

}
  
  //@formatter:on
