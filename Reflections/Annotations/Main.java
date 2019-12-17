package Just_Java.Reflections.Annotations;

        import Just_Java.Reflections.Car;

public class Main {

    public static void main(String[] args) {
        Car car = new Car("Hyundai", "Venue", "2019");
        JSONSerializer serializer = new JSONSerializer();
        System.out.println(serializer.serialize(car));
    }
}
