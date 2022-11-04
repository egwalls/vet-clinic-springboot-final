package com.promineotech.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dx {
  private Long dxPk;
  private String dxId;
  private String dxName;
  private String description;

}
