/////////////////////////////////////////////////////////////////
package br.com.projetodio.parking.service;
/////////////////////////////////////////////////////////////////

import java.time.LocalDateTime;
/////////////////////////////////////////////////////////////////
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import br.com.projetodio.parking.model.Parking;
/////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////
@Service
public class ParkingService {

    /////////////////////////////////////////////////////////////
    private static Map<String, Parking> parkingMap = new HashMap<>(); 
    /////////////////////////////////////////////////////////////
    
    /////////////////////////////////////////////////////////////
    static {
        var id = (String) getUUID(); 
        var id1 = (String) getUUID(); 
        Parking parking = new Parking(id, "XXX - 1111", "SC", "CELTA", "PRETO");
        Parking parking1 = new Parking(id1, "ZZZ - 1111", "RN", "CORSA", "AZUL");
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking1);
    }
    
    /////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////
    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
    /////////////////////////////////////////////////////////////
    
    /////////////////////////////////////////////////////////////
    public List<Parking> findaAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    public Parking findById(String id) {
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }
}
/////////////////////////////////////////////////////////////////