package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.example.classes.Student;
import org.example.classes.StudentList;

import java.io.File;
import java.util.ArrayList;

public class FromListToXml {
    /**
     * convert java object to xml
     * @param args
     * @throws JAXBException
     */
    public static void main(String[] args) throws JAXBException {
        StudentList studentList=new StudentList();
        ArrayList<Student> studentArrayList=new ArrayList<>(FromXmlToList.xmlToObjectList("src/main/resources/students.xml"));
       studentList.setStudentList(studentArrayList);
        JAXBContext context = JAXBContext.newInstance(StudentList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(studentList, new File("StudentList.xml"));

    }
}
