package LA3Q2;
import LA3Q1.*;

import java.util.Arrays;

import static LA3Q1.VivekDemoHashingWithLinearProbing.*;

public class VivekDemoHashingWithAllOpenAddressingTechniques {

    //Function to add into the hashTable using Quadratic Probing
    public static void addValueQuadraticProbe (Integer value){
        //Creating the variables
        int n = 1;
        int k = value % tableCapacity;
        int index = k;
        //Making sure that the index value is greater than 0
        if (index < 0)
        {
            index = index % tableCapacity;
            index += tableCapacity;
        }

        //While there is no index with value "null" or "available" then keep incrementing the n
        while(hashTable[index].getKey() != -1 && hashTable[index].getKey() != -111)
        {
            //Recalculating index and then incrementing n
            index = k + (int)(Math.pow(n, 2));
            n++;

            //Making sure that the index is smaller than the capacity
            if (index >= tableCapacity)
            {
                index = index % tableCapacity;
            }

            //If the n value becomes larger than the table break out of the loop
            if (n > tableCapacity)
            {
                System.out.println("\n\nProbing failed! Use a load factor of 0.5 or less. Goodbye!");
                break;
            }
        }

        //If a "null" or "available" index is found then insert the key there
        if(hashTable[index].getKey() == -1 || hashTable[index].getKey() == -111)
        {
            hashTable[index].setKey(value);
        }
    }

    //Function to find the second prime number
    public static int ThePrimeNumberForSecondHashFunction(int size){
        //For loop to find the prime number that is less than the size
        for (int i = size - 1; i >= 1; i--) {

            // Initially count is zero
            int cnt = 0;

            //For loop to start at 2 and go till j squared reaches the size
            for (int j = 2; j * j <= i; j++)
                if (i % j == 0)
                    cnt++;
            //returns the new prime number
            if (cnt == 0)
                return i;
        }
        return size;
    }

    //Function to add value using DoubleHashing
    public static void addValueDoubleHashing(Integer value){
        //Creating the variables
        int h1, q, h2, index, k;
        int j = 0;

        //Getting the largest prime number smaller than the size of the table
        q = ThePrimeNumberForSecondHashFunction(tableCapacity);

        //Getting h1, h2, index, and k. K also gets checked for it to be greater than zero
        h1 = value % tableCapacity;
        k = (value % q);
        if (k < 0)
        {
            k += tableCapacity;
        }
        h2 = q - k;
        index = h1 + (j * h2);

        //If index is smaller than 0 then add the length of table
        if (index < 0)
        {
            index += tableCapacity;
        }

        //While there is no index with value "null" or "available" then keep incrementing the j
        while(hashTable[index].getKey() != -1 && hashTable[index].getKey() != -111)
        {
            //Incrementing j and recalculating index
            j++;
            index = h1 + (j * h2);

            //Making sure index is smaller than the length of the table and is greater than 0
            if(index >= tableCapacity)
            {
                index = index % tableCapacity;
            }
            if (index < 0)
            {
                index = index % tableCapacity;
                index += tableCapacity;
            }
        }

        //If a "null" or "available" index is found then insert the key there
        if(hashTable[index].getKey() == -1 || hashTable[index].getKey() == -111)
        {
            hashTable[index].setKey(value);
        }
    }

    //Clearing the hashtable
    public static void emptyHashTable(){
        for(int i = 0; i < tableCapacity; i++){
            //reInitializing the hashtable to set it -1 again
            hashTable[i] = new VivekValueEntry();
        }
    }

    //Prints the array
    public static void printArray(Integer[] array){
        System.out.println(Arrays.toString(array));
    }

    public static void main(String []args){

        Header(3,2);

        System.out.println("Let's Demonstrate our Understanding on all the Open Addressing Techniques... \n");
        //Asking the user the number of data items
        System.out.print("How Many Data Items: ");
        items = input.nextInt();

        //Asking the user for the load factor
        System.out.print("What is the Load Factor (Recommended: <= 0.5): ");
        lf = input.nextDouble();

        //Finding the tableCapacity using the checkPrime function
        tableCapacity = checkPrime((int)(Math.round(items)/lf));

        //Creating the hashtable with the bew table capacity
        System.out.println("The minimum required table capacity would be: " + tableCapacity + "\n");
        hashTable = new VivekValueEntry[tableCapacity];

        //Initializing the hashtable to set it -1
        for(int i = 0; i < tableCapacity; i++){
            hashTable[i] = new VivekValueEntry();
        }

        //Integer array with the numbers
//        Integer[] numbers = {7, 14, -21, -28, 35};
        Integer[] numbers = {-11, 22, -33, -44, 55};

        //Printing the normal array
        System.out.print("The Given Data Set: ");
        printArray(numbers);

        System.out.println("\nLet's Enter Each Data Item From The Above To The Hash Table:");

        //Adding each value from the numbers array into the hashmap
        for(int i = 0; i < numbers.length; i++){
            addValueLinearProbe(numbers[i]);
        }
        //Printing the hashtable after using linear probing
        System.out.println("\nAdding Data - Linear Probing Resolves Collision:");
        System.out.print("The Current Hash Table: ");
        printHashTable();

        //Emptying the hashtable
        emptyHashTable();
        //Adding each value from the numbers array into the hashmap using the Quartic probing
        for(int i = 0; i < numbers.length; i++){
            addValueQuadraticProbe(numbers[i]);
        }
        System.out.println("\n\nAdding Data - Quadratic Probing Resolves Collision:");

        System.out.print("The Current Hash Table: ");
        printHashTable();

        //Emptying the hashtable
        emptyHashTable();
        //Adding each value from the numbers array into the hashmap using the Double Hashing
        for(int i = 0; i < numbers.length; i++){
            addValueDoubleHashing(numbers[i]);
        }
        //Printing the new q value and the hash table
        System.out.println("\n\nAdding Data - Double-Hashing Resolves Collision:");
        System.out.println("The q Value for Double Hashing is: " + ThePrimeNumberForSecondHashFunction(tableCapacity));
        System.out.print("The Current Hash Table: ");
        printHashTable();

        Footer(3,2);
    }
}