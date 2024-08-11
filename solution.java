Here is a Java console application that detects and removes a loop in a linked list:

```java
import java.util.HashSet;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void detectAndRemoveLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                removeLoop(slow);
                return;
            }
        }
    }

    void removeLoop(Node loopNode) {
        Node ptr1 = loopNode;
        Node ptr2 = loopNode;

        int k = 1;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }

        ptr1 = head;
        ptr2 = head;
        for (int i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }

        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }

        ptr2.next = null;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        list.head.next.next.next.next.next = list.head.next.next;

        list.detectAndRemoveLoop();

        System.out.println("Linked List after removing loop : ");
        list.printList();
    }
}
```

This program creates a linked list with a loop, detects the loop, removes it, and then prints the modified linked list. The `detectAndRemoveLoop` method uses Floyd’s Cycle detection algorithm to detect the loop. If a loop is detected, it calls the `removeLoop` method to remove the loop. The `removeLoop` method counts the number of nodes in the loop, then uses two pointers to find the start of the loop and breaks the loop from there.