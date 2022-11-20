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
import com.promineotech.clinic.entity.Dx;
import com.promineotech.clinic.entity.Dx_animal;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/DxAnimal")
@OpenAPIDefinition(info = @Info(title = "DxAnimal Service"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface DxAnimalController {
  
//@formatter:off
  @Operation(
      summary = "Returns a list of dx given to an animal as list of dxAnimal",
      description = "Returns a list of dx given to an animal given a required animalId",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of dxAnimal is returned.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Dx_animal.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No dxAnimal were found with the input criteria.",
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
  List<Dx_animal> fetchDxAnimalByAnimalId(
      @RequestParam(required = false)
      String animalId);
  
  @Operation(
      summary = "Returns a list of dxAnimal",
      description = "Returns a list containing one dxAnimal given a required dxAnimalId",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of dxAnimal is returned.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Dx_animal.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No dxAnimal were found with the input criteria.",
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
              name = "dxAnimalId",
              allowEmptyValue = false,
              required = false,
              description = "The dxAnimalId (ie 'fluffy63_feverHigh')")
      }
    )
  
  
  @GetMapping("dx_animal")
  @ResponseStatus(code = HttpStatus.OK)
  List<Dx_animal> fetchDxAnimal(
      @RequestParam(required = false)
      String dxAnimalId);
  
  
  @Operation(
      summary = "Creates dxAnimal",
      description = "creates a dx-animal relationship in the join table",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A dxAnimal was created.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Dx_animal.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No dxAnimal were found with the input criteria.",
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
              name = "dxAnimalId",
              allowEmptyValue = false,
              required = false,
              description = "The unique id for the join (i.e. 'fluffy63_fracturedTibia')"),
      }
    )
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
   Dx_animal createDxAnimal(
      @RequestParam(required = false)
      String dxAnimalId,
      String dxId,
      String animalId);
  
  @Operation(
      summary = "Updates a dx_animal",
      description = "Updates a dx_animal given a required dxAnimalId, animalId, and dxId",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A dxAnimal is updated.",
              content = @Content(
                  mediaType = "application/json",
              schema = @Schema(implementation = Dx_animal.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "Unable to update a dx_animal with the input criteria.",
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
            name = "dxAnimalId",
            allowEmptyValue = false,
            required = false,
            description = "The dxAnimalId as it currently is listed in the database"),
          @Parameter(
              name = "newDxAnimalId",
              allowEmptyValue = false,
              required = false,
              description = "The new dxAnimalId (ie 'fluffy63_feverHigh') if you are changing it. "
                  + "Can be left blank if you want to keep the current dxAnimalId"),
          @Parameter(
              name = "animalId",
              allowEmptyValue = false,
              required = false,
              description = "The animalId (i.e. 'steve16')"),
          @Parameter(
              name = "dxId",
              allowEmptyValue = false,
              required = false,
              description = "The dxId (i.e., 'fever_low')")
      }
    )
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Dx_animal updateDxAnimal(
      @RequestParam(required = false)
      String dxAnimalId,
      @RequestParam(required = false)
      String newDxAnimalId,
      @RequestParam(required = true)
      String animalId,
      @RequestParam(required = true)
      String dxId);
  
  @Operation(
      summary = "Deletes a dxAnimal",
      description = "Deletes a dxAnimal given a required dxAnimalId",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A dxAnimal is deleted.",
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
              description = "Unable to delete a dxAnimal with the input criteria.",
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
              name = "dxAnimalId",
              allowEmptyValue = false,
              required = false,
              description = "The dxAnimalId (i.e., 'steve16_feverLow')"),
        
      }
    )
  
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Dx_animal> deleteDxAnimal(
      @RequestParam(required = false)
      String dxAnimalId);


  //@formatter:on
  

}
