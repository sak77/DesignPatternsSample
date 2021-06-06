package com.saket.designpatternssample.factory;

/**
 * Created by sshriwas on 2020-02-08
 */
public class VehiclFactory implements AbstractFactory<Vehicle> {

    @Override
    public Vehicle create(int no_of_passengers) {
        return getVehicle(no_of_passengers);
    }

    public Vehicle getVehicle(int no_of_people) {
        if (no_of_people >= 0 && no_of_people <3) {
            return new Hatchback();
        } else if (no_of_people >=3 && no_of_people < 5) {
            return new Sedan();
        } else if (no_of_people < 13) {
            return new Minivan();
        } else return null;
    }

}
