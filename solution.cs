public class LinkedList
{
    public Node head;

    public void Push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
}