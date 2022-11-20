package com.promineotech.dao;

import java.util.Optional;
import com.promineotech.clinic.entity.Animals;
import com.promineotech.clinic.entity.Customers;
import com.promineotech.clinic.entity.Dx;
import com.promineotech.clinic.entity.Dx_animal;

public interface DaoSupport {
  
  // customers
  Optional<Customers> fetchCustomerOptional(String customerId);
  
  Customers getCustomer(String customerId);
  
  Customers getCustomerByFk(Long customerFk);
  
  Optional<Customers> fetchCustomerByFk(Long customerFk);
  
  // animals
  Optional<Animals> fetchAnimalOptional(String animalId);
  
  Animals getAnimal(String animalId);
  
  Optional<Animals> fetchAnimalByFk(Long dxFk);
  
  Animals getAnimalByFk(Long dxFk);
  
  // dx
  Optional<Dx> fetchDx(String dxId);
  
  Dx getDx(String dxId);
  
  Optional<Dx> fetchDxByFk(Long dxFk);
  
  Dx getDxByFk(Long dxFk);
  
  // dx_animal
  Optional<Dx_animal> fetchDxAnimal(String dxAnimalId);
  
  Dx_animal getDxAnimal(String dxAnimalId);
  

}
