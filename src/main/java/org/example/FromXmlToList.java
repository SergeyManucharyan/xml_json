package org.example;

import org.example.classes.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

public class FromXmlToList {
    /**
     * Convert xml to list of java object
     * @param path
     * @return
     */
    public static  ArrayList<Student> xmlToObjectList(String path){
        ArrayList<Student> studentList = new ArrayList<>();

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document doc = (Document) documentBuilder.parse(path);
            NodeList list = doc.getElementsByTagName("student");

            for (int i = 0; i < list.getLength(); i++) {

                Node n = list.item(i);
                Student student = new Student();
                Element e = (Element) n;
                student.setFirstName(e.getElementsByTagName("firstname").item(0).getTextContent());
                student.setLastName(e.getElementsByTagName("lastname").item(0).getTextContent());
                student.setNickName(e.getElementsByTagName("nickname").item(0).getTextContent());
                int marks = Integer.parseInt(e.getElementsByTagName("marks").item(0).getTextContent());
                student.setMarks(marks);
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
