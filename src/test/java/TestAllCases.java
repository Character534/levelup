import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by Character on 26.02.2016.
 */
public class TestAllCases extends Assert {

    public void showClass (Object obj) throws IllegalAccessException {

        Class c = obj.getClass();
        System.out.println(c.getName());
        Field[] Fields = c.getDeclaredFields();
        for (Field field : Fields) {
            Class fieldType = field.getType();
            field.setAccessible(true);
            System.out.print("Имя: " + field.getName() + " ");
            System.out.print("Тип: " + fieldType.getName() + " ");
            System.out.println("Значение: " + field.get(obj));
        }

    }

    public void saveClass(Object obj, String filename) throws IllegalAccessException {

        try (PrintWriter pW = new PrintWriter(filename)) {
            Class c = obj.getClass();
            pW.println(c.getName());
            Field[] Fields = c.getDeclaredFields();
            for (Field field : Fields) {
                //Class fieldType = field.getType();
                field.setAccessible(true);
                pW.print(field.getName() + " = ");
                pW.println(field.get(obj));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object loadClass(String filename) throws ClassNotFoundException, IllegalAccessException, InstantiationException, FileNotFoundException, NoSuchMethodException {

            Scanner scanner = new Scanner(new File(filename));
            String className = scanner.nextLine();
            Class c = Class.forName(className);
            Object object = c.newInstance();


            Field[] Fields = c.getDeclaredFields();
            for (Field field : Fields) {
                String name = scanner.next();
                assert name.equals(field.getName());
                scanner.next();
                String value = scanner.next();

                field.setAccessible(true);
                if (field.getType().equals(Double.TYPE))
                    field.set(object, Double.valueOf(value));
                if (field.getType().equals(Integer.TYPE))
                    field.set(object, Integer.valueOf(value));
                if (field.getType().equals(Byte.TYPE))
                    field.set(object, Byte.valueOf(value));
                if (field.getType().equals(Short.TYPE))
                    field.set(object, Short.valueOf(value));
                if (field.getType().equals(Long.TYPE))
                    field.set(object, Long.valueOf(value));
                if (field.getType().equals(Float.TYPE))
                    field.set(object, Float.valueOf(value));
                if (field.getType().equals(Boolean.TYPE))
                    field.set(object, Boolean.valueOf(value));
//                if (field.getType().equals(Character.TYPE))
//                    field.set(object, value);

            }
            return object;
    }


        @Test
    public void test() throws IllegalAccessException, InstantiationException, ClassNotFoundException, FileNotFoundException, NoSuchMethodException{

       // saveClass();

       AllCases aC = new AllCases();
       showClass(aC);
            System.out.println();
       saveClass(aC, "test.txt");
       AllCases newAllCases = (AllCases) loadClass("test.txt");
       showClass(newAllCases);
       assertEquals(aC, newAllCases);

    }
}
