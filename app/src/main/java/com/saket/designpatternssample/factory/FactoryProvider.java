package com.saket.designpatternssample.factory;

/**
 * Created by sshriwas on 2020-02-08
 */
public class FactoryProvider {

    public static AbstractFactory getFactory(String type) {
        if (type.equalsIgnoreCase("vehicle")) {
            return new VehiclFactory();
        }else {
            return new ColorFactory();
        }
    }
}
