package com.promineotech.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.clinic.entity.Animals;
import com.promineotech.clinic.entity.Species;
import com.promineotech.dao.AnimalsDao;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultAnimalsService implements AnimalsService {

  @Autowired
  private AnimalsDao animalsDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Animals> fetchAnimals(String animalId) {
    log.info("fetchAnimals method was called from the service layer with animalId = {}", animalId);
    
    return animalsDao.fetchAnimal(animalId);
  }

  @Override
  public Optional<Animals> createAnimals(String animalId, String animalName, Species species,
      String breed, String symptoms) {    
    return animalsDao.createAnimal(animalId, animalName, species, breed, symptoms);
  }

  @Override
  public Optional<Animals> updateAnimals(String animalId, String animalName, Species species,
      String breed, String symptoms) {    
    return animalsDao.updateAnimal(animalId, animalName, species, breed, symptoms);
  }

  @Override
  public Optional<Animals> deleteAnimals(String animalId) {
    return animalsDao.deleteAnimal(animalId);
  }
  
  @Override
  public Animals updateAnimalOwner(String animalId, String customerId) {
    return animalsDao.updateAnimalOwner(animalId, customerId).orElseThrow(() 
        -> new NoSuchElementException("Customer with ID " + customerId + "does not"
        + " exist.")); 
  }
  
}
