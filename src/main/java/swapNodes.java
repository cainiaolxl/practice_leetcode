package main.java;

/**
 * Created by lxl on 17/11/13.
 * 本题要点:
 *   1、直接在链表内部对两个节点进行对调
 *   2、设置pre前置指针是为了方便对pre后的两个节点交换
 *   3、此题本种解法超时,另外还有一种递归的解法
 */
class ListNode13 {
    int val;
    ListNode13 next;
    ListNode13(int x){
        val = x;
    }
}
public class swapNodes {
    public static ListNode13 swap(ListNode13 head) {
        if (head == null) {
            return null;
        }
        //length==1
        if (head.next == null) {
            return head;
        }
        ListNode13 fakehead = new ListNode13(-1);
        fakehead.next = head;
        ListNode13 p1 = head;
        ListNode13 p2 = head.next;
        ListNode13 pre = fakehead;
        while(p1!=null&&p2!=null){
            pre.next = p2;
            ListNode13 t = p2.next;
            p2.next = p1;
            pre = p1;
            p1.next = t;
            p1 = t;
            if(t!=null){
                p2 = t.next;
            }

        }
        return fakehead.next;

    }


    public static void main(String[] args){
        ListNode13 qq = new ListNode13(1);
        ListNode13 qq1 = new ListNode13(2);
        ListNode13 qq2 = new ListNode13(3);
        ListNode13 qq3 = new ListNode13(4);
        qq.next = qq1;
        qq1.next =qq2;
        qq2.next = qq3;
        ListNode13 res = swap(qq);
        while(res!=null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
}
