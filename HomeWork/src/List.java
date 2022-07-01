import java.util.Arrays;

public class List {

    public static void main(String[] args)
    {
        LinkedList l1 = new LinkedList();

        l1.enQueue(new ListNode("Dan", null, null, 1));
        l1.enQueue(new ListNode("Laura", null, null, 2));
        l1.enQueue(new ListNode("Jack" , null, null, 1));
        l1.enQueue(new ListNode("Rose", null, null, 3));
        l1.enQueue(new ListNode("Berry", null, null, 3));
        l1.display();
        System.out.println("Top Priority is: " + l1.getTopPriority().getName());
        l1.deQueuePriority();
        l1.display();
        System.out.println("Top Priority is: " + l1.getTopPriority().getName());
        l1.deQueuePriority();
        l1.display();
        System.out.println("Top Priority is: " + l1.getTopPriority().getName());
        l1.deQueuePriority();
        l1.display();
        System.out.println("Top Priority is: " + l1.getTopPriority().getName());
        l1.enQueue(new ListNode("Magic", null, null, 1));
        l1.display();
        System.out.println("Top Priority is: " + l1.getTopPriority().getName());
        l1.deQueuePriority();
        l1.display();
        System.out.println("Top Priority is: " + l1.getTopPriority().getName());
        l1.enQueue(new ListNode("Wiggy", null, null, 3));
        l1.display();
        System.out.println("Top Priority is: " + l1.getTopPriority().getName());
        l1.deQueuePriority();
        l1.display();
        System.out.println("Top Priority is: " + l1.getTopPriority().getName());
        l1.deQueuePriority();
        l1.deQueuePriority();
        l1.display();
    }
}
