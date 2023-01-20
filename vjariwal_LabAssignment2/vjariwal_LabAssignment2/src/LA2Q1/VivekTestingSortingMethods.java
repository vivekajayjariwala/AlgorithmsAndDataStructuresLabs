package LA2Q1;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class  VivekTestingSortingMethods {
    //creates header, requires assignment number and question number

    public static void header(int assignmentNumber, int questionNumber) {
        // prints the lab assignment number and question number
        System.out.printf("Lab Assignment %d, Q%d", assignmentNumber, questionNumber);
        // prints out that the lab assigned was prepared by me
        System.out.printf("\nPrepared By: Vivek Jariwala");
        // prints out my student number
        System.out.printf("\nStudent Number: 251213353");
        // prints out the goal of the exercise
        System.out.printf("\nGoal of this Exercise: Working with different sorting methods!");
    }

    //creates footer, requires assignment number and question number
    public static void footer(int assignmentNumber, int questionNumber) {
        // prints out the completion of the lab assignment statement
        System.out.printf("Completion of Lab Assignment %d, Q%d is successful",  assignmentNumber, questionNumber);
        // prints signing off message
        System.out.printf("\nSigning off - Vivek");

    }

    public static <T extends Comparable <? super T>>long selectionSort (T [] a){
        long startTime = System.nanoTime(); // finds the current time at the beginning of the sorting method
        int size = a.length; // saves the size of the array

        // moves through the unsorted array
        for (int i = 0; i < size-1; i++) {
            int nextSmallest = i; // saves the current value of the index
            // finds minimum element in array
            for (int j = i+1; j < size; j++){
                // compares the array at the next index to the one before it, and checks if it is smaller than it
                if ((a[j].compareTo(a[nextSmallest])<0)){
                    // if the index before the current index is larger, set the value of nextSmallest to current index
                    nextSmallest = j;
                }
            }

            // Swapping the smallest element with the first element

            T temp = a[nextSmallest]; // stores the smallest element in a temporary variable called temp
            a[nextSmallest] = a[i]; // swaps the value of the nextSmallest index element with current index element
            a[i] = temp; // current index element becomes the value of the temporary value
        }
        long endTime = System.nanoTime(); // finds the current time at the end of the sorting method
        return endTime - startTime; // finds difference between the two times to give the elapsed time of sorting method
    }

    public static <T extends Comparable <? super T>>long bubbleSort (T [] a){
        long startTime = System.nanoTime(); // finds the current time at the beginning of the sorting method
        for (int i = 0; i < a.length - 1; i++)
            for (int j = 0; j < a.length - i - 1; j++) {
                // compares the adjacent pairs of elements in each pass, and checks if the second element is smaller
                if ((a[j].compareTo(a[j + 1])) > 0) {
                    // swaps the values of the second element in the pair with the first one at the current index
                    T temp = a[j]; // stores the value of the current value in a temporary variable
                    a[j] = a[j + 1]; // makes the current value equal the one after it, which is smaller
                    a[j + 1] = temp; // makes the one after the current value equal to the larger of the pair
                }
            }
        long endTime = System.nanoTime(); // finds the current time at the end of the sorting method
        return endTime - startTime; // finds difference between the two times to give the elapsed time of sorting method
    }

    public static <T extends Comparable <? super T>>long insertionSort (T [] a){
        long startTime = System.nanoTime(); // finds the current time at the beginning of the sorting method
        for (int i = 1; i < a.length; i++) {
            T key = a[i]; // creates a key variable that is equal to the current value of outer index
            int j = i - 1; // creates a variable for inner index that is equal to one less than the outer index variable
            // while loop runs if inner index is greater or equal to 0 and the array at that value is greater than key
            while (j >= 0 && (a[j].compareTo(key)>0)) {
                // swaps the value of the array at the next index with the array at current index
                a[j + 1] = a[j];
                //
                j--; // decreases value of j by one
            }
            a[j + 1] = key; // the value of the array at the next value of the inner index is equal to the key
        }
        long endTime = System.nanoTime(); // finds the current time at the end of the sorting method
        return endTime - startTime; // finds difference between the two times to give the elapsed time of sorting method
    }

    public static <T extends Comparable<? super T>> long mergeSort(T[] S){
        long startTime = System.nanoTime(); // finds the current time at the beginning of the sorting method
        int size = S.length; //stores size of the array
        // if the array size is less than 2, in other words, 1 or 0, than return the time and end sorting method
        if (size<2){
            long endTime = System.nanoTime(); // finds the current time at the end of the sorting method
            // finds difference between the two times to give the elapsed time of sorting method
            return endTime - startTime;
        }
        int mid = size/2; // calculates the middle index of the array
        T[] S1 = Arrays.copyOfRange(S, 0, mid); // creates array S1 that copies range from S from 0 to mid
        T[] S2 = Arrays.copyOfRange(S, mid, size); // creates array S2 that copies range from S from mid to end of it

        mergeSort(S1); // recursive call on S1
        mergeSort(S2); // recursive call on S2

        int i=0; // initializes i variable
        int j=0; // initializes j variable

        // while loop runs while the sum of i and j are less than size of S
        while (i+j<S.length){
            /* if j is equal ot length of second half of array and i is less than S1 array and S1 at the index of i
            is less than the S2 array at index of j
             */
            if (j==S2.length || (i<S1.length && S1[i].compareTo(S2[j])<0)){
                S[i+j] = S1[i++]; // copies the element of S1 at i index to S array at the index of the sum of i and j
            }
            else{
                S[i+j] = S2[j++]; // copies the element of S2 at j index to S array at the index of the sum of i and j
            }
        }

        long endTime = System.nanoTime(); // finds the current time at the end of the sorting method
        return endTime - startTime; // finds difference between the two times to give the elapsed time of sorting method

    }

    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b){
        long startTime = System.nanoTime(); // finds the current time at the beginning of the sorting method
        if (a >= b) {
            long endTime = System.nanoTime(); // finds the current time at the end of the sorting method
            // finds difference between the two times to give the elapsed time of sorting method
            return endTime - startTime;
        }
        int left=a; // variable left is equal to the first index, which is 0
        int right = b-1;  // variable right is equal to the last index minus 1
        T pivot = s[b]; // a pivot variable is equal to the value of given array at its last index
        T temp; // declares a temp variable

        //while loop runs while the right variable is greater than or equal to the left variable
        while(left<=right){
            /* while loop runs while the right variable is greater than or equal to the left variable and the value
            of s array at left index is less than value of pivot
             */
            while(left<=right && (s[left].compareTo(pivot))<0){
                left++; // increases left by one
            }
            /* while loop runs while the right variable is greater than or equal to the left variable and the value
            of s array at right index is greater than value of pivot
             */
            while(left<=right && (s[right].compareTo(pivot))>0){
                right--; // decreases right by one
            }
            // if the right variable is greater than or equal to the left variable execute following
            if(left<=right){
                temp = s[left]; // temp variable is equal to given array at left index
                s[left]=s[right]; // swaps value of given array at index right to given array at index left
                s[right]=temp; // makes given array at index right now equal to value of temp
                left++; // increase left by one
                right--; // decrease right by one
            }
        }

        temp = s[left]; // temp is now equal to given array at left index
        s[left]=s[b]; // swaps value of given array at last index to given array at index left
        s[b]=temp; // given array at last index is equal to temp

        quickSort(s, a, left-1); // recursive call to quick sort with given array, first index, and left index - 1
        quickSort(s,left+1,b); // recursive call to quick sort with given array, left index + 1, and last index

        long endTime = System.nanoTime(); // finds the current time at the end of the sorting method
        return endTime - startTime; // finds difference between the two times to give the elapsed time of sorting method
    }


    public static Integer findDigit(int digit, int limit){
        int value=0; //initializes variable value at zero
        for (int j=0; j<=limit; j++){
            value = digit % 10; // value is equal to remainder of the digit divided by 10
            digit = digit/10; // digit is equal to the quotient of its current value divided by 10
        }
        return value; // returns value variable
    }

    public static long bucketSort(Integer[] a, int first, int last, int maxDigits){
        long startTime = System.nanoTime(); // finds the current time at the beginning of the sorting method

        Vector<Integer>[] bucket = new Vector[10]; // creates 10 empty buckets with vector
        for (int i=0; i<10;i++){
            bucket[i] = new Vector<>(); // bucket at each index value is a vector
        }
        for (int i=0; i<maxDigits; i++){
            for (int j=0; j<10; j++){
                bucket[j].removeAllElements(); // clears the vector bucket at each index value
            }
            for (int k = first; k<= last; k++){
                // value is equal to the return of findDigit method using given array at current index and outer index
                Integer value = findDigit(a[k], i);
                bucket[value].add(a[k]); // places integer value at each index of bucket
            }
            int counter=0; // creates counter variable
            // inserts buckets into given array
            for (int l=0; l<10; l++){
                for (int m=0; m<bucket[l].size(); m++){
                    a[counter++] = bucket[l].get(m); // the given array at counter is equal to value at bucket at index
                }
            }
        }
        long endTime = System.nanoTime(); // finds the current time at the end of the sorting method
        return endTime - startTime; // finds difference between the two times to give the elapsed time of sorting method
    }

    public static void main(String[] args) {

        // prints the header
        System.out.println("==============================================================================================================");
        header(2,1);
        System.out.println("\n==============================================================================================================");

        int sz=5; // saves a preset size of 5 for the array
        // declares the primary Integer array to the size equivalent to the variable sz
        Integer[] primaryArray = new Integer[sz];
        // declares a backup Integer array to the size equivalent to the variable sz
        Integer[] backupArray = new Integer[sz];

        // as for loop runs, it stores random integer values to each index of the primary array
        for(int i=0; i<primaryArray.length; i++){
            Random rand = new Random(); // creates an object of type Random
            // Random object stores random integer value between 93-13 inclusive to current index of primary array
            primaryArray[i] = rand.nextInt((93-13)+1)+13;
        }

        // copies contents of primary array to the backup array
        System.arraycopy(primaryArray, 0, backupArray, 0, sz);

        // creates a list from the primary array
        List<Integer> list = Arrays.asList(primaryArray);

        // prints message saying that the 5 different sorting methods will be tested
        System.out.println("Testing execution time of different sorting methods for sorting "+ sz +" random numbers:");


        if(sz<=5){
            // Prints the unsorted contents of the list
            System.out.println("The unsorted list: " + list);
        }


        double startTime = System.nanoTime(); // start time of Collection sort
        Collections.sort(list); // collections sorts the list in descending order
        double endTime = System.nanoTime(); // end time of Collection sort
        // calculates elapsed time for collections sort and converts it to milliseconds
        double collectionsTime = ((endTime-startTime)/(Math.pow(10,6)));

        // prints time collections sort took to sort the list to two decimal places
        System.out.printf("Collections' Sorting Time: %.2f milliseconds", collectionsTime);
        if(sz<=5){
            // prints the sorted list using Collections sort
            System.out.println("\nThe sorted list using Collections' sort method: " + list);
        }


        // copies the contents of the backup array to the primary array to make it unsorted again for the other methods
        System.arraycopy(backupArray, 0, primaryArray, 0, sz);

        if(sz<=5){
            // Prints the unsorted contents of the list
            System.out.print("\nThe unsorted list: " + list);
        }

        // calls the selection sort method to sort the primary array and then converts it elapsed time to milliseconds
        double selectionSortTime = selectionSort(primaryArray)/(Math.pow(10,6));
        // prints time selection sort took to sort the list to two decimal places
        System.out.printf("\nMy Selection-Sort Time: %.2f milliseconds", selectionSortTime);
        // converts the primary array that was just sorted to a list so we can use the toString method for it
        List<Integer> selectionSortList = Arrays.asList(primaryArray);
        if(sz<=5){
            // prints the sorted list using selection sort
            System.out.println("\nThe sorted list using selection-sort: " + selectionSortList);
        }

        // copies the contents of the backup array to the primary array to make it unsorted again for the other methods
        System.arraycopy(backupArray, 0, primaryArray, 0, sz);

        if(sz<=5){
            // Prints the unsorted contents of the list
            System.out.print("\nThe unsorted list: " + list);
        }
        // calls the bubble sort method to sort the primary array and then converts it elapsed time to milliseconds
        double bubbleSortTime = bubbleSort(primaryArray)/(Math.pow(10,6));
        // prints time selection sort took to sort the list to two decimal places
        System.out.printf("\nMy Bubble-Sort Time: %.2f milliseconds", bubbleSortTime);
        // converts the primary array that was just sorted to a list so we can use the toString method for it
        List<Integer> bubbleSortList = Arrays.asList(primaryArray);
        if(sz<=5){
            // prints the sorted list using bubble sort
            System.out.println("\nThe sorted list using Bubble-sort: " + bubbleSortList);
        }


        // copies the contents of the backup array to the primary array to make it unsorted again for the other methods
        System.arraycopy(backupArray, 0, primaryArray, 0, sz);

        if(sz<=5){
            // Prints the unsorted contents of the list
            System.out.print("\nThe unsorted list: " + list);
        }
        // calls the insertion sort method to sort the primary array and then converts it elapsed time to milliseconds
        double insertionSortTime = insertionSort(primaryArray)/(Math.pow(10,6));
        // prints time selection sort took to sort the list to two decimal places
        System.out.printf("\nMy Insertion-Sort Time: %.2f milliseconds", insertionSortTime);
        // converts the primary array that was just sorted to a list so we can use the toString method for it
        List<Integer> insertionSortList = Arrays.asList(primaryArray);
        if(sz<=5){
            // prints the sorted list using insertion sort
            System.out.println("\nThe sorted list using Insertion-sort: " + insertionSortList);
        }


        // copies the contents of the backup array to the primary array to make it unsorted again for the other methods
        System.arraycopy(backupArray, 0, primaryArray, 0, sz);

        if(sz<=5){
            // Prints the unsorted contents of the list
            System.out.print("\nThe unsorted list: " + list);
        }
        // calls the merge sort method to sort the primary array and then converts it elapsed time to milliseconds
        double mergeSortTime = mergeSort(primaryArray)/(Math.pow(10,6));
        // prints time selection sort took to sort the list to two decimal places
        System.out.printf("\nMy Merge-Sort Time: %.2f milliseconds", mergeSortTime);
        // converts the primary array that was just sorted to a list so we can use the toString method for it
        List<Integer> mergeSortList = Arrays.asList(primaryArray);
        if(sz<=5){
            // prints the sorted list using merge sort
            System.out.println("\nThe sorted list using Merge-sort: " + mergeSortList);
        }


        // copies the contents of the backup array to the primary array to make it unsorted again for the other methods
        System.arraycopy(backupArray, 0, primaryArray, 0, sz);

        if(sz<=5){
            // Prints the unsorted contents of the list
            System.out.print("\nThe unsorted list: " + list);
        }
        // calls the quick sort method to sort the primary array and then converts it elapsed time to milliseconds
        double quickSortTime = quickSort(primaryArray, 0, primaryArray.length-1)/(Math.pow(10,6));
        // prints time selection sort took to sort the list to two decimal places
        System.out.printf("\nMy Quick-Sort Time: %.2f milliseconds", quickSortTime);
       List<Integer> quickSortList = Arrays.asList(primaryArray);
        if(sz<=5){
            // prints the sorted list using quick sort
            System.out.println("\nThe sorted list using Quick-sort: " + quickSortList);
        }

        // copies the contents of the backup array to the primary array to make it unsorted again for the other methods
        System.arraycopy(backupArray, 0, primaryArray, 0, sz);

        // Prints the unsorted contents of the list
        if(sz<=5) {
            System.out.print("\nThe unsorted list: " + list);
        }
        // calls the bucket sort method to sort the primary array and then converts it elapsed time to milliseconds
        double bucketSortTime = bucketSort(primaryArray, 0, primaryArray.length-1, 2)/(Math.pow(10,6));
        // prints time bucket sort took to sort the list to two decimal places
        System.out.printf("\nMy Bucket-Sort Time: %.2f milliseconds", bucketSortTime);
        // converts the primary array that was just sorted to a list so we can use the toString method for it

        List<Integer> bucketSortList = Arrays.asList(primaryArray);
        // converts the primary array that was just sorted to a list so we can use the toString method for it
        // prints the sorted list using bucket sort
        if(sz<=5){
            System.out.println("\nThe sorted list using Bucket-sort: " + bucketSortList);
        }


        // prints the footer
        System.out.println("\n==============================================================================================================");
        footer(2,1);
        System.out.println("\n==============================================================================================================");

    }

}




