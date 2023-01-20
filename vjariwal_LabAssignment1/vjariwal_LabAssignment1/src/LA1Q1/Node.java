package LA1Q1;

public class Node <T>{

    private T element; // element field that represents the data within the node
    private Node<T> next; // next field of type Node that represents the next node address in the linked list

    // creates an empty constructor
    public Node(){

    }

    // constructor that initializes the element and next fields
    public Node(T t, Node<T> n){
        element = t;
        next = n;
    }

    // getter method to get the next address of the next node in the linked list
    public Node<T> getNext(){
        return next;
    }

    // getter method to get the element stored in the node of the linked list
    public T getElement(){
        return element;
    }


    // setter method for the next node
    public void setNext(Node<T> n){
        next = n;
    }


}
