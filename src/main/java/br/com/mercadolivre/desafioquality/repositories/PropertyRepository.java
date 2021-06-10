package br.com.mercadolivre.desafioquality.repositories;

import br.com.mercadolivre.desafioquality.entities.Property;

import java.util.ArrayList;
import java.util.List;

public class PropertyRepository {

    private static List<Property> propertyList = new ArrayList<>();

    public static List<Property> getPropertyList(){
        return propertyList;
    }

    public static void insertNewProperty(Property property){
        propertyList.add(property);
    }
}
