package queue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue <T> implements Iterable <T> {
    private LinkedList <T> list = new LinkedList<T>();

    public Queue(){ }

    public Queue(T firstElement){
        //offer(firstElement)
    }

    //Return the size of the queue
    public int size(){
        return list.size();
    }

    //Returns wether or not the list is empty
    public boolean isEmpty(){
        return size() == 0;
    }

    //peek the element at the front of the queue
    //The method throws an error if the queue is empty
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException("Queue Empty");
        }
        return list.peekFirst();
    }

    //Remove the first element of the queue
    public T dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue Empty");
        }
        return list.removeFirst();
    }

    //Add the element at the last of the queue
    public void enqueue(T element){
        list.addLast(element);
    }

    //Return an iterator to allow the user to traverse
    //through the elements found inside the queue
    @Override
    public Iterator <T> iterator(){
        return list.iterator();
    } 
}
