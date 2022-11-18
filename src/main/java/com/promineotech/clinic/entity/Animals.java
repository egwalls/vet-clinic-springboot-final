package com.promineotech.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Animals {
  private Long animalPk;
  private String animalId;
  private String animalName;
  private Species species;
  private String breed;
  private String symptoms;
  private Customers customer;
}
