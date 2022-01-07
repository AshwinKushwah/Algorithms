package stack;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {
    
    private LinkedList<T> list = new LinkedList<T> ();

    //create an empty stack
    public Stack() { }

    //create a Stack with an initial element
    public Stack (T firstElement){
       push(firstElement); 
    }

    //Return the number of elements in the stack
    public int size(){
        return list.size();
    }

    //check if the stack is empty
    public boolean isEmpty(){
        return size() == 0;
    }

    //push an element on the stack
    public void push(T element){
        list.addLast(element);
    }

    //Pop an element off the stack
    //Throws an error if the stack is empty
    public T pop(){
        if(isEmpty()){
            throw new java.util.EmptyStackException();
        }

        return list.removeLast();
    }

    //peek the first element of the stack wihtout removing an element
    //Throws an exceptiom if the stack is empty
    public T peek(){
        if(isEmpty()){
            throw new java.util.EmptyStackException();
        }
        return list.peekLast();
    }

    //Allow users to iterate through the stack using an iterator
    @Override
    public Iterator<T> iterator(){
        return list.iterator();
    }
}
