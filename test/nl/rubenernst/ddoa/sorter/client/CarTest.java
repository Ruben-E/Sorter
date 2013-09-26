package nl.rubenernst.ddoa.sorter.client;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * User: rubenernst
 * Date: 9/26/13
 * Time: 3:27 PM
 */
public class CarTest {
    @Test
    public void testGetBrand() throws Exception {
        Car car = new Car();
        car.setBrand("Audi");

        assertEquals("Audi", car.getBrand());
    }

    @Test
    public void testSetBrand() throws Exception {
        Car car = new Car();
        car.setBrand("Audi");

        assertEquals("Audi", car.getBrand());
    }

    @Test
    public void testGetModel() throws Exception {
        Car car = new Car();
        car.setModel("A4");

        assertEquals("A4", car.getModel());
    }

    @Test
    public void testSetModel() throws Exception {
        Car car = new Car();
        car.setModel("A4");

        assertEquals("A4", car.getModel());
    }

    @Test
    public void testGetTopSpeed() throws Exception {
        Car car = new Car();
        car.setTopSpeed(230);

        assertEquals(230, car.getTopSpeed());
    }

    @Test
    public void testSetTopSpeed() throws Exception {
        Car car = new Car();
        car.setTopSpeed(230);

        assertEquals(230, car.getTopSpeed());
    }

    @Test
    public void testGetAcceleration() throws Exception {
        Car car = new Car();
        car.setAcceleration(7.5f);

        assertEquals(7.5f, car.getAcceleration(), 0);
    }

    @Test
    public void testSetAcceleration() throws Exception {
        Car car = new Car();
        car.setAcceleration(7.5f);

        assertEquals(7.5f, car.getAcceleration(), 0);
    }

    @Test
    public void testCompareTo() throws Exception {
        Car car1 = new Car();
        Car car2 = new Car();

        car1.setTopSpeed(230);
        car2.setTopSpeed(230);

        assertTrue(car1.compareTo(car2) == 0);

        car1.setTopSpeed(230);
        car2.setTopSpeed(200);

        assertTrue(car1.compareTo(car2) >= 1);

        car1.setTopSpeed(200);
        car2.setTopSpeed(230);

        assertTrue(car1.compareTo(car2) >= -1);
    }
}
