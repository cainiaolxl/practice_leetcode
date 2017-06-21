package main.java;

/**
 * Created by lxl on 17/6/2.
 * 本题要点：
 *      1、注意n>length这种情况的处理
 *      2、注意删除单链表收尾的情况
 */
public class removeNthNode {

    public static void main(String[] args){

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = n1;
        ListNode result = removeNthFromEnd(n1,1);
        while(result!=null){
            System.out.print(result.value+" ");
            result =result.next;
        }




    }


    public static ListNode removeNthFromEnd(ListNode head,int n){
        int length = getLength(head);
        if(length>n){
            int interval = length-n;
            ListNode p = head;
            ListNode q = head;
            for(int i=0;i<interval;++i){
                q=p;
                p = p.next;
            }
            if(p.next==null){
                q.next = null;
                return head;
            }else {
                q.next = p.next;
                return head;
            }
        }else{
            n =n%length;
            if(n==0){
                head = head.next;
                return head;
            }
            int interval = length-n;
            ListNode p = head;
            ListNode q = head;
            for(int i=0;i<interval;++i){
                q=p;
                p = p.next;
            }
            if(p.next==null){
                q.next = null;
                return head;
            }else {
                q.next = p.next;
                return head;
            }
        }

    }

    //求单链表长度
    public static int getLength(ListNode p){
        int length=0;
        while(p!=null){
            p=p.next;
            length++;
        }
        return length;
    }
}


/*定义一个单链表的节点*/
class ListNode{
    int value;
    ListNode next;
    ListNode(int x){
        value = x;
    }
}


