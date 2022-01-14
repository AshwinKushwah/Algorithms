package priorityqueue;

public class PQueue {
    static int size = -1;
    static int Heap[] = new int [50];

    //Function to return the index of the 
    //parent of the node
    public static int parent(int index){
        return (index-1)/2;
    }

    //Function to shiftup the node
    //to maintain the heap property
    public static void shiftUp(int index){

        while(index > 0 && Heap[parent(index)] < Heap[index]){
            //swap the current and parent
            swap(parent(index), index);

            //update the index 
            index = parent(index);
        }
        
    }

    //Function to shiftdown the node
    //to main the heap property
    public static void shiftDown(int index){
        int maxIndex = index;
        int leftChild = 2*index + 1;
        int rightChild = 2*index + 2;

        if(leftChild <= size && Heap[leftChild] > Heap[maxIndex]){
            maxIndex = leftChild;
        }

        if(rightChild <= size && Heap[rightChild] > Heap[maxIndex]){
            maxIndex = rightChild;
        }
        if(index != maxIndex){
            swap(index, maxIndex);
            shiftDown(maxIndex);
        }

    }

    //Function to insert the element into Heap
    public static void insert(int element){
        //increase the size
        size = size+1;
        Heap[size] = element;

        //shift up after inserting element at last
        shiftUp(size);
     }

     //Function to extract the top(first) element
     public static int extractMax(){
         int result = Heap[0];
         swap(0,size);
         size = size-1;

         //shift down the replacted element
         //to maintain the Heap Property
         shiftDown(0);

         return result;
     }

    //Function to remove the element at particular index
    public static void removeAt(int index){

        //make the targeted element maximum and shift up
        Heap[index] = Heap[0] + 1;
        shiftUp(index);

        //etract the node
         extractMax();
        
    }

    public static void swap(int i, int j){
        int temp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j] = temp;

    }

    public static void main(String args[]){
        /*     45
            /     \
           31      14
          /  \    /  \
         13  20  7   11
        /  \
       12   7
        Create a priority queue shown in
        example in a binary max heap form.
        Queue will be represented in the
        form of array as:
        45 31 14 13 20 7 11 12 7 */
 
        // Insert the element to the
        // priority queue
        insert(45);
        insert(20);
        insert(14);
        insert(12);
        insert(31);
        insert(7);
        insert(11);
        insert(13);
        insert(7);


        int i = 0;
        // Priority queue before extracting max
        System.out.print("Priority Queue : ");
        while (i <= size)
        {
            System.out.print(Heap[i] + " ");
            i++;
        }

        System.out.print("\n");

        //extract the top element
        int topElement = extractMax();
        System.out.println("The top element removed is-- "+ topElement);

        // Priority queue after extracting max
        System.out.print("Priority queue after " +
        "extracting maximum : ");
        int j = 0;
        while (j <= size)
        {
            System.out.print(Heap[j] + " ");
            j++;
        }

        System.out.print("\n");

        removeAt(4);
        
        System.out.print("Priority queue after " +
        "removing the element at index 4 : ");
        int l = 0;
        while (l <= size)
        {
            System.out.print(Heap[l] + " ");
            l++;
        }
        

    }

}
