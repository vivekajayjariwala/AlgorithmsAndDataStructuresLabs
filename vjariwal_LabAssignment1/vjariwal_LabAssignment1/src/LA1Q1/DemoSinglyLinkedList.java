package LA1Q1;

import java.sql.SQLOutput;
import java.util.ArrayList; // import the Java ArrayList package
import java.util.Arrays; // import the Java array package
import java.util.InputMismatchException; // import the Java Input MisMatch Exception package
import java.util.Scanner; // import the Java Scanner package

public class DemoSinglyLinkedList {
    // creates a Scanner called input that allows the program to receive input from the user
    static Scanner input = new Scanner(System.in);

    // creates empty constructor
    public DemoSinglyLinkedList(){

    }

    //creates header, requires assignment number
    public static void header(int assignmentNumber) {
        System.out.printf("Lab Assignment %d-Q1", assignmentNumber);
        System.out.printf("\nPrepared By: Vivek Jariwala");
        System.out.printf("\nStudent Number: 251213353");
        System.out.printf("\nGoal of this Exercise: Working with linked lists to implement stacks and queues");
    }

    //creates footer, requires assignment number
    public static void footer(int assignmentNumber) {
        System.out.printf("Completion of Lab Assignment %d-Q1 is successful", assignmentNumber);
        System.out.printf("\nSigning off - Vivek");

    }

    public static void stackDemo(SinglyLinkedList linkedList){
        // asks user which end of the linked list they want to start with for the stack demo
        System.out.println("Which end of the Linked List you would like to use as the stack top?");
        // tells the user what each input value represents in relation to the previous quizzes
        System.out.print("\nEnter 1 for head or 2 for tail: ");
        boolean validInput=false; // validInput variable determines if the user entered a valid input (1 or 2)
        int userInput=0; // userInput variable stores the value that the user entered

        // while loop will keep asking the user to enter a value that is valid (1 or 2) until they do
        while(validInput==false) {
            try {
                userInput = input.nextInt(); // stores the user input
                if (userInput == 1 || userInput == 2) {
                    validInput=true; // the input is valid if it is either 1 or 2 (breaks the while loop as well)
                }
                // any other input is invalid
                else {
                    System.out.print("Invalid Input! Enter 1 or 2:"); // tells the user their input was invalid
                    userInput = input.nextInt(); // receives the next input of the user
                }
            } catch (InputMismatchException e) {
                /* if the user enters a value that is not an integer, the error that would typically result is caught
                and does not stop the program from running
                */
                System.out.print("Invalid Input! Enter 1 or 2:"); // tells the user their input was invalid
                input.next(); // receives the next input of the user and clears the buffer
            }
        }
        // if the user enters a 1, indicating they want to start with the stack from the top (head of linked list)
        if (userInput == 1){
            System.out.println("Stack Top: Head of the linked list\n"); // tells the user what option they picked
            while (!linkedList.isEmpty()){
                System.out.printf("%d has been popped! The revise stack is: %s\n", linkedList.popFromHead(), linkedList);}

            // keeps popping values from the linked list until it is empty (size equals 0)
//            while(linkedList.getSize()!=4){
//                // outputs a message saying what value has been popped and shows the revised stack
//                System.out.println((linkedList.popFromHead()).toString() + " has been popped! The Revised stack: " + linkedList.toString());;
//            }
            // tells user what values will be added to stack
            System.out.println("\nLet's push 39 and -58 in the stack...");
            System.out.println("The current stack: " + linkedList.toString()); // prints current stack

            linkedList.pushAtHead(39); // pushes 39 to the stack from the head
            // prints a message showing revised stack
            System.out.println("After 39 is pushed, the revised stack: " + linkedList.toString());

            linkedList.pushAtHead(-58); // pushes -58 to the stack from the head
            // prints a message showing revised stack
            System.out.println("After -58 is pushed, the revised stack: " + linkedList.toString());

        }

        // if the user enters a 2, indicating they want to start with the stack from the bottom (tail of linked list)

        if (userInput == 2){
            System.out.println("Stack Top: Tail of the linked list\n"); // tells the user what option they picked
            while(linkedList.getSize()!=2){
                // outputs a message saying what value has been popped and shows the revised stack
                System.out.println((linkedList.popFromTail()).toString() + " has been popped! The Revised stack: " + linkedList.toString());;
            }
            // tells user what values will be added to stack
            System.out.println("\nLet's push 39 and -58 in the stack...");
            System.out.println("The current stack: " + linkedList.toString()); // prints current stack

            linkedList.pushAtTail(39); // pushes 39 to the stack from the tail
            // prints a message showing revised stack
            System.out.println("After 39 is pushed, the revised stack: " + linkedList.toString());

            linkedList.pushAtTail(-58); // pushes -58 to the stack from the head
            // prints a message showing revised stack
            System.out.println("After -58 is pushed, the revised stack: " + linkedList.toString());
        }
    }

