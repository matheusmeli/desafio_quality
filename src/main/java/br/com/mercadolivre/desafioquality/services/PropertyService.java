package br.com.mercadolivre.desafioquality.services;

import br.com.mercadolivre.desafioquality.entities.Property;
import br.com.mercadolivre.desafioquality.entities.Room;
import br.com.mercadolivre.desafioquality.entities.enums.District;
import br.com.mercadolivre.desafioquality.exceptions.InvalidDistrictException;
import br.com.mercadolivre.desafioquality.repositories.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class PropertyService {

    public double getTotalPropertySquareFoot(Integer id){
        Property property = PropertyRepository.getPropertyList().get(id - 1);
        return property.getRooms().stream().mapToDouble(Room::getSquareFoot).sum();
    }

    public Property getProperty(Integer id) {
        return PropertyRepository.getPropertyList().get(id - 1);
    }

    public List<Property> getPropertyList() {
        return PropertyRepository.getPropertyList();
    }

    public double getPropertyValue(Integer id){
        Property property = PropertyRepository.getPropertyList().get(id - 1);
        double squareFootValue = District.getSquareFootValue(property.getDistrict());
        return getTotalPropertySquareFoot(id) * squareFootValue;
    }

    public Room getLargestRoom(Integer id){
        Property property = PropertyRepository.getPropertyList().get(id - 1);
        return property.getRooms().stream().max(Comparator.comparing(Room::getSquareFoot)).get();
    }

    public void insertNewProperty(Property property) {
        Arrays.stream(District.values())
                .filter(district -> district.toString().equalsIgnoreCase(property.getDistrict()))
                .findFirst()
                .orElseThrow(InvalidDistrictException::new);
        PropertyRepository.insertNewProperty(property);
    }

    public List<Room> getEachRoomSquareFoot(Integer id) {
        return PropertyRepository.getPropertyList().get(id - 1).getRooms();
    }

}
