package com.promineotech.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.clinic.entity.Animals;
import com.promineotech.clinic.entity.Species;
import com.promineotech.service.AnimalsService;

@RestController
public class DefaultAnimalsController implements AnimalsController {

  @Autowired
  private AnimalsService animalService;
  
  @Override
  public List<Animals> fetchAnimals(String animalId) {    
    return animalService.fetchAnimals(animalId);
  }

  @Override
  public Optional<Animals> createAnimals(String animalId, String animalName, Species species,
      String breed, String symptoms) {
    return animalService.createAnimals(animalId, animalName, species, breed, symptoms);
  }

  @Override
  public Optional<Animals> updateAnimals(String animalId, String animalName, Species species,
      String breed, String symptoms) {    
    return animalService.updateAnimals(animalId, animalName, species, breed, symptoms);
  }

  @Override
  public Optional<Animals> deleteAnimals(String animalId) {    
    return animalService.deleteAnimals(animalId);
  }
  
  @Override
  public Animals updateAnimalOwner(String animalId, String customerId) {    
    return animalService.updateAnimalOwner(animalId, customerId);
  }

}