    public static void queueDemo(SinglyLinkedList linkedList){
        // prints message explaining how queues work in relation to heads
        System.out.println("Note: Head is the Q-front, and Tail is the Q-rear”");
        // tells user what names will be added to the queue
        System.out.println("\nLet's enqueue Joelle and Lukas in the queue in sequence...");
        // prints the current queue
        System.out.println("\nThe current Queue: " + linkedList.toString());
        // adds the name Joelle to the queue
        linkedList.enqueueAtTail("Joelle");
        // prints a message showing the revised queue
        System.out.println("\nAfter Joelle is enqueued, the revised Queue: " + linkedList.toString());

        // adds the name Lukas to the queue
        linkedList.enqueueAtTail("Lukas");
        // prints a message showing the revised queue
        System.out.println("After Lukas is enqueued, the revised Queue: " + linkedList.toString());


        // tells user that 3 elements will be dequeued
        System.out.println("\nLet's dequeue first three elements from the queue in sequence...");
        // prints the current queue
        System.out.println("The current Queue: " + linkedList.toString() + "\n");

        // while loop dequeues a certain amount of elements and then prints the revised queue each time
        while(linkedList.getSize()!=4){
            System.out.println((linkedList.dequeueAtHead()).toString() + " has been dequeued! The revised queue: " + linkedList.toString());;
        }

    }

    public static void main(String[] args) {

        // prints and formats the header
        System.out.println("==============================================================================================================");
        DemoSinglyLinkedList.header(1);
        System.out.println("\n==============================================================================================================");

        // creates arraylists to carry number values (integers) and one for name values (string)
        ArrayList<Integer> numberValues = new ArrayList(Arrays.asList(56, -22, 34, 57, 98));
        ArrayList <String> nameValues = new ArrayList(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));

        // prints messages showing both arrays and their contents
        System.out.print("The given Integer array: "+ numberValues);
        System.out.printf("\nThe given String array %s\n", nameValues);

        // creates a singly linked list object of type Integer for the number values
        SinglyLinkedList<Integer> numberLinkedList = new SinglyLinkedList<>();

        // the bottom two for loops adds number values from the array from the front and back of the linked list
        for(int i = 0; i<numberValues.size()-2; i++){
            numberLinkedList.addFirst(numberValues.get(i));
        }
        for(int i = numberValues.size()-1; i>2; i--){
            numberLinkedList.addLast(numberValues.get(i));
        }

        // creates a singly linked list object of type String for the name values
        SinglyLinkedList<String> stringLinkedList = new SinglyLinkedList<>();

        // the bottom two for loops adds name values from the array from the front and back of the linked list
        for(int i = 0; i<nameValues.size()-2; i++){
            stringLinkedList.addFirst(nameValues.get(i));
        }
        for(int i = nameValues.size()-1; i>2; i--){
            stringLinkedList.addLast(nameValues.get(i));
        }

        // prints the new number list using the numbers linked list
        System.out.println("Your Integer List: "+ numberLinkedList.toString());
        // prints the new names list using the names linked list
        System.out.println("Your String List: " + stringLinkedList.toString());

        // prints a message telling the user that the stack demo method will start using the number linked list
        System.out.println("\nStack demo with the Integer linked list ...");
        stackDemo(numberLinkedList); // calls the stack demo method with number linked list

        // prints a message telling the user that the queue demo method will start using the names linked list
        System.out.println("\nQueue demo with the String linked list ...");
        queueDemo(stringLinkedList); // calls the queue demo method with names linked list

        // prints a message telling the user that the stack will now be searched
        System.out.println("Let's search the Stack...");
        // prints the revised stack consisting of numbers from the stack demo
        System.out.println("The current stack: " + numberLinkedList.toString());

        boolean userUsingProgram = true; // variable to represent if the user is still using the program


        /* while loop runs while userUsingProgram variable is true, and if they indicate that they want to stop
        using the program, than it will end */

        while (userUsingProgram==true){
            System.out.print("\nEnter the value you are searching for: "); // asks user to enter value they want
            Integer userInputValue = input.nextInt(); // saves user inputted value into a field
            // stores position that the value was found in the stack in a field called position
            int position = numberLinkedList.searchStack(userInputValue);
            /* if the position is 0 then the value was not found in the stack and the program prints the user telling
            them that the value was not found*/
            if (position == 0){
                System.out.println("The value is not found!"); // prints message saying value not found
            }
            else{
                // if value is found, then a message is printed giving the values exact position in the stack
                System.out.println("The value " + userInputValue + " is found in location " + position +  " from the top of the stack");
            }
            // asks the user if they want to continue using program
            System.out.print("Do you want to continue? (enter 'y' for yes, or enter any other key to discontinue): ");
            // users input for if they want to continue is stored in the userAnswer field
            String userAnswer = input.next();
            // if the user enters a Y (yes), they can keep searching for the position of values they enter
            if(userAnswer.equalsIgnoreCase("y")){
                userUsingProgram=true; // userUsingProgram variable remains true
            }
            else{
                userUsingProgram=false; // userUsingProgram variable remains false
            }
        }

        // displays and formats the footer
        System.out.println("\n==============================================================================================================");
        DemoSinglyLinkedList.footer(1); // calls the footer method
        System.out.println("\n==============================================================================================================");


    }




}

