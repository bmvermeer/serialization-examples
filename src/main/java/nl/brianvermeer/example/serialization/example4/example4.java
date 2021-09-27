package nl.brianvermeer.example.serialization.example4;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class example4 {

    public static void main(String[] args) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.enableDefaultTyping();

        Person myvalue = om.readValue(Files.readAllBytes(Paths.get("evil.json")), Person.class);
        System.out.println("name:"+myvalue.name+" \n"+"Age:"+myvalue.age);
    }

}
