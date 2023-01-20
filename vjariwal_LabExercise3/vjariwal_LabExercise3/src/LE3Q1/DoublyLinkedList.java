package LE3Q1;
import java.util.ArrayList;

public class DoublyLinkedList<E>{
    public static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;


        public Node (E element, Node<E> prev, Node<E> next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext(){
            return next;
        }

        public void setPrev(Node<E> p){
            prev = p;
        }

        public void setNext(Node<E> n){
            next = n;
        }
    } // end of Node class

    private Node<E> header;

    private Node<E> trailer;

    private int size=0;

    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }

    public void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public Node<E> findNode(E e){
        Node<E> head = header;
        while(head != null){
            if(head.getElement() == e){
                return head;
            }
            head = head.getNext();
        }
        return null;
    }

    public String toString(){
        ArrayList<E> output = new ArrayList<>();
        Node<E> head = header.getNext();
        for(int i = 0; i< size; i++){
            output.add(head.getElement());
            head = head.getNext();
        }
        return output.toString();
    }

}
