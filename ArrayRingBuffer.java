import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayRingBuffer {  // class declaration of ArrayRingBuffer class.
    Integer[] ringBuffer;       // declares instance variable of array backing ring buffer.
    int front;                  // declares instance variable for tracking the front of queue.
    int rear;                   // declares instance variable for tracking the back of queue.
    int size;                   // declares instance variable for tracking the size of queue.

    public ArrayRingBuffer (int capacity){          // declares the constructor of the ArrayRingBuffer class
        this.ringBuffer = new Integer[capacity];    // assigns the ringBuffer instance variable to a new Integer array of length "capacity."
        this.front = 0;                             // assigns the front instance variable to the int zero
        this.rear = -1;                             // assigns the front instance variable to the int negative one
        this.size = 0;                              // assigns the front instance variable to the int zero
    }

    public void enqueue(Integer the_integer){               // declares the enqueue method.
        if(size == ringBuffer.length){                      // checks if the queue is full.
            System.out.println("Ring buffer is full!!");    // if it's full it displays message
        }
        else {                                  // if it's not full it does whats below.
            if(rear == ringBuffer.length -1) {  //first it checks if the rear is at the end of the array.
                rear = -1;                      // if it is it sets rear to -1
            }
            rear++;                         // now it increases rear to the next location
            ringBuffer[rear] = the_integer; // the integer is then added to the array.
            size++;                         // this increments the size variable (ensuring that we're keeping track of the size)
        }
    }

    public Integer dequeue(){                               // declares the dequeue method.
        if(size == 0) throw new NoSuchElementException();   // checks if the queue is empty and then throws exception.
        else {                                              // if not then it does whats below.
            Integer dequeueSubject = ringBuffer[front];     // creates a new Integer object for the first queue element.
            ringBuffer[front] = null;                       // cleans up the element at the front of queue.
            size--;                                         // this decrements the size variable (ensuring that we're keeping track of the current size).
            if(front == ringBuffer.length-1) front = -1;    // checks if the front of the queue is at the end of the array and changes front to -1 if so.
            front++;                                        // the next element of the queue is assigned as the front.
            return dequeueSubject;                          // returns removed element.
        }
    }


    public void printQueue(){                                               // this declares the printQueue method.
        System.out.println("Ring buffer:" + Arrays.toString(ringBuffer));   // it prints the contents of queue as a String.
    }

        public void isEmpty(){                                              // creates isEmpty method.
            if(front == -1)System.out.println("This Buffer is Empty!!");    // prints message when queue is empty
            else if(front == rear) front = rear = -1;                       // sets front and rear to negative one when queue has no elements.
            else if(front == size-1) front = 0;                             // readjusts the front of the queue for accurate filling of queue.

        }

    public static void main(String[]args){
        ArrayRingBuffer myRingBuffer = new ArrayRingBuffer(4);  // instantiates the ArrayRingBuffer class.

        myRingBuffer.enqueue(1);        // adds the Integer 1 to the queue.
        myRingBuffer.enqueue(2);        // adds the Integer 2 to the queue.
        myRingBuffer.enqueue(3);        // adds the Integer 3 to the queue.
        myRingBuffer.enqueue(4);        // adds the Integer 4 to the queue.

        myRingBuffer.printQueue();                 // prints the ring buffer.

        myRingBuffer.dequeue();                    // remove the Integer 1 from the queue.
        myRingBuffer.dequeue();                    // removes the Integer 2 from the queue.
        myRingBuffer.printQueue();                 // prints the ring buffer.

        myRingBuffer.enqueue(9);        // adds the Integer 9 to the queue.
        myRingBuffer.enqueue(20);       // adds the Integer 20 to the queue.
        myRingBuffer.printQueue();
        myRingBuffer.enqueue(5);        // attempts to add the Integer 5 to the queue (but the queue would be full)

    /*
    the time and space complexity of the program in o(1), constant time. This is because no matter what the program does it
    it perform roughly same number of operations regardless of how big the the data is or how "long" the queue gets.
    */

    }

}
