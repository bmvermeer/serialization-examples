package nl.brianvermeer.example.serialization.example4;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class Person4b {

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    public Object name;
    public int age;
}