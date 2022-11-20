package com.promineotech.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.clinic.entity.Dx_animal;
import com.promineotech.service.DxAnimalService;

@RestController
public class DefaultDxAnimalController implements DxAnimalController {

  @Autowired
  private DxAnimalService dxAnimalService;
  
  
  @Override
  public List<Dx_animal> fetchDxAnimalByAnimalId(String animalId) {
    return dxAnimalService.fetchDxAnimalByAnimalId(animalId);
  }
  
  @Override
  public List<Dx_animal> fetchDxAnimal(String dxAnimalId) {
    return dxAnimalService.fetchDxAnimal(dxAnimalId);
  }

  @Override
  public Dx_animal createDxAnimal(String dxAnimalId, String animalId, String dxId) {
    return dxAnimalService.createDxAnimal(dxAnimalId, animalId, dxId);
  }
  
  @Override
  public Dx_animal updateDxAnimal(String dxAnimalId, String newDxAnimalId, String animalId, String dxId) {
    return dxAnimalService.updateDxAnimal(dxAnimalId, newDxAnimalId, animalId, dxId);
  }
  
  @Override
  public Optional<Dx_animal> deleteDxAnimal(String dxAnimalId) {
    return dxAnimalService.deleteDxAnimal(dxAnimalId);
  }

}
