package LE3Q1;

public class Driver_DoublyLinkedList {
    //creates header, requires assignment number
    public static void header(int labE_number, int q_number) {
        System.out.printf("Lab Assignment %d-Q%d", labE_number, q_number);
        System.out.printf("\nPrepared By: Vivek Jariwala");
        System.out.printf("\nStudent Number: 251213353");
        System.out.printf("\nGoal of this Exercise: Working with a doubly linked list");
    }

    //creates footer, requires assignment number
    public static void footer(int labE_number, int q_number) {
        System.out.printf("Completion of Lab %d-Q%d is successful", labE_number, q_number);
        System.out.printf("\nSigning off - Vivek");

    }

    public static void main(String[] args) {
        System.out.println("==============================================================================================================");
        header(3,1);
        System.out.println("\n==============================================================================================================");

        DoublyLinkedList<MyStudent> vivekList = new DoublyLinkedList<>();

        MyStudent s0 = new MyStudent();
        MyStudent s1 = new MyStudent("Harry", 67.35);
        MyStudent s2 = new MyStudent("Luna", 87.5);
        MyStudent s3 = new MyStudent("Vincent", 60.5);
        MyStudent s4 = new MyStudent("Hermione", 89.2);

        vivekList.addLast(s0);
        vivekList.addLast(s1);
        vivekList.addLast(s2);
        vivekList.addLast(s3);

        System.out.println("Adding 4 students to the list.");
        System.out.println("The list content:");
        System.out.println(vivekList.toString());
        System.out.println("Adding Hermione to the list in between Luna and Vincent.....");
        DoublyLinkedList.Node<MyStudent> node2 = vivekList.findNode(s2);
        DoublyLinkedList.Node<MyStudent> node3 = vivekList.findNode(s3);

        vivekList.addBetween(s4,node2,node3);

        System.out.println("The list Content:");
        System.out.println(vivekList.toString());


        // displays and formats the footer
        System.out.println("==============================================================================================================");
        footer(3,1); // calls the footer method
        System.out.println("\n==============================================================================================================");

    }



}
