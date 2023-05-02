package org.example.gson;

import com.google.gson.Gson;
import org.example.classes.Actor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonJson {
    /**
     * serializing java object to json using Gson
     * @param actor object
     * @throws IOException
     */
    public static void serializing(Actor actor) throws IOException {
        FileWriter fileWriter=new FileWriter("src/main/resources/actor.json");
        Gson gson = new Gson();
        gson.toJson(actor,fileWriter);
        fileWriter.close();
    }
    /**
     * deserializing json object to java object using Gson
     * @param path from json file
     * @throws IOException
     */
    public static Actor deSerializing(String path) throws FileNotFoundException {
        Actor actor=new Gson().fromJson(new FileReader(path), Actor.class);
        return actor;
    }
}
