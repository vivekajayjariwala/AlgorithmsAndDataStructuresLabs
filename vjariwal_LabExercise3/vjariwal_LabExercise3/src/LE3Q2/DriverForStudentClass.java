package LE3Q2;

import LE3Q1.MyStudent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DriverForStudentClass {
    //creates header, requires assignment number
    public static void header(Student myInfo, int labE_number, int q_number) {
        System.out.printf("Lab Assignment %d-Q%d", labE_number, q_number);
        System.out.printf("\nPrepared By: %s %s", myInfo.getFirstName(), myInfo.getLastName());
        System.out.printf("\nStudent Number: 251213353");
        System.out.printf("\nGoal of this Exercise: Working with sorting ArrayLists using Collections");
    }

    //creates footer, requires assignment number
    public static void footer(int labE_number, int q_number) {
        System.out.printf("Completion of Lab %d-Q%d is successful", labE_number, q_number);
        System.out.printf("\nSigning off - Vivek");

    }

    public static void main(String[] args) {
        System.out.println("==============================================================================================================");
        Student vivek = new Student();
        header(vivek, 3,2);
        System.out.println("\n=====================3=========================================================================================");
        ArrayList<Student> students = new ArrayList<>();
        Student s0 = new Student();
        Student s1 = new Student("Harry", "Potter", 75.5);
        Student s2 = new Student("Ronald", "Weasley", 86.0);
        Student s3 = new Student("Hermione", "Granger", 91.7);
        Student s4 = new Student("Parvati", "Patil", 93.75);

        students.add(s0);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        for (int i =0; i<students.size(); i++){
            System.out.println(students.get(i));
        }

        // sort in descending order
        Collections.sort(students);
        System.out.println("\nThe sorted list in terms of score in descending order....");
        for (int i =0; i<students.size(); i++){
            System.out.println(students.get(i));
        }

        // sort in terms of last names
        HelperClassCompareLastNames lastName = new HelperClassCompareLastNames();
        Collections.sort(students, lastName);
        System.out.println("\nThe sorted list in terms of Last Names....");
        for (int i =0; i<students.size(); i++){
            System.out.println(students.get(i));
        }

        // sort in terms of first names
        HelperClassCompareFirstNames firstName = new HelperClassCompareFirstNames();
        Collections.sort(students, firstName);
        System.out.println("\nThe sorted list in terms of First Names....");
        for (int i =0; i<students.size(); i++){
            System.out.println(students.get(i));
        }

        // displays and formats the footer
        System.out.println("\n==============================================================================================================");
        footer(3,2); // calls the footer method
        System.out.println("\n==============================================================================================================");
    }
}
