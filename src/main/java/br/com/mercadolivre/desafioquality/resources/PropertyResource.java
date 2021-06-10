package br.com.mercadolivre.desafioquality.resources;

import br.com.mercadolivre.desafioquality.entities.Property;
import br.com.mercadolivre.desafioquality.entities.Room;
import br.com.mercadolivre.desafioquality.services.PropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyResource {

    private final PropertyService propertyService;

    public PropertyResource(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    public PropertyResource() {
        this.propertyService = new PropertyService();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/newProperty")
    public ResponseEntity<Void> insertNewProperty(@Valid @RequestBody Property property){
        propertyService.insertNewProperty(property);
        return ResponseEntity.ok().body(null);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Property> getProperty(@PathVariable Integer id){
        Property property = propertyService.getProperty(id);
        return ResponseEntity.ok(property);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Property>> getPropertyList(){
        List<Property> propertyList = propertyService.getPropertyList();
        return ResponseEntity.ok(propertyList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/squareFoot")
    public ResponseEntity<Double> getTotalPropertySquareFoot(@PathVariable Integer id){
        double totalPropertySquareFoot = propertyService.getTotalPropertySquareFoot(id);
        return ResponseEntity.ok(totalPropertySquareFoot);
    }

        @RequestMapping(method = RequestMethod.GET, value = "/{id}/value")
    public ResponseEntity<Double> getPropertyValue(@PathVariable Integer id){
        double propertyValue = propertyService.getPropertyValue(id);
        return ResponseEntity.ok(propertyValue);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/largestRoom")
    public ResponseEntity<Room> getLargestRoom(@PathVariable Integer id){
        Room largestRoom = propertyService.getLargestRoom(id);
        return ResponseEntity.ok(largestRoom);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/roomsSquareFoot")
    public ResponseEntity<List<Room>> getEachRoomSquareFoot(@PathVariable Integer id){
        return ResponseEntity.ok(propertyService.getEachRoomSquareFoot(id));
    }
}
