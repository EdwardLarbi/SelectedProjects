import java.util.Arrays;

public class HeapMaximumSort {                                                      // declares the class HeapMaximum
    public static void main(String[]args){                                          // declares main method
        int[] minimumHeap = {3,5,9,6,8,20,10,12,18,9};                              // creates a minimum heap

        int[]maximumHeap = convertToMaximumHeap(minimumHeap);                       // calls method to create a maximum heap
        System.out.println(Arrays.toString(maximumHeap));
    }

    public static int[] convertToMaximumHeap(int[] theMinimumHeap){                 // declares method for converting to maximum heap
        int[] maximumHeap;                                                          // creates int array for holding results in future

        int endOfHeapIndex = theMinimumHeap.length-1;                               // creates variable for marking the highest index of minimum heap
        for(int i=0; i < endOfHeapIndex; i++){                                      // for loop through array
            int temp = theMinimumHeap[0];                                           // holds value at index 0 for future use (swap)
            theMinimumHeap[0] = theMinimumHeap[endOfHeapIndex-i];                   // replaces the root with the last element of array (unsorted heap)
            theMinimumHeap[endOfHeapIndex-i] = temp;                                // replaces the last element of unsorted portion of heap with the just saved temp value

            heapify(theMinimumHeap, 0, endOfHeapIndex-i-1);             //  calls heapify method which ensures the unsorted upper portion is still a minimum heap
        }

        maximumHeap = theMinimumHeap;                                               // converted heap is saved in appropriate variable
        return maximumHeap;                                                         // returns the maximum heap
    }

    public static void heapify(int [] minHeap, int index, int end){                 // declares heapify method
        int childToSwap;                                                            // variable to be used for holding index of the smallest child value

        while(index<=end){                                                          // loop the unsorted portion in search the next smallest value to be placed at the root
            int leftChild = 2*index + 1;                                            // formula for finding a left child in a heap array
            int rightChild = 2*index +2;                                            // formula for finding a right child in a heap array
            if(leftChild <= end){                                                   // if this node has a left child
                if(rightChild>end){                                                 // if there is no right child
                   childToSwap = leftChild;                                         // then the child to swap is the left child
                }
                else{                                                               // but if there is a right child...
                    childToSwap =(minHeap[leftChild]<minHeap[rightChild] ? leftChild : rightChild);         // then whose smaller and set as the child to swap.
                }

                if(minHeap[index]>minHeap[childToSwap]){                  // check if the the smallest child is smaller than the root(or the node of current iteration)
                    int temp = minHeap[index];                            // if it is then save the large parent in temp
                    minHeap[index] = minHeap[childToSwap];                // replace large parent with smaller child
                    minHeap[childToSwap] = temp;                          // replace this with the larger parent earlier saved in temp
                }
                else break;                                 // but if no child was smaller in the first place then leave the loop
                index = childToSwap;                        // now save the childToSwap as the new starting point of this loop
            }
            else break;             // get out of the loop


        }

        /*
        the time and space complexity of this program is Quadratic time O(n^2).
        This is due to the fact that the prog traverses the length of the array, taking from one end and
        swapping it with the other end. Also with every iteration another loop in entered which may also
        go all the way down the heap.
        * */
    }


}
