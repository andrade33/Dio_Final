/////////////////////////////////////////////////////////////////
package br.com.projetodio.parking.model;
/////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////
@Data
@AllArgsConstructor
@NoArgsConstructor // Não precisa do construtor vazio
public class Parking {
    
    private String id;
    private String licence;
    private String state;
    private String model;
    private String color;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private double bill;

    public Parking(String id, String licence, String state, String model, String color){
        this.id= id;
        this.licence = licence;
        this.state = state;
        this.model = model;
        this.color = color;

    }
}
/////////////////////////////////////////////////////////////////
