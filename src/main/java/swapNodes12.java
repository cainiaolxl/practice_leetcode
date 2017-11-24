package main.java;

/**
 * Created by lxl on 17/11/24.
 *  本题解法:
 *    1、本题采用递归方法;
 *    2、递归的思路:
 *       将第三个节点作为下一次递归的参数,用其去两两交换;不断递归下去,直到从最后一对节点开始交换;
 *       将第一个节点指向递归返回的结果,并将temp节点指向第一个节点;
 *    3、递归出口的判断:
 *       这里分为链表长度为奇数还是偶数的情况,若为奇数则只剩一个节点不用交换,直接返回该节点即可;若为偶数,则递归出口返回值正好为NUll,即
 *       剩余节点数为0;
 */
class ListNode15{
    int val;
    ListNode15 next;
    ListNode15(int x){
        val =x;
    }
}
public class swapNodes12 {
    public static ListNode15 swapNodes(ListNode15 head){
        //递归的出口
        if(head==null||head.next==null){
            return head;
        }
        //当前节点指向当前头节点的下一个节点
        ListNode15 temp = head.next;
        head.next = swapNodes(temp.next);
        temp.next = head;
        return temp;

    }
    public static void main(String[] args){
        ListNode15 ll = new ListNode15(1);
        ListNode15 ll1 = new ListNode15(2);
        ListNode15 ll2 = new ListNode15(3);
        ListNode15 ll3 = new ListNode15(4);
        ll.next = ll1;
        ll1.next = ll2;
        ll2.next = ll3;
        ListNode15 res = swapNodes(ll);
        while(res!=null){
            System.out.print(res.val+" ");
            res = res.next;
        }

    }
}
