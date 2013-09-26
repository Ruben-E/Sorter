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

    public static Comparable generateRandomInteger() {
        return INTEGER_MIN_VALUE + (int) (Math.random() * ((INTEGER_MAX_VALUE - INTEGER_MIN_VALUE) + 1));
    }

    public static Comparable generateRandomString() {
        String randomWord = "";
        for (int i = 0; i < Math.random() * 30; i++) {
            int characterCode = WORD_MIN_CHAR + (int) (Math.random() * ((WORD_MAX_CHAR - WORD_MIN_CHAR) + 1));
            String character = Character.toString((char) characterCode);
            randomWord += character;
        }

        return (Comparable) randomWord;
    }

    public static Comparable generateRandomCar() {
        Car car = new Car();
        car.setTopSpeed(CAR_MIN_TOPSPEED + (int) (Math.random() * ((CAR_MAX_TOPSPEED - CAR_MIN_TOPSPEED) + 1)));
        car.setAcceleration((float) Math.random() * 10);

        return (Comparable) car;
    }

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

    public static Comparable[] generateRandomIntegers(int length) throws Exception {
        return ListGenerator.generateRandomList(Integer.class, length);
    }

    public static Comparable[] generateRandomStrings(int length) throws Exception {
        return ListGenerator.generateRandomList(String.class, length);
    }

    public static Comparable[] generateRandomCars(int length) throws Exception {
        return ListGenerator.generateRandomList(Car.class, length);
    }
}
