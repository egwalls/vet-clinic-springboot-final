package com.promineotech.dao;

import java.util.List;
import java.util.Optional;
import com.promineotech.clinic.entity.*;

public interface DxAnimalDao {
  
  List<Dx_animal> fetchDxAnimalByAnimalId (String animalId);
  
  List<Dx_animal> fetchDxAnimal (String dxAnimalId);
  
  Dx_animal createDxAnimal(String dxAnimalId, String animalId, String dxId);
  
  Dx_animal updateDxAnimal(String dxAnimalId, String newDxAnimalId, String animalId, String dxId);

  Optional<Dx_animal> deleteDxAnimal(String dxAnimalId);

}
