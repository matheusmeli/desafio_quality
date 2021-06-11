package br.com.mercadolivre.desafioquality.resources;


import br.com.mercadolivre.desafioquality.entities.Property;
import br.com.mercadolivre.desafioquality.entities.Room;
import br.com.mercadolivre.desafioquality.exceptions.InvalidDistrictException;
import br.com.mercadolivre.desafioquality.repositories.PropertyRepository;
import br.com.mercadolivre.desafioquality.services.PropertyService;
import br.com.mercadolivre.desafioquality.util.TestUtilGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PropertyResourceTests {

    PropertyService propertyService;
    PropertyResource propertyResource;

    @BeforeEach
    private void setUp(){
        propertyResource = new PropertyResource();
        propertyService = new PropertyService();
        PropertyRepository.getPropertyList().clear();
    }

    @Test
    public void findProperty(){
        Property property = TestUtilGenerator.getProperty();
        PropertyRepository.insertNewProperty(property);

        Property propertySaved = PropertyRepository.getPropertyList().get(0);

        assertEquals(property, propertySaved);
    }

    @Test
    public void findAllProperties() {
        List<Property> propertyList = TestUtilGenerator.getPropertyList();
        propertyList.forEach(PropertyRepository::insertNewProperty);

        List<Property> propertyListSaved = PropertyRepository.getPropertyList();

        assertEquals(propertyList, propertyListSaved);
    }

    @Test
    public void testPropertySquareRoot(){
        Property property = TestUtilGenerator.getProperty();
        PropertyRepository.insertNewProperty(property);

        Double body = propertyResource.getTotalPropertySquareFoot(1).getBody();

        assertEquals(61, body);
    }

    @Test()
    public void testPropertyWithInvalidDistrict(){
        Property propertyWithInvalidDistrict = TestUtilGenerator.getPropertyWithInvalidDistrict();

        assertThrows(InvalidDistrictException.class,
                () -> propertyResource.insertNewProperty(propertyWithInvalidDistrict).getBody().toString());
    }

    @Test
    public void testLargestPropertyRoom(){
        Property property = TestUtilGenerator.getProperty();
        PropertyRepository.insertNewProperty(property);

        Room largestRoom = propertyResource.getLargestRoom(1).getBody();

        assertEquals(property.getRooms().get(0), largestRoom);
    }

    @Test
    public void testSquareRootRoom(){
        Property property = TestUtilGenerator.getProperty();
        PropertyRepository.insertNewProperty(property);

        Double squareFoot = PropertyRepository.getPropertyList().get(0).getRooms().get(0).getSquareFoot();

        assertEquals(51, squareFoot);
    }

    @Test
    public void testPropertyValue() {
        Property property = TestUtilGenerator.getProperty();
        PropertyRepository.insertNewProperty(property);

        Double propertyValue = propertyResource.getPropertyValue(1).getBody();

        assertEquals(610, propertyValue);
    }
}
