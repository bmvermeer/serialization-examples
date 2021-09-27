package nl.brianvermeer.example.serialization.example4;

import nl.brianvermeer.example.serialization.example2.Command;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Gadget {

    private Runnable command;

    public Gadget(String value) {
        this.command = new Command(value);
        this.command.run();
    }
}
