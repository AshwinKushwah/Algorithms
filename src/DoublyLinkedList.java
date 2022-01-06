public class DoublyLinkedList <T> /*implements Iterable <T>*/ {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    //Internal node class to represent data
    private class Node <T> {
        T data;
        Node <T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString(){
            return this.data.toString();
    
        }
    }
    //Empty the linked-list, complexity - O(n)
    public void clear(){
        Node<T> trav = head;
        
        while(trav != null){
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    //Return the size of the linked-list
    public int size(){
        return size;
    }

    //Is this linked list empty 
    public boolean isEmpty(){
        return size() == 0;
    }

    //Add a element at the tail of the linked-list, Complexity - O(1)
    public void addLast(T ele){
        if(isEmpty()){
            head = tail = new Node<T>(ele, null, null);
        } else{
        Node<T> newNode = new Node<T>(ele, tail, null); 
        tail = newNode;
        }
        size++;
        
    }

    //Add a element at the first of the linked-list, Complexity - O(1)
    public void addFirst(T ele){
        if(isEmpty()){
            head = tail = new Node<T>(ele, null, null);
        } else{
            Node<T> newNode = new Node<T>(ele,null,head);
            head = newNode;
        }
        size++;
    }

    //Add an element at an specific index , Complexity - O(n)
    public void addAt(T data, int index) throws Exception {
        if(index < 0 || index > size){
            throw new Exception("Illegal Index");
        }

        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size){
            addLast(data);
            return;
        }

        Node<T> temp = head;
        for(int i = 0; i<index; i++){
            temp = temp.next;
        }
        Node<T> newNode = new Node<T>(data,temp.prev,temp);
        temp.prev.next = newNode;
        temp.prev = newNode;
        
        size++;
    }

    //Remove the first node, Complexity - O(1)
    public T removeFirst(){
        if(isEmpty()) throw new RuntimeException("Empty List");

        T data = head.data;
        head = head.next;
        size--;

        return data;
    }

    //Remove the Last node, Complexity - O(1)
    public T removeLast(){
        if(isEmpty()) throw new RuntimeException("Empty List");

        T data = tail.data;
        tail.prev.next = null;
        tail = tail.prev;
        size--;

        return data;
    }

    //Remove a node at particular index, Complexity -  O(n)
    public T removeAt(int index){

        if(index < 0 || index >= size ){
            throw new IllegalArgumentException();
        }
        int i;
        Node<T> trav;
        //search the list from the front
        if(index < size/2){
            for(i = 0,trav= head ; i!= index; i++){
                trav = trav.next;
            }
        } 
        //search the list from back of the list
        else{
            for(i=size-1, trav=tail; i != index; i--){
                trav = trav.prev;
            }
        }
        T data = trav.data;
        trav.next.prev = trav.prev;
        trav.prev = trav.next;

        trav = null;
        return data;

    }   

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> trav = head;
        while(trav != null){
            sb.append(trav.data);
            if(trav.next != null){
                sb.append(",");
            }
            trav = trav.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
