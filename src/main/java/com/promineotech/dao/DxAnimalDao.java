package com.promineotech.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.clinic.entity.*;

public interface DxAnimalDao {
  
  List<Dx_animal> fetchDxAnimal (String animalId);
  
  Dx_animal createDxAnimal(String dxAnimalId, Animals animal, Dx dx);
  
  Optional<Animals> fetchAnimals(String animalId);
  
  Optional<Dx> fetchDx(String dxId);

  /**
   * @param dxId
   * @param dxName
   * @param description
   * @return
   */
  Optional<Dx_animal> createDxAnimalString(String dxId, String dxName, String description);
  
  //Optional<Dx_animal> updateDxAnimal(String dxId, String dxName, String description);
  
  //Optional<Dx_animal> deleteDxAnimal(String dxId, String dxName);

}
