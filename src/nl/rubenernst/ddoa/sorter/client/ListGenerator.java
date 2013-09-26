package nl.rubenernst.ddoa.sorter.client;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: rubenernst
 * Date: 9/25/13
 * Time: 10:42 PM
 */
public class ListGenerator {
    final static int MIN_INT = 0;
    final static int MAX_INT = 200;


    public static Comparable[] generateRandomIntegers(int length) {
        if (length <= 0 || length > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }

        Comparable[] list = new Comparable[length];
        for (int i = 0; i < length; i++) {
            list[i] = MIN_INT + (int) (Math.random() * ((MAX_INT - MIN_INT) + 1));
        }

        return list;
    }

    public static Comparable[] generateRandomStrings(int length) {
        if (length <= 0 || length > Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }

        Comparable[] list = new Comparable[length];
        for (int i = 0; i < length; i++) {
            String randomWord = "";
            for (int j = 0; j < Math.random() * 30; j++) {
                int characterCode = 65 + (int) (Math.random() * ((122 - 65) + 1));
                String character = Character.toString((char) characterCode);
                randomWord += character;
            }
            list[i] = randomWord;
        }

        return list;
    }

    public static Comparable[] generateRandomList(Class type, int length) {
        String className = type.getSimpleName();

        try {
            Class[] paramInt = new Class[1];
            paramInt[0] = Integer.TYPE;

            Class<?> cls;
            cls = Class.forName("nl.rubenernst.ddoa.sorter.client.ListGenerator");

            Method method = cls.getMethod("generateRandom" + className + "s", paramInt);

            return (Comparable[]) method.invoke(null, length);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        return null;
    }
}
