package io.natewilcox;

import bsh.Interpreter;

/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {
        // Create some Java objects
        System.out.println("Running program");

        Car car = new Car("Toyota", 2010);
        Person person = new Person("Alice", car);

        // Instantiate the BeanShell interpreter
        Interpreter interpreter = new Interpreter();
        interpreter.setClassLoader(App.class.getClassLoader());

        try {
            // Pass Java objects into the BeanShell interpreter
            interpreter.set("person", person);
            interpreter.set("car", car);

            // BeanShell script to manipulate Java objects
            String script = """
                import io.natewilcox.*;

                // Print the current state of the person and car
                print("Initial state: " + person);
                print("Car details: " + car);
                
                Car c = new Car("BMW", 1972);
                Person p = new Person("Nathan", c);

                // Modify the car's make and model year through the script
                car.setMake("Honda");
                car.setModelYear(2022);
                
                // Print the updated state
                print("Updated state: " + person);
            """;

            // Evaluate the script
            interpreter.eval(script);

            System.out.print(car.getMake());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
