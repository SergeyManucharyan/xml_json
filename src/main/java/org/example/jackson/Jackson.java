package org.example.jackson;

import org.example.classes.Actor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson {
    /**
     * serializing java object to json using Jackson
     * @param actor object
     * @throws IOException
     */
    public static void toJson(Actor actor) throws IOException {
        ObjectMapper mapper= new ObjectMapper();
        mapper.writeValue(new File("src/main/resources/jackson_actor.json"),actor);

    }

    /**
     * deserializing json object to java object using Gson
     * @param path from json file
     * @return
     * @throws IOException
     */
    public static Actor fromJson(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(path),Actor.class);
    }
}
