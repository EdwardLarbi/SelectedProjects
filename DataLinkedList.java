public class DataLinkedList {                  // Class declaration of my linked list
    DataNode head = null;                      // instance variable of linkedlist class called head. It's set to null.

    public void addNode(int data) {            // method declaration of linkedlist class for adding a node to linked list
        DataNode node = new DataNode(data);    // this creates a new node with the int parameter.
        node.setNext(head);                    // this points the current head as the next node of the just added node.
        head = node;                           // this now makes the just added node the head of the linkedlist.
    }

    public void deleteNode() {                 // method declaration of a method for deleting nodes.
        DataNode deletionTarget = head;        // creates a new variable to point to the current head.
        head = head.getNext();                 // set the next node in the list as the new head.
        deletionTarget.setNext(null);          // disconnects the old head from the list.
    }

    public DataNode getHead() {                // getter for head instance variable of linkedlist class.
        return head;
    }

    public void printList() {                  // method declaration of a printList method of the linkedlist class.
        DataNode current = head;               // creates a new variable to refer to the head.
        while (current != null) {              // while loop continues till the current variable is null.
            System.out.println(current.data + "");  // prints the data instance variable of each node.
            current = current.getNext();            // assigns the current variable to the next node.
        }
        System.out.println("..............................................."); // dots for clear demarcation.
    }

    class DataNode {         // class declaration.
        int data;                   //instance variable of DataNode class. it holds an int.
        DataNode next;              //instance variable of DataNode class. It holds a DataNode.

        public DataNode(int data){  // this is the constructor for DataNode class.
            this.data = data;
        }

        public DataNode getNext() { // a getter of next instance variable.
            return next;
        }

        public void setNext(DataNode next) {    // a setter for next instance variable.
            this.next = next;
        }

        public int getData() {                   // a getter for data instance variable.
            return data;
        }

        public void setData(int data) {          // a setter for data instance variable.
            this.data = data;
        }
    }


    public static void main(String[]args){
        DataLinkedList myLinkedList = new DataLinkedList();  // declares linked list.
        myLinkedList.addNode(10);   // this adds a node to the linked list
        myLinkedList.addNode(20);   // this adds a node to the linked list
        myLinkedList.addNode(30);   // this adds a node to the linked list
        myLinkedList.addNode(40);   // this adds a node to the linked list
        myLinkedList.addNode(50);   // this adds a node to the linked list

        myLinkedList.printList();         // this prints the linked list contents of 5 integers
        myLinkedList.deleteNode();        // this delete the head node. which is 50, the most recently added node.
        myLinkedList.printList();         // this prints the linked list, consisting now of only 4 integers.
    }
}