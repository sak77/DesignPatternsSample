package com.saket.designpatternssample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.saket.designpatternssample.Builder.VisaApplication;
import com.saket.designpatternssample.factory.Color;
import com.saket.designpatternssample.factory.ColorFactory;
import com.saket.designpatternssample.factory.FactoryProvider;
import com.saket.designpatternssample.factory.Hatchback;
import com.saket.designpatternssample.factory.VehiclFactory;
import com.saket.designpatternssample.factory.Vehicle;


/**
 * The purpose of this app to study the different design patterns in use.
 *
 * Lets start with Builder and Factory patterns. Builder pattern can be used
 * when the class initialization is more complex than simply calling the constructor.
 * Factory method works with a group of related objects. It abstracts the logic to determine
 * which object to create from the rest of the code.
 *
 * In most cases Builder and Factory patterns are used together. So suppose you can have a
 * factory class to determine which instance of a class to instantiate, but since the class
 * instantiation itself is complex, it uses a builder pattern to create its objects.
 *
 * In my case i would have used factory pattern in visas of the world, where based on the
 * different input parameters (country of origin, destination, purpose of travel, visa type)
 * i would have to create a visa type instance. Or in Super Skipper where based on the type
 * i would create a quiz or trivia or match stats card. Or also in AVIS car booking app where
 * the user gets to book a specific type of car based on their inputs.
 *
 * So here i will look at 3 types of vehicles (super class), sedan, hatchback and mini-van. Now
 * based on number of people a user can get one of these. So instead of creating individual
 * instances of each class, i will create a parent class vehicle and sub-classes sedan, hatchback
 * and mini-van. And a factory class that abstract the mapping logic.
 *
 * Next, abstract factory pattern is similar to factory pattern, but it is a factory of factories.
 * So in this case, we have a VehicleFactory class. We can also give the option to select color of
 * the vehicle
 */
public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VehiclFactory vehiclFactory = (VehiclFactory) FactoryProvider.getFactory("vehicle");
        ColorFactory colorFactory = (ColorFactory) FactoryProvider.getFactory("color");

        Vehicle vehicle1 = vehiclFactory.getVehicle(2);
        Color color1 = colorFactory.getColor(2);
        Log.d(TAG, "onCreate: vehicle1: " + vehicle1.getType());
        Log.d(TAG, "onCreate: color1: " + color1.getName());

        Vehicle vehicle2 = vehiclFactory.getVehicle(4);
        Color color2 = colorFactory.getColor(4);
        Log.d(TAG, "onCreate: vehlice2: " + vehicle2.getType());
        Log.d(TAG, "onCreate: color1: " + color2.getName());

        Vehicle vehicle3 = vehiclFactory.getVehicle(7);
        Color color3 = colorFactory.getColor(7);
        Log.d(TAG, "onCreate: vehicle3: " + vehicle3.getType());
        Log.d(TAG, "onCreate: color1: " + color3.getName());

        //Create a new Visa application
        VisaApplication visaApplication = new VisaApplication.VisaApplicationBuilder(1234)
                .setCountry_of_origin("")
                .setDate_of_travel("")
                .setDestination_country("")
                .setPurpose_of_travel("")
                .setNo_of_travellers(3)
                .Build();

        Shape shape = new Shape();
        shape.getName();

        Shape square = new Square();
        square.getName();

        AbstractShape abstractShape = new AbstractShape(); {
            @Override
            public void getAbstractName() {

            }
        };
    }



    public abstract class AbstractShape {
        public abstract void getAbstractName();
    }

    public class Shape {
        public void getName() {
            Log.d(TAG, "getName: Shape");
        }
    }


    public class Square extends Shape {

        //The below getName is overriden from parent
        //so it represents dynamic polymorphism
        @Override
        public void getName() {
            Log.d(TAG, "getName: Square");
        }

        //This getName is not overridden from parent class
        //so it is example of static polymorphism
        public void getName(String name) {
            Log.d(TAG, "getName: " + name);
        }
    }
}
