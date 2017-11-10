package main.java;
import java.util.PriorityQueue;

/**
 * Created by lxl on 17/11/10.
 * 本题是合并N个有序集合的第二种解法,采用的方法是用java内部独特的类PriorityQueue
 *     1、这个类底层采用堆的数据结构实现,并且是大顶堆或者小顶堆(自己设置)
 *     2、按照小顶堆,每次将对头元素取出放入一个列表中即可,等堆中元素全部取完即可得到一个有序的集合序列
 *     3、这个类是泛型集合类,能够保存实现了实现了Comparable接口的类对象
 *     4、需要注意的是重写compareTo这个方法中,当当前对象小于、等于、大于指定对象分别返回负数,零,正数,以此来实现小顶堆,实现大
 *        顶堆则反之
 */
class ListNode12 implements Comparable<ListNode12>{
    int val;
    ListNode12 next;
    ListNode12(int x){
        val = x;
    }

    @Override
    public int compareTo(ListNode12 o){
        if(val < o.val){
            return -1;
        }else if(val ==o.val){
            return 0;
        }else{
            return 1;
        }
    }

}
public class Merge_K_sorted_lists2 {

    public static ListNode12 mergeKLists(ListNode12[] lists){
        int len = lists.length;
        if(lists==null||lists.length==0){
            return null;
        }
        if(len==1){
            return lists[0];
        }

        PriorityQueue<ListNode12> PQ = new PriorityQueue<ListNode12>();
        ListNode12 head = new ListNode12(-1);
        ListNode12 p = head;

        //遍历整个lists,将其入PriorityQueue
        for(ListNode12 ee :lists){
            if(ee!=null){
                PQ.offer(ee);
            }
        }

        //当PriorityQueue不为空时,一个一个取出
        while(!(PQ.isEmpty())){
            ListNode12 temp = PQ.poll();
            p.next = temp;
            p = p.next;
            if(temp.next!=null){
                PQ.offer(temp.next);
            }
        }
        return head.next;

    }

    public static void main(String[] args){
        ListNode12 nn0 = new ListNode12(2);
        ListNode12 nn1 = new ListNode12(4);
        ListNode12 nn2 = new ListNode12(6);
        nn0.next = nn1;
        nn1.next = nn2;

        ListNode12 nn3 = new ListNode12(1);
        ListNode12 nn4 = new ListNode12(3);
        ListNode12 nn5 = new ListNode12(5);
        ListNode12 nn6 = new ListNode12(7);
        nn3.next = nn4;
        nn4.next = nn5;
        nn5.next = nn6;

        ListNode12[] lists = {nn0,nn3};
        ListNode12 res = mergeKLists(lists);

        while(res!=null){
            System.out.print(res.val+" ");
            res =res.next;
        }

    }
}
