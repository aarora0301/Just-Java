package Just_Java.Reflections.Serializer;

import Just_Java.Reflections.Car;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Ford", "Figo", "2019");
        JSONSerializer serializer = new JSONSerializer();
        System.out.println(serializer.serialize(car));
    }
}
