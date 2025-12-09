package com.doku.my.trainingbesenangpay01.package_class_datatypes.serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author Daniel Joi Partogi Hutapea
 */
@Getter @Setter @AllArgsConstructor @ToString
public class Person implements Serializable
{
    @Serial private static final long serialVersionUID = 1L;

    private String name;
    private final int age;
    private transient String additionalInfo;

    public static <T> void saveObject(T obj)
    {
        try
        (
            var fileOut = new FileOutputStream("my-java-object.ser");
            var out = new ObjectOutputStream(fileOut)
        )
        {
            out.writeObject(obj);
            System.out.println("Object serialized successfully to: my-java-object.ser");
        }
        catch(Exception ex)
        {
            ex.printStackTrace(System.err);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T loadObject()
    {
        try
        (
            var fileIn = new FileInputStream("my-java-object.ser");
            var out = new ObjectInputStream(fileIn)
        )
        {
            T result = (T) out.readObject();
            System.out.println("Object deserialized successfully.");
            return result;
        }
        catch(Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args)
    {
        Person p1 = new Person("John", 30, "addInfo");
        System.out.println("Real Object  : " + p1);
        saveObject(p1);

        System.out.println("========================================");

        Person p2 = loadObject();
        System.out.println("Loaded Object: " + p2);
    }
}
