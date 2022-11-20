package com.promineotech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.clinic.entity.Dx;
import com.promineotech.clinic.entity.Dx_animal;
import lombok.extern.slf4j.Slf4j;
import com.promineotech.clinic.entity.Animals;

@Component
@Slf4j
public class DefaultDxAnimalDao implements DxAnimalDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Autowired
  private DaoSupport ds;
  
  @Autowired
  private AnimalsDao ad;
  
  @Autowired
  private DxDao dd;

  
  /*
   * This method is meant to return all of the dx_animal connections
   * that have been made for a particular animal by using animalId 
   * 
   */
  @Override
  public List<Dx_animal> fetchDxAnimalByAnimalId(String animalId) {
    //data validation
    if((ad.fetchAnimal(animalId)).isEmpty()) {
      log.warn("The animalId you entered is not in our database, therefore"
          + " there are no dx_animal relationships created with it.");
      return null;
    }
    
    String sql = ""
        + "SELECT * "
        + "FROM dx_animal "
        + "WHERE animal_fk = :animal_fk";
    
    Animals animal = ds.getAnimal(animalId);

    Map<String,Object> params = new HashMap<>();
    
    params.put("animal_fk", animal.getAnimalPk());
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public Dx_animal mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long l = rs.getLong("dx_fk");
        Dx dx = null;
        if (l != 0) {
          dx = ds.getDxByFk(l);
        } 
        
        return Dx_animal.builder()
            .dxAnimalPk(rs.getLong("dx_animal_pk"))
            .dxAnimalId(rs.getString("dx_animal_id"))
            .animalObj(animal)
            .dxObj(dx)
            .build();
          }
    });
  }
  
  /*
   * This method is meant to return a specific dx_animal relationship
   * based on the unique id it was created with, this is primarily used 
   * to check if it's primary use is to check if a particular dxAnimalId
   * returns an empty list in order to validate data input
   * TODO could remove this method from being visible in swagger
   */
  @Override
  public List<Dx_animal> fetchDxAnimal(String dxAnimalId) {
    String sql = ""
        + "SELECT * "
        + "FROM dx_animal "
        + "WHERE dx_animal_id = :dx_animal_id";

    Map<String,Object> params = new HashMap<>();
    
    params.put("dx_animal_id", dxAnimalId);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public Dx_animal mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long l = rs.getLong("dx_fk");
        Dx dx = null;
        if (l != 0) {
          dx = ds.getDxByFk(l);
        } 
        l = rs.getLong("animal_fk");
        Animals animal = null;
        if (l != 0) {
          animal = ds.getAnimalByFk(l);
        } 
        
        return Dx_animal.builder()
            .dxAnimalPk(rs.getLong("dx_animal_pk"))
            .dxAnimalId(rs.getString("dx_animal_id"))
            .animalObj(animal)
            .dxObj(dx)
            .build();
          }
    });
  }
  
  @Override
  public Dx_animal createDxAnimal(String dxAnimalId, String animalId, String dxId) {
    
    Animals animal = ds.getAnimal(animalId); 
    Dx dx = ds.getDx(dxId);
    
    SqlParams params = generateInsertSql(dxAnimalId, animal, dx);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Long dxAnimalPk = keyHolder.getKey().longValue();
    return Dx_animal.builder()
        .dxAnimalPk(dxAnimalPk)
        .animalObj(animal)
        .dxObj(dx)
        .dxAnimalId(dxAnimalId)
        .build();
    }
  
  @Override
  public Dx_animal updateDxAnimal(String dxAnimalId, String newDxAnimalId, String animalId, String dxId) {
    
    //data validation
    if((fetchDxAnimal(dxAnimalId)).isEmpty()) {
      log.warn("The dxAnimalId you entered is not in our database, therefore"
          + " you cannot update it.");
      return null;
    } else if((ad.fetchAnimal(animalId)).isEmpty()) {
      log.warn("The animalId you entered is not in our database, therefore"
          + " you cannot update a dxAnimal relationship with it.");
      return null;
    } else if ((dd.fetchDx(dxId)).isEmpty()) {
      log.warn("The dxId you entered is not in our database, therefore"
          + " you cannot update a dxAnimal relationship with it.");
      return null;
    }
    
    //method
    Animals animal = ds.getAnimal(animalId); 
    Dx dx = ds.getDx(dxId);
    
    if (newDxAnimalId == null) {
      newDxAnimalId = dxAnimalId;
    }
    SqlParams params = generateUpdateSql(dxAnimalId, newDxAnimalId, animal, dx);
    
    jdbcTemplate.update(params.sql, params.source);
    
    Long dxAnimalPk = ds.getDxAnimal(newDxAnimalId).getDxAnimalPk();
    return Dx_animal.builder()
        .dxAnimalPk(dxAnimalPk)
        .animalObj(animal)
        .dxObj(dx)
        .dxAnimalId(newDxAnimalId)
        .build();
  }  
  
  @Override
  public Optional<Dx_animal> deleteDxAnimal(String dxAnimalId) {

    //data validation
    if((ds.getDxAnimal(dxAnimalId)) == null) {
      log.warn("The dxAnimalId you entered is not in our database, therefore"
          + " you cannot delete it.");
      return null;
    }   
    
    Dx_animal dxAnimal = ds.getDxAnimal(dxAnimalId);
    Animals animal = dxAnimal.getAnimalObj(); 
    Dx dx = dxAnimal.getDxObj();
    
    SqlParams params = generateDeleteSql(dxAnimalId);
    
    Long dxAnimalPk = ds.getDxAnimal(dxAnimalId).getDxAnimalPk();
    
    jdbcTemplate.update(params.sql, params.source);
    
    return Optional.ofNullable(Dx_animal.builder()
        .dxAnimalPk(dxAnimalPk)        
        .dxAnimalId(dxAnimalId)
        .animalObj(animal)
        .dxObj(dx)
        .build());
  }
  /*
   * sql statements
   */
  
  private SqlParams generateInsertSql(String dxAnimalId, Animals animal, Dx dx) {
    String sql = ""
        + "INSERT INTO dx_animal ("
        + "dx_animal_id, animal_fk, dx_fk) VALUES ("
        + ":dx_animal_id, :animal_fk, :dx_fk)";
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("dx_animal_id", dxAnimalId);
    params.source.addValue("animal_fk", animal.getAnimalPk());
    params.source.addValue("dx_fk", dx.getDxPk());
    
    return params;
    
  }
  
  private SqlParams generateUpdateSql(String dxAnimalId, String newDxAnimalId, Animals animal, Dx dx) {
    String sql = ""
        + "UPDATE dx_animal "
        + "SET dx_animal_id = :new_dx_animal_id, animal_fk = :animal_fk, "
        + "dx_fk = :dx_fk "
        + "WHERE dx_animal_id = :dx_animal_id";
    
    
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("dx_animal_id", dxAnimalId);
    params.source.addValue("new_dx_animal_id", newDxAnimalId);
    params.source.addValue("animal_fk", animal.getAnimalPk());
    params.source.addValue("dx_fk", dx.getDxPk());
    
    return params;
    
  }
  
  private SqlParams generateDeleteSql(String dxAnimalId) {
    String sql = ""
        + "DELETE FROM dx_animal "
        + "WHERE dx_animal_id = :dx_animal_id";
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("dx_animal_id", dxAnimalId);
    
    return params;
    
  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

}
