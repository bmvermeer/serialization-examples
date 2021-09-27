package nl.brianvermeer.example.serialization.example2;

import nl.brianvermeer.example.serialization.example1.ValueObject;
import org.apache.commons.io.serialization.ValidatingObjectInputStream;

import java.io.*;

public class Example2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Example2 e = new Example2();
        e.run();
    }

    private void run() throws IOException, ClassNotFoundException {
//        var gadget = new Gadget(new Command("env"));
//        serializeObject(gadget, "Gadget.ser");

        deserializeValueObject("Gadget.ser");
//        safeDeserializeValueObject("Gadget.ser");
//        safeDeserializeValueObject2("Gadget.ser");

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

    private ValueObject safeDeserializeValueObject(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filename);
        ValidatingObjectInputStream in = new ValidatingObjectInputStream(fileIn);
        in.accept(ValueObject.class);
        ValueObject vo = (ValueObject) in.readObject();
        return vo;
    }

    private ValueObject safeDeserializeValueObject2(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ObjectInputFilter filesOnlyFilter = ObjectInputFilter.Config.createFilter("nl.brianvermeer.example.serialization.example2.ValueObject;!*");
        in.setObjectInputFilter(filesOnlyFilter);
        ValueObject vo = (ValueObject) in.readObject();
        return vo;
    }
}
