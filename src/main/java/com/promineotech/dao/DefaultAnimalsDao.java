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
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class DefaultAnimalsDao implements AnimalsDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Animals> fetchAnimal(String animalId) {
    log.info("DAO: animalId= {}", animalId);

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
        return Animals.builder()
            .animalPk(rs.getLong("animal_pk"))
            .animalId(rs.getString("animal_id"))
            .animalName(rs.getString("animal_name"))
            .species(Species.valueOf(rs.getString("species")))
            .breed(rs.getString("breed"))
            .symptoms(rs.getString("symptoms"))
            .build();
        //@formatter:on
      }
    });
  }

  @Override
  public Optional<Animals> deleteAnimal(String animalId, String animalName) {
    String sql = ""
        + "DELETE FROM animals WHERE "
        + "animal_id = :animal_id AND animal_name = :animal_name";
    
    Map<String, Object> params = new HashMap<>();
    params.put("animal_id", animalId);
    params.put("animal_name", animalName);
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Animals.builder().animalId(animalId).animalName(animalName).build());
    
  }

  @Override
  public Optional<Animals> createAnimal(String animalId, String animalName, Species species, String breed,
      String symptoms) {

    String sql = "INSERT INTO animals "
        + "(animal_id, animal_name, species, breed, symptoms) VALUES "
        + "(:animal_id, :animal_name, :species, :breed, :symptoms)";

    Map<String, Object> params = allParamsToHashMap(animalId, animalName, species, breed, symptoms);

    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Animals.builder().animalId(animalId).animalName(animalName).species(species)
        .breed(breed).symptoms(symptoms).build());
  }

  @Override
  public Optional<Animals> updateAnimal(String animalId, String animalName, Species species, String breed,
      String symptoms) {
    String sql = ""
        + "UPDATE animals SET animal_name = :animal_name, species = :species,"
        + "breed = :breed, symptoms = :symptoms "
        + "WHERE animal_id = :animal_id";
    
    
    Map<String, Object> params = allParamsToHashMap(animalId, animalName, species, breed, symptoms);
    
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Animals.builder().animalId(animalId).animalName(animalName)
        .species(species).breed(breed).symptoms(symptoms).build());
  }
  
  /**
   * @param animalId
   * @param animalName
   * @param species
   * @param breed
   * @param symptoms
   * @return
   */
  private Map<String, Object> allParamsToHashMap(String animalId, String animalName, Species species,
      String breed, String symptoms) {
    Map<String, Object> params = new HashMap<>();
    params.put("animal_id", animalId);
    params.put("animal_name", animalName);
    params.put("species", species.toString());
    params.put("breed", breed);
    params.put("symptoms", symptoms);
    return params;
  }

  @Override
  public Optional<Animals> updateAnimalOwner(String animalId, Customers customer) {
//    String sql = ""
//        + "UPDATE animals SET customer_fk = :customer_fk "
//        + "WHERE animal_id = :animal_id";
//    
//    Map<String, Object> params = new HashMap<>();
//    
//    Long customerFk = //
//    //params.put("animal_id", animalId);
    
    return Optional.empty();
  }

}
