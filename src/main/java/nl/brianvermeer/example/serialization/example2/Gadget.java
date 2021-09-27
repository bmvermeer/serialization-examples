package nl.brianvermeer.example.serialization.example2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Gadget implements Serializable {

    private Runnable command;

    public Gadget(Command command) {
        this.command = command;
    }

    private final void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        command.run();
    }
}
