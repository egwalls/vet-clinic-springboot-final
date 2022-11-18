package com.promineotech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.clinic.entity.Dx;
import com.promineotech.clinic.entity.Dx_animal;
import com.promineotech.clinic.entity.Species;
import com.promineotech.clinic.entity.Animals;


@Component
public class DefaultDxAnimalDao implements DxAnimalDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Dx_animal> fetchDxAnimal(String animalId) {
//    String sql = "SELECT dx_animal.dx_animal_id, animals.animal_name, dx.dx_name "
//        + "FROM dx_animal "
//        + "INNER JOIN animals ON dx_animal.animal_fk = animals.animal_pk"
//        + "INNER JOIN dx ON dx_animal.dx_fk = dx.dx_pk"
//        + "WHERE animals.animal_id = :animal_id";
    
    String sql = ""
        + "SELECT * "
        + "FROM dx_animal "
        + "WHERE animal_fk = :animal_fk";
    
    Map<String,Object> params = new HashMap<>();
    params.put("animal_fk", 1);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public Dx_animal mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Dx_animal.builder()
            .dxAnimalPk(rs.getLong("dx_animal_pk"))
            .dxAnimalId(rs.getString("dx_animal_id"))
            .build();
        //how to do build statements with objects?
      }
    });
  }
  

  @Override
  public Optional<Dx_animal> createDxAnimalString(String dxId, String dxName, String description) {
    // TODO Auto-generated method stub
    return Optional.empty();
  }


  @Override
  public Dx_animal createDxAnimal(String dxAnimalId, Animals animal, Dx dx) {
    
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
  
  private SqlParams generateInsertSql(String dxAnimalId, Animals animal, Dx dx) {
    String sql = ""
        + "INSERT INTO dx_animal ("
        + "dx_animal_id, animal_fk, dx_fk) VALUES ("
        + ":dx_animal_id, :animal_fk, dx_fk)";
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("dx_animal_id", dxAnimalId);
    params.source.addValue("animal_fk", animal.getAnimalPk());
    params.source.addValue("dx_fk", dx.getDxPk());
    
    return params;
    
  }

  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

  @Override
  public Optional<Animals> fetchAnimals(String animalId) {
    String sql = ""
        + "SELECT * "
        + "FROM animals "
        + "WHERE animal_id = :animal_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("animal_id", animalId);
    
    

    return Optional.ofNullable(jdbcTemplate.query(sql, params, new AnimalResultSetExtractor()));
  }


  @Override
  public Optional<Dx> fetchDx(String dxId) {
    String sql = ""
        + "SELECT * "
        + "FROM dx "
        + "WHERE dx_id = :dx_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("dx_id", dxId);
    
    

    return Optional.ofNullable(jdbcTemplate.query(sql, params, new DxResultSetExtractor()));
  }
  
  class AnimalResultSetExtractor implements ResultSetExtractor<Animals> {
    @Override
    public Animals extractData(ResultSet rs) throws SQLException, DataAccessException {
      return Animals.builder()
          .animalPk(rs.getLong("animal_pk"))
          .animalId(rs.getString("animal_id"))
          .animalName(rs.getString("animal_name"))
          .species(Species.valueOf(rs.getString("species")))
          .breed(rs.getString("breed"))
          .symptoms(rs.getString("symptoms"))
          .build();
    }
    
  }
  
  class DxResultSetExtractor implements ResultSetExtractor<Dx> {
    @Override
    public Dx extractData(ResultSet rs) throws SQLException, DataAccessException {
      return Dx.builder()
          .dxPk(rs.getLong("dx_pk"))
          .dxId(new String(rs.getString("dx_id")))
          .dxName(new String(rs.getString("dx_name")))
          .description(new String(rs.getString("dx_description")))
          .build();
    }
  }
  
  

}
