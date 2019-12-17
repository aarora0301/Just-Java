package Just_Java.Reflections;

import Just_Java.Reflections.Annotations.JsonField;

import java.io.Serializable;

public class Car implements Serializable {

    @JsonField
    private String make;
    @JsonField
    private String model;
    private String year;


    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
