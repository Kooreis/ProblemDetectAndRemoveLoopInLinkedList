Here is a C# console application that detects and removes a loop in a linked list:

```C#
using System;

public class Node
{
    public int data;
    public Node next;
    public Node(int d)
    {
        data = d;
        next = null;
    }
}

public class LinkedList
{
    public Node head;

    public void Push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void DetectAndRemoveLoop()
    {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
            {
                RemoveLoop(slow);
                return;
            }
        }
    }

    void RemoveLoop(Node loop)
    {
        Node ptr1 = loop;
        Node ptr2 = loop;

        int k = 1;
        while (ptr1.next != ptr2)
        {
            ptr1 = ptr1.next;
            k++;
        }

        ptr1 = head;
        ptr2 = head;
        for (int i = 0; i < k; i++)
        {
            ptr2 = ptr2.next;
        }

        while (ptr2 != ptr1)
        {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        while (ptr2.next != ptr1)
        {
            ptr2 = ptr2.next;
        }

        ptr2.next = null;
    }
}

class Program
{
    static void Main(string[] args)
    {
        LinkedList list = new LinkedList();
        list.Push(20);
        list.Push(4);
        list.Push(15);
        list.Push(10);

        list.head.next.next.next.next = list.head;

        list.DetectAndRemoveLoop();

        Console.WriteLine("Linked List after removing loop");
        Node temp = list.head;
        while (temp != null)
        {
            Console.Write(temp.data + " ");
            temp = temp.next;
        }
    }
}
```