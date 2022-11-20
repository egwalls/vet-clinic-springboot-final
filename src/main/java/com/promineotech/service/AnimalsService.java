package com.promineotech.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.clinic.entity.Animals;
import com.promineotech.clinic.entity.Species;

public interface AnimalsService {

  List<Animals> fetchAnimals(String animalId);

  Optional<Animals> createAnimals(String animalId, String animalName, Species species, String breed,
      String symptoms);
  
  Optional<Animals> updateAnimals(String animalId, String animalName, Species species, String breed,
      String symptoms);
  
  Optional<Animals> deleteAnimals(String animalId);
  
  Animals updateAnimalOwner(String animalId, String customerId);
  
}
