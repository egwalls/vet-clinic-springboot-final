package com.promineotech.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customers {
  private Long customerPk;
  private String customerId;
  private String fName;
  private String lName;
  private String phone;
  private String address;  

}
