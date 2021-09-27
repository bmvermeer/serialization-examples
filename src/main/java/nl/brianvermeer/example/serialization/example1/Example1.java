package nl.brianvermeer.example.serialization.example1;

import nl.brianvermeer.example.serialization.example1.ValueObject;

import java.io.*;

public class Example1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Example1 e1 = new Example1();
        e1.run();
    }

    private void run() throws IOException, ClassNotFoundException {
        ValueObject vo1 = new ValueObject("Hi");
        System.out.println(vo1);
        serializeObject(vo1, "ValueObject.ser");

        ValueObject deserializedObject = deserializeValueObject("ValueObject.ser");
        System.out.println(deserializedObject);
    }

    private void serializeObject(Object o, String filename) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(o);
        out.close();
        fileOut.close();
    }

    private ValueObject deserializeValueObject(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ValueObject vo = (ValueObject) in.readObject();
        return vo;
    }

}
