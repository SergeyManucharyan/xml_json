package org.example.classes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Student {



    private String firstName;
    private String lastName;
    private String nickName;

    private transient int marks;

    public Student() {
    }

    public Student(String firstName, String lastName, String nickName, int marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.marks = marks;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        if (marks > 0) {
            this.marks = marks;
        }else throw  new RuntimeException();
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", nickName = '" + nickName + '\'' +
                ", marks = " + marks +
                '}';
    }
}