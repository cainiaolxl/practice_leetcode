package main.java;

/**
 * Created by lxl on 16/7/8.
 *   这道题的坑点:
 *   1、首先负数的'-'号要算进去，也就是负数不算回文;
 *   2、int型的数据要转换成String型会比较好解决问题;
 *   3、注意左右两个指针的变化,右指针因为写成right-left-1而报错;
 *   4、String的valueOf方法要注意;
 *   5、该题有另一种简单的方法，利用回文数字的对称性;
 *
 *
 */
public class judge_palindrome {
    //常规的做法
//    public static boolean isPalindrome(int number) {
//        boolean mark = true;
//        if(number==0){
//            return true;
//        }
//        String s = String.valueOf(number);
//        int left = 0, right = s.length()-1;
//        while (left < (s.length() / 2)) {
//            if (s.charAt(left) != s.charAt(right)) {
//                mark = false;
//                break;
//            }
//            left++;
//            right--;
//        }
//        return mark;
//    }
    //简单做法
    public static boolean isPalindrome(int num){
        if(num<0){
            return false;
        }
        int res=0;
        int temp=num;
        while(temp>0){
            res=res*10+temp%10;
            temp/=10;
        }
        if(res==num){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        int number=1001;
        System.out.println(isPalindrome(number));
    }

}
