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
import com.promineotech.clinic.entity.Animals;
import com.promineotech.clinic.entity.Species;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Animals")
@OpenAPIDefinition(info = @Info(title = "Animals Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server")})
public interface AnimalsController {

  //@formatter:off
  @Operation(
      summary = "Returns a list of animals",
      description = "Returns a list of animals given a required animalId",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of animals is returned.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Animals.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No animals were found with the input criteria.",
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
              name = "animalId",
              allowEmptyValue = false,
              required = false,
              description = "The animalId (i.e., 'fluffy63')")
      }
    )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Animals> fetchAnimals(
      @RequestParam(required = false)
      String animalId);
  

  
  @Operation(
      summary = "Creates an animal",
      description = "Creates an animal given a required animalId, animalName, species, breed and symptoms",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "An animal is created.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Animals.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Unable to create an animal with the input criteria.",
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
              name = "animalId",
              allowEmptyValue = false,
              required = false,
              description = "The animalId (i.e., 'fluffy 63')"),
          @Parameter(
              name = "animalName",
              allowEmptyValue = false,
              required = false,
              description = "The animal's name (ie Spot)"),
          @Parameter(
              name = "species",
              allowEmptyValue = false,
              required = false,
              description = "The animal's species (ie snake)"),
          @Parameter(
              name = "breed",
              allowEmptyValue = false,
              required = false,
              description = "The breed of the animal (ie Saint Bernard)"),
          @Parameter(
              name = "symptoms",
              allowEmptyValue = false,
              required = false,
              description = "The symptoms an animal is showing (ie broken bone)")
      }
    )
 
  
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Animals> createAnimals(
      @RequestParam(required = false)
      String animalId,
      @RequestParam(required = false)
      String animalName,
      @RequestParam(required = false)
      Species species,
      @RequestParam(required = false)
      String breed,
      @RequestParam(required = false)
      String symptoms);
  
  @Operation(
      summary = "Updates an animal",
      description = "Updates an animal given a required animalId, name, species, breed and symptoms",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "An animal is updated.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Animals.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Unable to update animal with the input criteria.",
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
              name = "animalId",
              allowEmptyValue = false,
              required = false,
              description = "The animalId (i.e., 'fluffy 63')"),
          @Parameter(
              name = "animalName",
              allowEmptyValue = false,
              required = false,
              description = "The animal's name (ie Spot)"),
          @Parameter(
              name = "species",
              allowEmptyValue = false,
              required = false,
              description = "The animal's species (ie snake)"),
          @Parameter(
              name = "breed",
              allowEmptyValue = false,
              required = false,
              description = "The breed of the animal (ie Saint Bernard)"),
          @Parameter(
              name = "symptoms",
              allowEmptyValue = false,
              required = false,
              description = "The symptoms an animal is showing (ie broken bone)")
      }
    )
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Animals> updateAnimals(
      @RequestParam(required = false)
      String animalId,
      @RequestParam(required = false)
      String animalName,
      @RequestParam(required = false)
      Species species,
      @RequestParam(required = false)
      String breed,
      @RequestParam(required = false)
      String symptoms);
  
  @Operation(
      summary = "Deletes an animal",
      description = "Deletes an animal given a required animalId, and name",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "An animal is deleted.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Animals.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Unable to delete animal with the input criteria.",
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
              name = "animalId",
              allowEmptyValue = false,
              required = false,
              description = "The animalId (i.e., 'fluffy 63')")
        
      }
    )
  
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Animals> deleteAnimals(
      @RequestParam(required = false)
      String animalId);

  
  @Operation(
      summary = "Updates an animal with a customer association",
      description = "Updates an animal given a required animalId and customerId",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "An animal is updated to include customer.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Animals.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Unable to update animal with the input criteria.",
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
              name = "animalId",
              allowEmptyValue = false,
              required = false,
              description = "The animalId (i.e., 'fluffy 63')"),
          @Parameter(
              name = "customerId",
              allowEmptyValue = false,
              required = false,
              description = "Unique id which identifies an already created customer"
                  + "(i.e. pet_parker)")
      }
    )
  
  @PutMapping("/customerUpdate")
  @ResponseStatus(code = HttpStatus.OK)
  Animals updateAnimalOwner(
      @RequestParam(required = false)
      String animalId,
      @RequestParam(required = false)
      String customerId);

  //@formatter:on 
  
}
