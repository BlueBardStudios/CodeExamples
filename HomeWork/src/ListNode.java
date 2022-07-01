import java.util.List;

public class ListNode {

    private String name;
    private ListNode next;
    private ListNode prev;
    private int priority;

    public ListNode(String na, ListNode n, ListNode p, int i)
    {
        name = na;
        priority = i;
        next = n;
        prev = p;
    }

    public String getName() {return name;}

    public void setName(String n){name = n;}

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int i) {priority = i;}

    public ListNode getNext()
    {
        return next;
    }

    public void setNext(ListNode ln)
    {
        next = ln;
    }

    public ListNode getPrev()
    {
        return prev;
    }

    public void setPrev(ListNode ln)
    {
        prev = ln;
    }


}
