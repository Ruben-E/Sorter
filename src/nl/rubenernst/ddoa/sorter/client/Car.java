package nl.rubenernst.ddoa.sorter.client;

import java.io.Serializable;

/**
 * User: rubenernst
 * Date: 9/26/13
 * Time: 3:16 PM
 */
public class Car implements Comparable, Serializable {
    private String brand;
    private String model;
    private int topSpeed;
    private float acceleration;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Car) {
            Car compareCar = (Car) o;

            Integer topSpeed = this.getTopSpeed();
            return topSpeed.compareTo(compareCar.getTopSpeed());
        } else {
            throw new IllegalArgumentException();
        }
    }
}
