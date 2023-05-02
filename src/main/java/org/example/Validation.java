package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.example.classes.Actor;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Validation {
    /**
     *  Validate  xml  and xsd  using  javax.xml.validation  lib
     * @param xmlPath path String
     * @param xsdPath path String
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public static void JavaxXmlValidation(String xmlPath,String xsdPath) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = parser.parse(new File(xmlPath));
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(new File(xsdPath));
        Schema schema = factory.newSchema(schemaFile);
        Validator validator = schema.newValidator();
        try {
            validator.validate(new DOMSource(document));
            System.out.println("Correct");
        } catch (SAXException e) {
            System.out.println("Incorrect");
        }
    }

    /**
     *Validate  xml  and xsd  using   JAXB  lib
     * @param xml path String
     * @param xsd path String
     * @throws JAXBException
     */
    public static void xmlValidatorUsingJAXB(String xml,String xsd) throws JAXBException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Actor.class);
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File xsdFile = new File(xsd);
            Schema schema = schemaFactory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            File xmlFile=new File(xml);
            DocumentBuilderFactory builderFactory =DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =builderFactory.newDocumentBuilder();
            Document document=builder.parse(xmlFile);
            DOMSource source= new DOMSource(document);
            validator.validate(source);
            System.out.println(xmlFile.getName()+" is valid");
        } catch (Exception e) {
            System.out.println("xml is not valid "+e.getMessage());
        }
    }

    /**
     * Validate  json   using  json-schema-validator
     * @param jsonPath path String
     * @param schemaPath path String
     * @throws ProcessingException
     * @throws IOException
     */
        public void JsonValidation(String jsonPath,String schemaPath) throws ProcessingException, IOException {
            File actorFile = new File(jsonPath);
            JsonNode actorJson = new ObjectMapper().readTree(actorFile);

            File schemaFile = new File(schemaPath);
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
