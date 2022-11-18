package com.promineotech.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.clinic.entity.Animals;
import com.promineotech.clinic.entity.Species;
import com.promineotech.service.AnimalsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultAnimalsController implements AnimalsController {

  @Autowired
  private AnimalsService animalService;
  
  @Override
  public List<Animals> fetchAnimals(String animalId) {
    log.info("fetchAnimals was called from the controller");
    
    return animalService.fetchAnimals(animalId);
  }

  @Override
  public Optional<Animals> createAnimals(String animalId, String animalName, Species species,
      String breed, String symptoms) {
    log.info("createAnimals was called from the controller");
    
    return animalService.createAnimals(animalId, animalName, species, breed, symptoms);
  }

  @Override
  public Optional<Animals> updateAnimals(String animalId, String animalName, Species species,
      String breed, String symptoms) {
    log.info("updateAnimals was called from the controller");
    
    return animalService.updateAnimals(animalId, animalName, species, breed, symptoms);
  }

  @Override
  public Optional<Animals> deleteAnimals(String animalId, String animalName) {
    log.info("deleteAnimals was called from the controller");
    
    return animalService.deleteAnimals(animalId, animalName);
  }

}
