package com.saket.designpatternssample.factory;

/**
 * Created by sshriwas on 2020-02-08
 */
public class ColorFactory implements AbstractFactory<Color> {

    public enum VehicleType {HATCH, SEDAN, VAN}

    @Override
    public Color create(int no_of_passengers) {
        return getColor(no_of_passengers);
    }


    /*
    Based on type of car we have 3 colors
     */
    public Color getColor(int no_of_people) {
        if (no_of_people>=0 && no_of_people < 3) {
            return getVehicleColor(VehicleType.HATCH);
        } else if (no_of_people >=3 && no_of_people < 5) {
            return getVehicleColor(VehicleType.SEDAN);
        } else if (no_of_people <= 13) {
            return getVehicleColor(VehicleType.VAN);
        } else return null;
    }

    private Color getVehicleColor(Enum vehicletype) {
        if (vehicletype == VehicleType.HATCH) {
            return new Red();
        } else if (vehicletype == VehicleType.SEDAN) {
            return new Green();
        } else if (vehicletype == VehicleType.VAN) {
            return new Blue();
        }
        else return null;
    }
}
