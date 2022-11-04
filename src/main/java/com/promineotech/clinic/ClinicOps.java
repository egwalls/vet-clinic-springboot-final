package com.promineotech.clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class ClinicOps {

  public static void main(String[] args) {
    SpringApplication.run(ClinicOps.class, args);

  }

}
