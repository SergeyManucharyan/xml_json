package org.example.validation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.File;
import java.io.IOException;


    public class JsonValidation{

        public void validation() throws ProcessingException, IOException {
            File actorFile = new File("src/main/resources/actor.json");
            JsonNode actorJson = new ObjectMapper().readTree(actorFile);

            File schemaFile = new File("src/main/resources/author_schema.json");
            JsonNode schemaJson = new ObjectMapper().readTree(schemaFile);

            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaJson);

            try {
                schema.validate(actorJson);
                System.out.println("Validation succeeded");
            } catch (ProcessingException e) {
                System.out.println("Validation failed: " + e.getMessage());
            }
        }
    }
