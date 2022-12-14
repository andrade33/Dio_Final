/////////////////////////////////////////////////////////////////
package br.com.projetodio.parking.controller.dto;
/////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
/////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////
@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // remove objetos nulos do resultado;
public class ParkingDTO {
    
    private String id;
    private String licence;
    private String state;
    private String model;
    private String color;

    @JsonFormat(pattern = "dd/mm/yyyy hh:mm")
    private LocalDateTime entryDate;

    @JsonFormat(pattern = "dd/mm/yyyy hh:mm")
    private LocalDateTime exitDate;
    private double bill;
}
/////////////////////////////////////////////////////////////////