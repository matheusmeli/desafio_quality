package br.com.mercadolivre.desafioquality.util;

import br.com.mercadolivre.desafioquality.entities.Property;
import br.com.mercadolivre.desafioquality.entities.Room;

import java.util.Arrays;
import java.util.List;

public class TestUtilGenerator {

    public static Property getProperty(){
        Room room1 = new Room("LivingRoom", 10.2, 5.0);
        Room room2 = new Room("Kitchen", 2.5, 4.0);

        return new Property("MatheusHouse", "JardimJulio", Arrays.asList(room1, room2));
    }

    public static Property getPropertyWithInvalidDistrict(){
        Room room1 = new Room("LivingRoom", 10.2, 5.0);
        Room room2 = new Room("Kitchen", 2.5, 4.0);

        return new Property("MatheusHouse", "SesameStreet   ", Arrays.asList(room1, room2));
    }

    public static List<Property> getPropertyList() {
        Room room1 = new Room("LivingRoom", 10.2, 5.0);
        Room room2 = new Room("Kitchen", 2.5, 4.0);

        Property property1 = new Property("MatheusHouse", "JardimJulio", Arrays.asList(room1, room2));

        Room room3 = new Room("LivingRoom", 10.2, 5.0);
        Room room4 = new Room("Kitchen", 2.5, 4.0);

        Property property2 = new Property("PatriciaHouse", "Alphaville", Arrays.asList(room3, room4));

        Room room5 = new Room("LivingRoom", 10.2, 5.0);
        Room room6 = new Room("Kitchen", 2.5, 4.0);

        Property property3 = new Property("ReginaHouse", "JardimJulio", Arrays.asList(room5, room6));

        return Arrays.asList(property1, property2, property3);
    }
}
