package com.promineotech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.clinic.entity.Animals;
import com.promineotech.clinic.entity.Dx;
import com.promineotech.clinic.entity.Dx_animal;
import com.promineotech.service.DxAnimalService;

@RestController
public class DefaultDxAnimalController implements DxAnimalController {

  @Autowired
  private DxAnimalService dxAnimalService;
  
  
  @Override
  public List<Dx_animal> fetchDxAnimalList(String animalId) {
    // TODO Auto-generated method stub
    return dxAnimalService.fetchDxAnimal(animalId);
  }

  @Override
  public Dx_animal createDxAnimal(String dxAnimalId, String animalId, String dxId) {
    //using animal_id look up and fill out an Animals object
    
    
    //how do I use the optional to look up the fields that need to be filled in? 
    
    
    
    return dxAnimalService.createDxAnimal(dxAnimalId, animalId, dxId);
  }

}
