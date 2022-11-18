package com.promineotech.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dx_animal {
  private Long dxAnimalPk;
  private String dxAnimalId;
  private Animals animalObj;
  private Dx dxObj;

}
