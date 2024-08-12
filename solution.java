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