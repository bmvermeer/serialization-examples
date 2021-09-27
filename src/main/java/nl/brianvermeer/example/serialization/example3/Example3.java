package nl.brianvermeer.example.serialization.example3;

import nl.brianvermeer.example.serialization.example1.ValueObject;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.map.LazyMap;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class Example3 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Start");

        // using LazyMap from commons collections
        Factory factory = () -> "Time: " + System.currentTimeMillis();

        Map<String, String> lazyMap = LazyMap.decorate(new HashMap<String, String>(), factory);
        System.out.println(lazyMap.get("Test"));



        //deserializing file to MyObject
        FileInputStream fileIn = new FileInputStream("payload.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ValueObject st1 = (ValueObject) in.readObject();
        System.out.println(st1);

        System.out.println("End");

    }
}
