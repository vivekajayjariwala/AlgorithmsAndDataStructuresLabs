package LA2Q2;

import java.util.Collections;
import java.util.Vector;

public class Vivek_SortNameAndGrade {
    //creates header, requires assignment number and question number

    public static void header(int assignmentNumber, int questionNumber) {
        // prints the lab assignment number and question number
        System.out.printf("Lab Assignment %d, Q%d", assignmentNumber, questionNumber);
        // prints out that the lab assigned was prepared by me
        System.out.printf("\nPrepared By: Vivek Jariwala");
        // prints out my student number
        System.out.printf("\nStudent Number: 251213353");
        // prints out the goal of the exercise
        System.out.printf("\nGoal of this Exercise: Working with the Vector class and insertion sort!");
    }

    //creates footer, requires assignment number and question number
    public static void footer(int assignmentNumber, int questionNumber) {
        // prints out the completion of the lab assignment statement
        System.out.printf("Completion of Lab Assignment %d, Q%d is successful",  assignmentNumber, questionNumber);
        // prints signing off message
        System.out.printf("\nSigning off - Vivek");

    }

    public static <T extends Comparable <? super T>> void insertionSort (StudentGrade [] a, int key){
        // if the key given is 1, then the given StudentGrade array is sorted based on first names
        if (key==1){
            for (int i = 1; i < a.length; ++i) {
                /* creates a value key variable of type StudentGrade that is equal to the current value of the
                StudentGrade array at the outer index
                 */
                StudentGrade valueKey = a[i];
                // creates a variable for inner index that is equal to one less than the outer index variable
                int j = i - 1;
                /* while loop runs if inner index is greater or equal to 0 and the array at that value's first name
                is greater than the value key's first name based on the compare to function implemented
                 */
                while (j >= 0 && (a[j].getFirstName().compareTo(valueKey.getFirstName())>0)) {
                    // swaps the value of the array at the next index with the array at current index
                    a[j + 1] = a[j];
                    //
                    j--; // decreases value of j by one
                }
                // the value of the array at the next value of the inner index is equal to the value key
                a[j + 1] = valueKey;
            }
        }
        // if the key given is other than 1, then the given StudentGrade array is sorted based on last names
        else{
            for (int i = 1; i < a.length; ++i) {
                /* creates a value key variable of type StudentGrade that is equal to the current value of the
                StudentGrade array at the outer index
                 */
                StudentGrade valueKey = a[i];
                // creates a variable for inner index that is equal to one less than the outer index variable
                int j = i - 1;
                /* while loop runs if inner index is greater or equal to 0 and the array at that value's first name
                is greater than the value key's first name based on the compare to function implemented
                 */
                while (j >= 0 && (a[j].getLastName().compareTo(valueKey.getLastName())>0)) {
                    // swaps the value of the array at the next index with the array at current index
                    a[j + 1] = a[j];
                    //
                    j--; // decreases value of j by one
                }
                // the value of the array at the next value of the inner index is equal to the value key
                a[j + 1] = valueKey;
            }

        }

    }

    // print array method that formats the student grade array contents
    public static void printArray(StudentGrade [] array){
        for (int i= 0; i < array.length; i++){
            // prints each Student Grade object by separating names with a semicolon
            System.out.printf("%12s %-2s \t:%4s \n", array[i].getFirstName(), array[i].getLastName(), array[i].getGrade());
        }
    }


    public static void main(String[] args) {
        // prints the header
        System.out.println("==============================================================================================================");
        header(2,2);
        System.out.println("\n==============================================================================================================");

        // creates first name array and initializes it with values
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        // creates last name array and initializes it with values
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        // creates grades array and initializes it with values between 60 and 85 inclusive
        Integer[] grd = {(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26),(int)(60 + Math.random()*26),(int)(60 +
                Math.random()*26)};

        //create a Vector<> class instance ‘sg’ with StudentGrade tag
        Vector<StudentGrade> sg = new Vector<>();

        for(int i=0; i<fnArray.length;i++){
            // creates student grade objects using previously initialized arrays
            StudentGrade student = new StudentGrade(fnArray[i],lnArray[i],grd[i]);
            //Add each StudentGrade object to the Vector class with its add method
            sg.add(student);
        }

        // prints message for the unsorted array contents
        System.out.println("The Unsorted Array................");
        for (int i = 0; i < sg.size(); i++){
            //print the unsorted ‘sg’ contents by using toString() method
            System.out.println(sg.get(i));
        }

        // prints message for the sorted array contents by grades
        System.out.println("\nSorted by Grades................");
        // sort ‘sg’ using Collections’ sort method, which will sort the list based on the grade
        Collections.sort(sg);
        for (int i = 0; i < sg.size(); i++){
            //prints the sorted content by using toString() method
            System.out.println(sg.get(i));
        }

        // creates an array of StudentGrade type with the length of the fnArray
        StudentGrade [] studentArray = new StudentGrade[fnArray.length];

        // copy ‘sg’ to StudentGrade array
        sg.copyInto(studentArray);

        // prints message for the sorted array contents by first name
        System.out.println("\nSorted by First Names.............");
        // sort the array using insertion sort method and by first name using key of 1
        insertionSort(studentArray, 1);
        //print the sorted array with printArray() method
        printArray(studentArray);

        // prints message for the sorted array contents by last name
        System.out.println("\nSorted by Last Names.............");
        // sort the array using insertion sort method and by last name using key of 2
        insertionSort(studentArray, 2);
        //print the sorted array with printArray() method
        printArray(studentArray);

        // prints the footer
        System.out.println("\n==============================================================================================================");
        footer(2,2);
        System.out.println("\n==============================================================================================================");


    }
}
