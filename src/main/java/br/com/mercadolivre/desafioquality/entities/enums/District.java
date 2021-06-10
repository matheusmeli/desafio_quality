package br.com.mercadolivre.desafioquality.entities.enums;

import java.util.Arrays;

public enum District {

    JARDIMJULIO(10.0),
    JARDIMSILVEIRA(12.0),
    ALPHAVILLE(50.0);

    private final double squareFootValue;

    District(double squareFootValue) {
        this.squareFootValue = squareFootValue;
    }

    public double getSquareFootValue() {
        return squareFootValue;
    }

    public static double getSquareFootValue(String districtName) {
        return Arrays.stream(District.values())
                .filter(distric -> distric.toString().equalsIgnoreCase(districtName))
                .findFirst()
                .get()
                .getSquareFootValue();
    }
}
