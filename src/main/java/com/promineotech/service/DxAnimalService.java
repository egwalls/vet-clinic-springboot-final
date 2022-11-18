package com.promineotech.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.clinic.entity.Animals;
import com.promineotech.clinic.entity.Dx;
import com.promineotech.clinic.entity.Dx_animal;

public interface DxAnimalService {
  
  List<Dx_animal> fetchDxAnimal(String animalId);
  
  Dx_animal fetchDxAnimal(String dxAnimalId, Dx dx, Animals animal);

  /**
   * @param dxAnimalId
   * @param animal
   * @param dx
   * @return
   */
  Dx_animal createDxAnimal(String dxAnimalId, String animalId, String dxId);
  
  
}
