package com.promineotech.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.clinic.entity.Animals;
import com.promineotech.clinic.entity.Dx;
import com.promineotech.clinic.entity.Dx_animal;
import com.promineotech.dao.DxAnimalDao;

@Service
public class DefaultDxAnimalService implements DxAnimalService {

  @Autowired
  private DxAnimalDao dxAnimalDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Dx_animal> fetchDxAnimal(String animalId) {
    return dxAnimalDao.fetchDxAnimal(animalId);
  }

  @Override
  public Dx_animal fetchDxAnimal(String dxAnimalId, Dx dx, Animals animal) {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public Dx_animal createDxAnimal(String dxAnimalId, String animalId, String dxId) {
    Animals animalObj = getAnimal(animalId);
    Dx dxObj = getDx(dxId);
    
    return dxAnimalDao.createDxAnimal(dxAnimalId, animalObj, dxObj);
  }
  
  protected Animals getAnimal(String animalId) {
    return dxAnimalDao.fetchAnimals(animalId).orElseThrow(() -> new NoSuchElementException(
        "Engine with ID = was not found."));
  }
  
  protected Dx getDx(String dxId) {
    return dxAnimalDao.fetchDx(dxId).orElseThrow(() -> new NoSuchElementException(
        "Engine with ID = was not found."));
  }

}
