package com.promineotech.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.clinic.entity.Animals;
import com.promineotech.clinic.entity.Species;

public interface AnimalsDao {

  List<Animals> fetchAnimal(String animalId);
  
  Optional<Animals> createAnimal (String animalId, String animalName,
      Species species, String breed, String symptoms);
  
  Optional<Animals> updateAnimal (String animalId, String animalName, 
      Species species, String breed, String symptoms);
  
  Optional<Animals> deleteAnimal (String animalId, String animalName);
}
