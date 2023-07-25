import java.util.Scanner;

class Node{
    int value; //data
    Node next; //memory of next data
    Node(int value){
        this.value = value;
    }
}
class LinkedList{
    Node head, tail; // start ad end pointer
    int length = 0; // length of the linked list

    // create a new LinkedList
    LinkedList(int value){
        Node newNode = new Node(value);
        head  = newNode;
        tail = newNode;
        length++;
    }

    LinkedList() {
    }

    // display the LinkedList
    void printLL(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    //Insert at the beginning
    void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // Insert at the end
    void append(int value){
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    //Insert at index
    boolean insert(int index, int value){
        if(index < 0 || index > length){
            return false;
        }
        if(index == 0){
                prepend(value);
                return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp  = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    // Get Node
    Node get(int index){
        if(index <0 || index >= length){
            return null;
        }
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }
    void getHead(){
        System.out.println(head.value);
    }
    void getTail(){
        System.out.println(tail.value);
    }
    void getLength(){
        System.out.println(length);
    }

    // Set Node
    boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    // Remove First element
    Node removeFromFirst(){
        if(length == 0){
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0){
            tail = null;
        }
        return temp;
    }

    // Remove Last element
    Node removeFromLast(){
        if(length == 0){
            return null;
        }
        Node temp = head;
        Node prev = head;
        while( temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    // Remove From index
    Node remove(int index){
        if(index < 0 || index >= length){
            return null;
        }
        if(index == 0){
            return removeFromFirst();
        }
        if(index == length-1){
            return removeFromLast();
        }
        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    // Reverse teh linked List
    void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node next = temp.next;
        Node before = null;
        for(int i = 0; i < length; i++){
            Node after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}
public class LinkedListWorking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Linked List Implementations");
        LinkedList myList = new LinkedList();
        int data = 0, i = 0;
        System.out.println("Enter your linked list elements and type -1 to stop");
        while(true){
            data = scanner.nextInt();
            if(data == -1){
                break;
            }
            myList.insert(i++, data);
        }
        System.out.println("Your linked list looks like...");
        myList.printLL();
        char choice = 'y';
        while(choice == 'y'){
            System.out.println("Implementations on Linked List\n1 -> Display\n2 -> Insert at beginning (prepend)\n3 -> Insert at end (append)\n4 -> Insert at index\n5 -> Remove from first\n6 -> Remove from Last\n7 -> Remove from index\n8 -> Reverse the Linked List\n9 -> Get the value of given node\n10 -> Get Size of the linked List\n11 -> Get value that HEAD pointing to\n12 -> Get the value pointing to TAIL\n13 -> Update the value of given index");
            System.out.print("Enter one of the following options to see its implementation: ");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Display...");
                    myList.printLL();
                    break;
                case 2:
                    System.out.println("before insertion: ");
                    myList.printLL();
                    System.out.print("Enter the value to prepend: ");
                    myList.prepend(scanner.nextInt());
                    System.out.println("after insertion");
                    myList.printLL();
                    break;
                case 3:
                    System.out.println("before insertion: ");
                    myList.printLL();
                    System.out.print("Enter the value to append: ");
                    myList.append(scanner.nextInt());
                    System.out.println("after insertion");
                    myList.printLL();
                    break;
                case 4:
                    System.out.println("before insertion: ");
                    myList.printLL();
                    System.out.print("Enter the index, value to insert: ");
                    while(!myList.insert(scanner.nextInt(), scanner.nextInt())){
                        System.out.print("Enter valid index, value to insert: ");
                    }
                    System.out.println("after insertion");
                    myList.printLL();
                    break;
                case 5:
                    System.out.println("before deletion: ");
                    myList.printLL();
                    System.out.println("Removing first element...");
                    myList.removeFromFirst();
                    System.out.println("after deletion");
                    myList.printLL();
                    break;
                case 6:
                    System.out.println("before deletion: ");
                    myList.printLL();
                    System.out.println("Removing last element...");
                    myList.removeFromLast();
                    System.out.println("after deletion");
                    myList.printLL();
                    break;
                case 7:
                    System.out.println("before deletion: ");
                    myList.printLL();
                    System.out.print("Enter the index you want to remove: ");
                    myList.remove(scanner.nextInt());
                    System.out.println("after deletion");
                    myList.printLL();
                    break;
                case 8:
                    System.out.println("before reversing");
                    myList.printLL();
                    myList.reverse();
                    System.out.println("After reversing");
                    myList.printLL();
                    break;
                case 9:
                    System.out.print("Enter the index of the node you want to get: ");
                    System.out.println("Value: "+myList.get(scanner.nextInt()).value);
                    break;
                case 10:
                    System.out.print("Size of the linked list: ");
                    myList.getLength();
                    break;
                case 11:
                    System.out.print("Head element: ");
                    myList.getHead();
                    break;
                case 12:
                    System.out.print("Tail element: ");
                    myList.getTail();
                    break;
                case 13:
                    System.out.println("before updating");
                    myList.printLL();
                    System.out.print("Enter the index, value to update: ");
                    while (!myList.set(scanner.nextInt(), scanner.nextInt())){
                        System.out.print("Enter valid index, value to update: ");
                    }
                    System.out.println("after updating");
                    myList.printLL();
                    break;
            }
            System.out.print("You want to explore more implementation (y/n): ");
            choice = scanner.next().charAt(0);
        }
        scanner.close();
    }
}
