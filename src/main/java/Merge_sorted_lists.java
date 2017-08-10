package main.java;

/**
 * Created by lxl on 17/8/9.
 * 本题要点:
 *    1、注意l1或者l2为空的情况
 *    2、注意这题重复的情况,需要把重复的情况考虑进去
 */

class ListNode2{
    int val;
    ListNode2 next;
    ListNode2(int x){
        val = x;
    }
}
public class Merge_sorted_lists {

    public static ListNode2 mergeTwoLists(ListNode2 l1,ListNode2 l2){
        if(l1==null&&l2==null){
            return null;
        }
        if(l1==null&&l2!=null){
            return l2;
        }
        if(l1!=null&&l2==null){
            return l1;
        }

        //指向新节点的表头
        ListNode2 n;
        //指向l1
        ListNode2 p;
        //指向l2
        ListNode2 q;

        if(l1.val<=l2.val){
            n = l1;
            l1 = l1.next;
            n.next = null;
        }else{
            n = l2;
            l2 = l2.next;
            n.next = null;
        }
        //p = l1;
        //q = l2;
        ListNode2 nn = n;
        while(l1!=null&&l2!=null){
            //关键部分
            if(l1.val<l2.val){
                p = l1;
                l1 = l1.next;
                nn.next = p;
                //永远指向表尾节点
                nn = nn.next;
            }else if(l1.val>l2.val){
                q = l2;
                l2 = l2.next;
                nn.next = q;
                nn = nn.next;
            }else{
                //两个节点的值相等
                p = l1;
                l1 = l1.next;
                nn.next = p;
                nn = nn.next;

                q = l2;
                l2 = l2.next;
                nn.next = q;
                nn = nn.next;

            }
        }
        while(l1!=null){
            p = l1;
            l1 = l1.next;
            nn.next = p;
            nn = nn.next;
        }

        while(l2!=null){
            q = l2;
            l2 = l2.next;
            nn.next = q;
            nn = nn.next;
        }
        return n;
    }

    public static void main(String[] args){
        ListNode2 t1 = new ListNode2(1);
        ListNode2 t2 = new ListNode2(1);
        t1.next = t2;
        t2.next = null;

        ListNode2 tt1 = new ListNode2(1);
        ListNode2 tt2 = new ListNode2(1);
        ListNode2 tt3 = new ListNode2(1);
        tt1.next = tt2;
        tt2.next = tt3;
        tt3.next = null;

        ListNode2 n = mergeTwoLists(t1,tt1);
        while(n!=null){
            System.out.print(n.val+" ");
            n = n.next;
        }
    }
}
