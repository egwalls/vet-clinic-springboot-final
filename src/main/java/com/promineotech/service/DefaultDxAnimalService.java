package com.promineotech.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.clinic.entity.Dx_animal;
import com.promineotech.dao.DxAnimalDao;

@Service
public class DefaultDxAnimalService implements DxAnimalService {

  @Autowired
  private DxAnimalDao dxAnimalDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Dx_animal> fetchDxAnimalByAnimalId(String animalId) {
    return dxAnimalDao.fetchDxAnimalByAnimalId(animalId);
  }
  
  @Transactional(readOnly = true)
  @Override
  public List<Dx_animal> fetchDxAnimal(String dxAnimalId) {
    return dxAnimalDao.fetchDxAnimal(dxAnimalId);
  }
  
  @Override
  public Dx_animal createDxAnimal(String dxAnimalId, String animalId, String dxId) {
    return dxAnimalDao.createDxAnimal(dxAnimalId, animalId, dxId);
  }
  
  @Override
  public Dx_animal updateDxAnimal(String dxAnimalId, String newDxAnimalId, String animalId, 
      String dxId) {
    return dxAnimalDao.updateDxAnimal(dxAnimalId, newDxAnimalId,animalId, dxId);
  }
  
  @Override
  public Optional<Dx_animal> deleteDxAnimal(String dxAnimalId) {
    return dxAnimalDao.deleteDxAnimal(dxAnimalId);
  }

}
