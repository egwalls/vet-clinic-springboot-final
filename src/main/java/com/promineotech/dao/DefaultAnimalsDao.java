package com.promineotech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.promineotech.clinic.entity.Animals;
import com.promineotech.clinic.entity.Customers;
import com.promineotech.clinic.entity.Species;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DefaultAnimalsDao implements AnimalsDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Autowired
  private DaoSupport ds;

  @Override
  public List<Animals> fetchAnimal(String animalId) {
    

    //@formatter:off
    String sql= ""
      + "SELECT * "
      + "FROM animals "
      + "WHERE animal_id = :animal_id";
    //@formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("animal_id", animalId);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Animals mapRow(ResultSet rs, int rowNum) throws SQLException {
        //set customer to null if fk is 0, prevents 500 error
        Long l = rs.getLong("customer_fk");
        Customers customer = null;
        if (l != 0) {
          customer = ds.getCustomerByFk(l);
        }
        
        return Animals.builder()
            .animalPk(rs.getLong("animal_pk"))
            .animalId(rs.getString("animal_id"))
            .animalName(rs.getString("animal_name"))
            .species(Species.valueOf(rs.getString("species")))
            .breed(rs.getString("breed"))
            .symptoms(rs.getString("symptoms"))
            .customer(customer)
            .build();
        //@formatter:on
      }
    });
  }

  @Override
  public Optional<Animals> createAnimal(String animalId, String animalName, Species species, String breed,
      String symptoms) {

    String sql = "INSERT INTO animals "
        + "(animal_id, animal_name, species, breed, symptoms) VALUES "
        + "(:animal_id, :animal_name, :species, :breed, :symptoms)";

    Map<String, Object> params = animalParamsToHashMap(animalId, animalName, species, breed, symptoms);

    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(animalBuilder(animalId, animalName, species, breed, symptoms));
  }

  @Override
  public Optional<Animals> updateAnimal(String animalId, String animalName, Species species, String breed,
      String symptoms) {
    String sql = ""
        + "UPDATE animals SET animal_name = :animal_name, species = :species,"
        + "breed = :breed, symptoms = :symptoms "
        + "WHERE animal_id = :animal_id";
    
    
    Map<String, Object> params = animalParamsToHashMap(animalId, animalName, species, breed, symptoms);
    
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(animalBuilder(animalId, animalName, species, breed, symptoms));
  }
  
  @Override
  public Optional<Animals> deleteAnimal(String animalId) {
    String sql = ""
        + "DELETE FROM animals "
        + "WHERE animal_id = :animal_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("animal_id", animalId);
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Animals.builder()
        .animalId(animalId)
        .build());
    
  }

  //helper methods
  protected Animals animalBuilder(String animalId, String animalName, Species species, String breed,
      String symptoms) {
    return Animals.builder()
        .animalId(animalId)
        .animalName(animalName)
        .species(species)
        .breed(breed)
        .symptoms(symptoms)
        .build();
  }
  
  private Map<String, Object> animalParamsToHashMap(String animalId, String animalName, Species species,
      String breed, String symptoms) {
    Map<String, Object> params = new HashMap<>();
    params.put("animal_id", animalId);
    params.put("animal_name", animalName);
    params.put("species", species.toString());
    params.put("breed", breed);
    params.put("symptoms", symptoms);
    return params;
  }

  
  /*
   * Adds customer to animal after customer has been created
   */
  @Override
  public Optional<Animals> updateAnimalOwner(String animalId, String customerId) {
    String sql = ""
        + "UPDATE animals SET customer_fk = :customer_fk "
        + "WHERE animal_id = :animal_id";
    Customers customer = ds.getCustomer(customerId);
    Animals animal = ds.getAnimal(animalId);
    
    Map<String, Object> params = new HashMap<>();
    params.put("animal_id", animal.getAnimalId());
    params.put("customer_fk", customer.getCustomerPk());
    
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Animals.builder()
        .animalPk(animal.getAnimalPk())
        .animalId(animal.getAnimalId())
        .animalName(animal.getAnimalName())
        .species(animal.getSpecies())
        .breed(animal.getBreed())
        .symptoms(animal.getSymptoms())
        .customer(customer)
        .build());
  }
  
}
