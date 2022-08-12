/////////////////////////////////////////////////////////////////
package br.com.projetodio.parking.controller;
/////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetodio.parking.controller.dto.ParkingDTO;
import br.com.projetodio.parking.controller.dto.parkingCreateDTO;
import br.com.projetodio.parking.controller.mapper.ParkingMapper;
import br.com.projetodio.parking.model.Parking;
import br.com.projetodio.parking.service.ParkingService;
import lombok.Data;
/////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////
@Data
@RestController
@RequestMapping("/parking")

public class ParkingController {   

    /////////////////////////////////////////////////////////////
    // Injetando dependencia pelo autowired, mas nas versões mais nova não é recomendado
    // @Autowired
    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;
    /////////////////////////////////////////////////////////////
    
    /////////////////////////////////////////////////////////////
    // Injeção de depenência através de construtor
    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper){
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }
    /////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////
    @GetMapping
    public ResponseEntity<List<ParkingDTO>> findAll(){
        List<Parking> parkingList = parkingService.findaAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
    }

    /////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////
    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
        Parking parking = parkingService.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }
    /////////////////////////////////////////////////////////////
    
    /////////////////////////////////////////////////////////////
    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody parkingCreateDTO dto){
        var parkingCreate = (Parking) parkingMapper.toParkingCreate(dto);
        Parking parking = parkingService.create(parkingCreate);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
/////////////////////////////////////////////////////////////////
