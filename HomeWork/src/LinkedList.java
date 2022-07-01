import java.util.NoSuchElementException;

public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private ListNode topPriority;
    private int size;

    public LinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public void enQueue(ListNode ln)
    {
        if (size > 0)
        {
            ln.setPrev(tail);
            tail.setNext(ln);
            tail = ln;
            tail.setNext(null);
        }
        else
        {
            head = ln;
            tail = ln;
            head.setPrev(null);
        }
        size++;
        System.out.println("Added: " + ln.getName() + " Queue is now size: " + size);
        setTopPriority();
    }

    public void deQueue()
    {
        if (size > 1)
        {
            head = head.getNext();
            head.setPrev(null);
            --size;
            setTopPriority();
        }
        else if(size == 1)
        {
            head = null;
            tail = null;
            --size;
            System.out.println("Queue is now empty");
        }
        else
        {
            throw new RuntimeException("Queue is Already Empty");
        }
    }

    public void deQueuePriority()
    {
        if (size >= 2)
        {
            if(topPriority == head)
            {
                head = topPriority.getNext();
                head.setPrev(null);
                --size;
                setTopPriority();
            }
            else if(topPriority == tail)
            {
                tail = topPriority.getPrev();
                tail.setNext(null);
                --size;
                setTopPriority();
            }
            else
            {
                ListNode next = topPriority.getNext();
                ListNode prev = topPriority.getPrev();
                prev.setNext(next);
                next.setPrev(prev);
                --size;
                setTopPriority();
            }
        }
        else if(size == 1)
        {
            head = null;
            tail = null;
            --size;
            System.out.println("Queue is now empty");
        }
        else
        {
            throw new RuntimeException("Queue is Already Empty");
        }
    }

    public void setTopPriority()
    {
        if(size == 0)
        {
            throw new RuntimeException("Queue is Empty");
        }
        else
        {
            int i = 1;
            ListNode current = head;
            while (i < size)
            {
               if (compareTo(current.getPriority(), getNodeAtPosition(i+1).getPriority()) == -1)
                {
                    topPriority = current;
                    break;
                }
                else if(compareTo(current.getPriority(), getNodeAtPosition(i+1).getPriority()) == 0)
                {
                    topPriority = current;
                    i++;
                }
                else
                {
                    current = getNodeAtPosition(i+1);
                    i++;
                }
            }
            topPriority = current;
        }
    }

    public ListNode getTopPriority(){return topPriority;}

    public int compareTo(int a, int b)
    {
        if(a < b) {return -1;}
        else if(a == b) {return 0;}
        else {return 1;}
    }

    public boolean contains(String name)
    {
        boolean contains = false;
        ListNode current = head;
        int i = 1;

        while(i <= size && !contains)
        {
            if(current.getName() != name)
            {
                current = current.getNext();
                i++;
            }
            else
            {
                System.out.println("List contains that name.");
                contains = true;
            }
        }
        System.out.println(contains);
        return contains;
    }

    public ListNode getNodeAtPosition(int i)
    {
        int itr = 1;
        ListNode ln = head;

        if(i <= 0 || i > size)
        {
            throw new RuntimeException("Queue is Empty");
        }
        while(itr < i)
        {
            ln = ln.getNext();
            itr++;
        }
        return ln;
    }

    public void display()
    {
        ListNode current = head;

        if(head == null)
        {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Printing all nodes of the doubly linked list: ");
        for(int i = 1; i <= size; i++)
        {
            System.out.println(current.getName() + " With Priority: " + current.getPriority());
            current = current.getNext();
        }
    }
}
