package LE4Q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class VivekExerciseOnFileMapSet {
    //creates header, requires assignment number
    public static void header(int labNumber) {
        System.out.printf("Lab Exercise %d", labNumber);
        System.out.printf("\nPrepared By: Vivek Jariwala");
        System.out.printf("\nStudent Number: 251213353");
        System.out.printf("\nGoal of this Exercise: Working with sorting through a file with a TreeMap");
    }

    //creates footer, requires assignment number
    public static void footer(int labNumber) {
        System.out.printf("Completion of Lab Exercise %d is successful", labNumber);
        System.out.printf("\nSigning off - Vivek");

    }
    public static void printList(TreeMap treeMap){
        Set<Map.Entry<String, Integer>> mapEntrySet = treeMap.entrySet();

        for(Map.Entry<String, Integer> pair: mapEntrySet){
            if (pair.getValue()>1){
                System.out.printf("%14s %4d\n",pair.getKey(),pair.getValue());
            }
        }
    }
    public static void populateTreeMap(int arrayIndex, String [] array, TreeMap<String, Integer> treeMap){
        String key = array[arrayIndex];
        if(treeMap.get(key) == null){
            treeMap.put(key,1);
        }
        else {
            int keyValue = treeMap.get(key);
            keyValue++;
            treeMap.put(key, keyValue);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("==============================================================================================================");
        header(4);
        System.out.println("\n==============================================================================================================");

        TreeMap<String, Integer> lastNameTreeMap = new TreeMap<>();
        TreeMap<String, Integer> firstNameTreeMap = new TreeMap<>();

        File studentsFile = new File("SE2205Students.txt");
        Scanner scanner = new Scanner(studentsFile);
        while(scanner.hasNext()){
            String fullName = scanner.nextLine();
            String[] splitString = fullName.split(" ");
            String lastName = splitString[0];
            String firstName = splitString[1];
            populateTreeMap(0, splitString, lastNameTreeMap);
            populateTreeMap(splitString.length-1, splitString, firstNameTreeMap);
        }

        scanner.close();

        System.out.println("List of the Number of students With The Same Last Names:");
        System.out.println("\tLast-name \tnumbers");
        System.out.println("   ---------------------");
        printList(lastNameTreeMap);

        System.out.println("\nList of the Number of students With The Same First Names:");
        System.out.println("\tFirst-name \tnumbers");
        System.out.println("   ---------------------");
        printList(firstNameTreeMap);

        System.out.println("\n==============================================================================================================");
        footer(4);
        System.out.println("\n==============================================================================================================");

    }
}
