package nl.brianvermeer.example.serialization.example1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ValueObject implements Serializable {

    private String value;
    private String sideEffect;

    private ValueObject() {
        this("empty");
    }

    public ValueObject(String value) {
        System.out.println("created with constructor");
        this.value = value;
        this.sideEffect = java.time.LocalTime.now().toString();
    }

    @Override
    public String toString() {
        return "ValueObject{" +
                "value='" + value + '\'' +
                ", sideEffect='" + sideEffect + '\'' +
                '}';
    }
}


//    private final void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        System.out.println("READOBJECT");
//        in.defaultReadObject();
//    }
