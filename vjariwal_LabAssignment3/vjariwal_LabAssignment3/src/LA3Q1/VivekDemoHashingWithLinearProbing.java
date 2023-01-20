package LA3Q1;

import java.util.Arrays;
import java.util.Scanner;

public class VivekDemoHashingWithLinearProbing {

    //Initializing the variables
    public static int items,tableCapacity;
    public static double lf;

    //Creating the scanner input
    public static Scanner input = new Scanner(System.in);

    //Initializing the hashtables of VivekValueEntry type
    public static VivekValueEntry[] hashTable;
    public static VivekValueEntry[] workingHashTable;

    //Function to add the values using linear probing
    public static void addValueLinearProbe(Integer value){
        //Finding the index value
        int index = value % tableCapacity;

        //Checks if the index is negative and converts to its positive side
        if (index < 0){
            index += tableCapacity;
        }

        //Creates while loop to add onto the index if a value is already taken that spot
        while(hashTable[index].getKey() != -1 && hashTable[index].getKey() != -111){
            index++;
            if (index == tableCapacity){
                index = 0;
            }

        }
        //Sets the value to the index value
        if (hashTable[index].getKey() == -1 || hashTable[index].getKey() == -111){
            hashTable[index].setKey(value);
        }
    }

    //since in hashing, the prime number has to be greater than 2, we can discard 2; 0 and 1 are not prime numbers by definition
    public static int checkPrime(int n) {
        //we just need to check half of the n factors
        int m = n / 2;

        for (int i = 3; i <= m; i++) {
            //if n is not a prime number
            if (n % i == 0) {
                //reset i to 2 so that it is incremented to 3 in the for header
                i = 2;

                //System.out.printf("i = %d\n",i);
                n++;//next n value
                m = n / 2;//we just need to check half of the n factors
            }
        }
        return n;
    }

    //Function to remove the value
    public static void removeValueLinearProbe(Integer value){

        boolean isFound = false;

        //A for loop to scan through the hash table to look for the value and assigns it -111
        for(int i = 0; i < hashTable.length; i++) {
            if (hashTable[i].getKey() == value) {
                hashTable[i].setKey(-111);
                //Sets isFound to true
                isFound = true;
            }
        }

        //Checks if isFound is true or not to change the output
        if(isFound){
            System.out.println(value + " is Found and removed!");
        }
        else{
            System.out.println(value + " is not Found!");
        }

    }

    //Printing the hashTable
    public static void printHashTable(){
        String output = "[";

        //For loop to add onto the output
        for(int i = 0; i < hashTable.length; i++){

            if(hashTable[i].getKey() == -1){
                output += "null, ";

            } else if(hashTable[i].getKey() == -111){
                output += "available, ";
            }
            else{
                output += (hashTable[i].getKey() + ", ");
            }
        }
        System.out.print(output + "\b\b]");
    }

    public static void rehashingWithLinearProbe(){

        //Initializing the working hashtable from the size of the table capacity
        workingHashTable = new VivekValueEntry[tableCapacity];

        //For loop to set the working hashtable with -1 values
        for(int i = 0; i < tableCapacity; i++){
            workingHashTable[i] = new VivekValueEntry();
        }

        //Sets the working hashtable with the values from the hashtable
        for(int i = 0; i < tableCapacity; i++){
            workingHashTable[i].setKey(hashTable[i].getKey());
        }

        //Using teh checkPrime function to create the new tableCapacity and prints it
        tableCapacity = checkPrime((tableCapacity*2));
        System.out.println("The Rehashed Table Capacity is: " + tableCapacity);

        //Creating the new hashTable with the new table Capacity
        hashTable = new VivekValueEntry[tableCapacity];

        //For loop to assign the hashtable with -1's
        for(int i = 0; i < tableCapacity; i++){
            hashTable[i] = new VivekValueEntry();
        }

        //Adds the value to the new hashTable from the workingHash table using the addValueLinearProbe function
        for(int i = 0; i < workingHashTable.length; i++){
            if(workingHashTable[i].getKey() != -111){
                addValueLinearProbe(workingHashTable[i].getKey());
            }
        }
    }

    //The header method
    public static void Header(int a,int b) {
        System.out.println("====================================================================================");
        System.out.println("Lab Assignment: " + a + "Q" + b + "\nPrepared By: Vivek Jariwala " +
                "\nStudent Number: 251213353 \nGoal of Assignment: Sorting Array of Numbers Using Different Sorting Methods ");
        System.out.println("====================================================================================");
    }

    //The Footer Method
    public static void Footer(int a,int b) {
        System.out.println("\n====================================================================================");
        System.out.println("Completion of Lab Assignment " + a + " Q" + b + " is successful." +
                "\nSigning off - Vivek Jariwala");
        System.out.println("====================================================================================");
    }

    public static void main(String []args){
        //Calling the header
        Header(3,1);

        //Asking the user for the size of the dataSet
        System.out.println("Let's Decide on The Initial Table Capacity Based on the Load Factor and Dataset Size \n");
        System.out.print("How Many Data Items: ");
        items = input.nextInt();

        //Asking the user for the load factor
        System.out.print("What is the Load Factor (Recommended: <= 0.5): ");
        lf = input.nextDouble();

        //Using the checkPrime function to find the tableCapacity
        tableCapacity = checkPrime((int)(Math.round(items)/lf));

        //Initializing the hashTable from the table capacity
        System.out.println("The minimum required table capacity would be: " + tableCapacity + "\n");
        hashTable = new VivekValueEntry[tableCapacity];

        //Setting the hashtable with the values of -1
        for(int i = 0; i < tableCapacity; i++){
            hashTable[i] = new VivekValueEntry();
        }

        //For loop to ask the user for the values and adding it to the hashtable using the addValueLinearProbe function
        for(int i = 0; i < items; i++){
            System.out.print("Enter Item " + (i+1) + ": ");
            int value = input.nextInt();
            addValueLinearProbe(value);
        }

        //Printing the current hashTable
        System.out.print("The Current Hash Table:" );
        printHashTable();


        System.out.println("\n\nLet’s Remove Two Values from the Table & Then Add One......." );

        //Asking the user the value they want to remove and using the function removeValueLinearProbe to remove the number
        System.out.print("\nEnter a value you want to remove: ");
        int num1 = input.nextInt();
        removeValueLinearProbe(num1);
        System.out.print("The Current Hash Table: ");
        printHashTable();

        //Asking the user again for the value they want to remove again and using the function removeValueLinearProbe to remove the number
        System.out.print("\n\nEnter a value you want to remove: ");
        int num2 = input.nextInt();
        removeValueLinearProbe(num2);
        System.out.print("The Current Hash Table: ");
        printHashTable();

        //Asking the user the value they want to add to the hashtable and using the addValueLinearProbe function
        System.out.print("\n\nEnter a Value You Want to Add to the Table: ");
        int num3 = input.nextInt();
        addValueLinearProbe(num3);
        System.out.print("The Current Hash Table: ");
        printHashTable();

        //Rehashing the table by calling the rehashingWithLinearProbe function
        System.out.println("\n\nRehashing the Table...");
        rehashingWithLinearProbe();

        //Printing the hashtable after it has been rehashed
        System.out.print("The Current Hash Table: ");
        printHashTable();

        Footer(3,1);
    }
}