package LA1Q1;

public class SinglyLinkedList<T> {
    private Node<T> head=null; // creates the head node and initializes it to null
    private Node<T> tail=null; // creates the tail node and initializes it to null
    private int size=0; // creates the variable for the size of the linked list and initializes it to 0


    // empty constructor
    public SinglyLinkedList(){

    }

    // creates constructor that initializes head, tail, and size objects

    public SinglyLinkedList(Node<T> head, Node<T> tail, int size){
        this.head = head;
        this.tail = tail;
        this.size = size;

    }

    // getSize() is a getter method for the field ‘size’
    public int getSize(){
        return size;
    }

    //isEmpty() method returns true if the list is empty
    public boolean isEmpty(){
        return getSize() == 0;
    }

    /*This toString() overrides the Object’s toString() method and returns the linked list as a string according to the
    format that you use inside any print statements
     */
    public String toString(){
        String output = "["; /* creates string variable, output, to hold the string of the linked list and initialized
        with an opening square bracket to help format the display of the elements of the linked list
        */
        Node<T> current = head; // creates node, current, that is initially pointing to the head node

        // if the head address of the linked list is null, it returns an empty string represented by two square brackets
        if(current == null){
            output+= "]"; // a closing square bracket is added to close the output string formatting
            return output; // returns the output string to wherever the method is called
        }

        // a while loop that cycles through the linked list until it reaches the end (by getting to a null address)
        while(current.getNext() != null){
            output += current.getElement(); // the data stored in each node is retrieved and added to the output string

            /* the values of the output string are separated by commas which are added to the output string provided
            there are still a next value (the next address is not null) so that it is formatted correctly*/
            if(current.getNext() != null){
                output += ", "; // adds a comma
            }
            current = current.getNext(); // current node moves to the next node address
        }
        output+=current.getElement(); // from the final node, the data is retrieved and added to the output string
        output+= "]"; // a closing square bracket is added to close the output string formatting
        return output; // returns the output string to wherever the method is called
    }

    // adds element in a node to the front of the linked list

    public void addFirst(T element){
        head = new Node<>(element,head);  // new head is created

        // if the linked list is empty (size of 0), then the tail address is also tied to the head
        if (isEmpty()){
            tail = head;
        }
        size++; // increases size counter of linked list because new node was added
    }

    // adds element in a node to the back of the linked list
    public void addLast(T element)
    {
        // new node created and initialized to store a given element and has a null address
        Node<T> newest = new Node<>(element, null);
        // if the linked list is empty (size of 0), then the new node is also the head
        if(isEmpty())
        {
            head = newest;
        }
        else
        {
            tail.setNext(newest); // set the next reference of the newest node to the node that the tail refers to
        }
        tail = newest; // newest node is now tied to the tail address
        size++; // increase size of linked list because new node was added
    }
    // removes first node from the linked list
    public T removeFirst(){

        if (isEmpty()){
            return null; // if the linked list is empty, there is nothing to remove, so null is returned
        }
        T headValue = head.getElement(); // retrieves the element stored in the head node and stores it in headValue
        head = head.getNext(); // sets the reference of the node after the head to become the new head node
        size--; // decreases size of the linked list by one because a node was removed

        // if the linked list is empty (its size is 0) the tail address is null
        if (isEmpty()){
            tail = null;
        }
        return headValue; // returns the element stored in the old head node

    }

    // removes last node from the linked list
    public T removeLast() {

        // if the linked list is empty (its size is 0) it returns null
        if (isEmpty())
        {
            return null;
        }

        // creates a tail node field that will equal the tail node in current linked list
        Node<T> lastNode = head;
        // creates a second last node field to represent second last node in current linked list
        Node<T> secondLastNode = null;
        while (lastNode.getNext() != null)
        {
            secondLastNode = lastNode; // second last node points to the last node address
            lastNode = lastNode.getNext(); /// last node gets the reference to the next node address
        }
        secondLastNode.setNext(null); // the second last node sets its next reference to be null (making it new tail)
        tail = secondLastNode; // second last node becomes the new tail of the linked list
        size--; // decreases size of the linked list because node was removed
        T lastNodeValue = lastNode.getElement(); // retrieves the element stored in the tail node
        return lastNodeValue; // returns the element stored in the last node
    }
    // to push an element to the head of the linked list, it executes the same actions as the addFirst method
    public void pushAtHead(T element){
        addFirst(element);
    }

    // to pop an element to the head of the linked list, it executes the same actions as the removeFirst method
    public T popFromHead(){
        T headPopValue = removeFirst();
        return headPopValue;
    }

    // to push an element to the tail of the linked list, it executes the same actions as the addLast method
    public void pushAtTail(T element){
        addLast(element);
    }

    // to pop an element from the tail of the linked list, it executes the same actions as the removeLast method
    public T popFromTail(){
        T tailPopValue = removeLast();
        return tailPopValue;
    }

    // to enqueue an element to the tail of the linked list, it executes the same actions as the addLast method

    public void enqueueAtTail(T element){
        addLast(element);
    }


    // to dequeue an element to the tail of the linked list, it executes the same actions as the removeFirst method

    public T dequeueAtHead(){
        T queueValue = removeFirst();
        return queueValue;
    }

    // searches stack for a given value and returns its position in the linked list
    public int searchStack(T element) {
        Node current = head; // creates a current node that points to the head address
        // counter will keep track of the position of the linked list that current node is at (head is at position 1)
        int counter = 1;

        /* as long as the node address is not null, the while loop keeps running and will cycle through the linked list
        to find the given element that it is searching for by comparing it with the element in each node*/
        while(current != null) {
            // checks if element in the current node is the element that the method is searching for
            if(current.getElement() == element) {
                break; // if it finds the element, it leaves the while loop
            }
            counter++; // if element is not found, the counter is increased by 1
            current = current.getNext(); // current node goes to the next node address in the linked list
        }
        // if the current is null, the linked list is empty (head is null), so the counter becomes 0 as well
        if (current==null){
            counter=0;
        }
        return counter; // returns the value of the counter
    }



}
