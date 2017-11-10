package main.java;
import java.util.PriorityQueue;

/**
 * Created by lxl on 17/8/21.
 * 本题有两种方法,一种是用二分法,另一种是用Java中的特殊队列PriorityQueue实现。
 *     1、采用二分法,两两合并链表,直至剩下一个最终的链表;
 *     2、采用二分法解该题时需要注意边界条件
 */

class ListNode11{
    int val;
    ListNode11 next;
    ListNode11(int x){
        val = x;
    }
}

public class Merge_K_sorted_lists {

    public static ListNode11 mergeKLists(ListNode11[] lists){
        int len = lists.length;
        if(lists==null||lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        while(len >1){
            //二分要合并的组的序号
            int mid = (len+1)/2;
            for(int i=0;i<len/2;++i){
                lists[i] = mergeList(lists[i],lists[i+mid]);
            }
            //随着列表的两两合并,其长度也在不断变化
            len = mid;
        }
        return lists[0];

    }

    public static ListNode11 mergeList(ListNode11 n1,ListNode11 n2){
        if(n1 ==null) return n2;
        if(n2 ==null) return n1;

        ListNode11 head = new ListNode11(-1);
        ListNode11 p = head;

        while(n1!=null&&n2!=null){
            if(n1.val<=n2.val){
                p.next = n1;
                n1 = n1.next;
                p = p.next;

            }else{
                p.next = n2;
                n2 =n2.next;
                p = p.next;
            }
        }
        if(n1!=null) p.next=n1;
        if(n2!=null) p.next=n2;
        return head.next;

    }

    public static void main(String[] args){
        ListNode11 nn0 = new ListNode11(3);
        ListNode11 nn1 = new ListNode11(6);
        ListNode11 nn2 = new ListNode11(8);
        nn0.next = nn1;
        nn1.next = nn2;

        ListNode11 nn3 = new ListNode11(2);
        ListNode11 nn4 = new ListNode11(4);
        ListNode11 nn5 = new ListNode11(7);
        nn3.next = nn4;
        nn4.next = nn5;

        ListNode11[] lists = {nn0,nn3};

        ListNode11 res = mergeKLists(lists);

        while(res!=null){
            System.out.print(res.val + " ");
            res = res.next;
        }

    }

}
