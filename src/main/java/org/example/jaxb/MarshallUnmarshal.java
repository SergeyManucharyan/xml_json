package org.example.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.example.classes.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MarshallUnmarshal {
    /**
     * marshaling
     * @param student object
     * @throws JAXBException
     */
    public static void marshall(Student student) throws JAXBException {
        JAXBContext context=JAXBContext.newInstance(Student.class);
        Marshaller marshaller= context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(student, new File("src/main/resources/student.xml"));
    }

    /**
     * unmarshalling
     * @param path to xml file
     * @return
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public static Student unMarshall(String path) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Student.class);
        return (Student) context.createUnmarshaller()
                .unmarshal(new FileReader(path));
    }
}

