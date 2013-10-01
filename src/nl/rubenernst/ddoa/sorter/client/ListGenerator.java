package nl.rubenernst.ddoa.sorter.client;

import java.lang.reflect.Method;

/**
 * User: rubenernst
 * Date: 9/25/13
 * Time: 10:42 PM
 */
public class ListGenerator {
    final static int INTEGER_MIN_VALUE = 0;
    final static int INTEGER_MAX_VALUE = 200;
    final static int CAR_MIN_TOPSPEED = 120;
    final static int CAR_MAX_TOPSPEED = 250;
    final static int WORD_MIN_CHAR = 65;
    final static int WORD_MAX_CHAR = 122;

    /**
     * Generate a random integer
     *
     * @return A random Comparable integer
     */
    public static Comparable generateRandomInteger() {
        return INTEGER_MIN_VALUE + (int) (Math.random() * ((INTEGER_MAX_VALUE - INTEGER_MIN_VALUE) + 1));
    }

    /**
     * Generate a random string
     *
     * @return A random Comparable String
     */
    public static Comparable generateRandomString() {
        String randomWord = "";
        for (int i = 0; i < Math.random() * 30; i++) {
            int characterCode = WORD_MIN_CHAR + (int) (Math.random() * ((WORD_MAX_CHAR - WORD_MIN_CHAR) + 1));
            String character = Character.toString((char) characterCode);
            randomWord += character;
        }

        return (Comparable) randomWord;
    }

    /**
     * Generate a random Car
     *
     * @return A random Comparable car
     */
    public static Comparable generateRandomCar() {
        Car car = new Car();
        car.setTopSpeed(CAR_MIN_TOPSPEED + (int) (Math.random() * ((CAR_MAX_TOPSPEED - CAR_MIN_TOPSPEED) + 1)));
        car.setAcceleration((float) Math.random() * 10);

        return (Comparable) car;
    }

    /**
     * Generate a random list (array) of types, based on the type param.
     *
     * @param type   The array will be filled with random objects of this class.
     * @param length The length of the array, number of random objects.
     * @return Array with random objects of the type from the type parameter.
     * @throws Exception
     */
    public static Comparable[] generateRandomList(Class type, int length) throws Exception {
        if (length <= 0 || length > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }

        String className = type.getSimpleName();
        Class noParams[] = {};

        Class<?> cls = Class.forName("nl.rubenernst.ddoa.sorter.client.ListGenerator");

        Method method = cls.getMethod("generateRandom" + className, noParams);

        Comparable[] list = new Comparable[length];
        for (int i = 0; i < length; i++) {
            list[i] = (Comparable) method.invoke(null, null);
        }

        return list;
    }

    /**
     * Generate an array with random cars
     *
     * @param length Length of the array
     * @return Array with random cars
     * @throws Exception
     */
    public static Comparable[] generateRandomIntegers(int length) throws Exception {
        return ListGenerator.generateRandomList(Integer.class, length);
    }

    /**
     * Generate an array with random strings
     *
     * @param length Length of the Array
     * @return Array with random strings
     * @throws Exception
     */
    public static Comparable[] generateRandomStrings(int length) throws Exception {
        return ListGenerator.generateRandomList(String.class, length);
    }

    /**
     * Generate an array with random cars
     *
     * @param length Length of the Array
     * @return Array with random cars
     * @throws Exception
     */
    public static Comparable[] generateRandomCars(int length) throws Exception {
        return ListGenerator.generateRandomList(Car.class, length);
    }
}
