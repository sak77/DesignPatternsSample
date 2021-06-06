package com.saket.designpatternssample.factory;

/**
 * Created by sshriwas on 2020-02-08
 */
public interface AbstractFactory <T> {

    T create(int no_of_passengers);
}
