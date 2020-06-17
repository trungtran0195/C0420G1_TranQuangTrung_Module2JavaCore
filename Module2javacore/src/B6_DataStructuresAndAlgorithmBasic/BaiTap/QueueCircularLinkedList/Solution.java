package B6_DataStructuresAndAlgorithmBasic.BaiTap.QueueCircularLinkedList;

public class Solution {
    static void enQueue(Queue  q, int value)
    {
        Node  temp = new Node();
        temp .data = value;
        if (q .front ==  null)
            q .front = temp;
        else
            q .rear .link = temp;

        q .rear = temp;
        q .rear .link = q .front;
    }

    static int deQueue(Queue  q)
    {
        if (q .front ==  null)
        {
            System.out.printf ("Queue is empty");
            return Integer.MIN_VALUE;
        }

        // If this is the last node to be deleted
        int value; // Value to be dequeued
        if (q .front == q .rear)
        {
            value = q .front .data;
            q .front =  null;
            q .rear =  null;
        }
        else  // There are more than one nodes
        {
            Node  temp = q .front;
            value = temp .data;
            q .front = q .front .link;
            q .rear .link= q .front;
        }

        return value ;
    }

    static void displayQueue( Queue  q)
    {
        Node  temp = q .front;
        System.out.printf(" Elements in Circular Queue are: ");
        while (temp .link != q .front)
        {
            System.out.printf("%d ", temp .data);
            temp = temp .link;
        }
        System.out.printf("%d", temp .data);
    }

}
