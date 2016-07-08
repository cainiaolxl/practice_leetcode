package main.java;

/**
 * Created by lxl on 16/7/8.
 *   这道题的要点：
 *   1、首先负数的'-'号要算进去，也就是负数不算回文;
 *   2、int型的数据要转换成String型会比较好解决问题;
 *   3、注意左右两个指针的变化,右指针因为写成right-left-1而报错
 *
 *
 */
public class judge_palindrome {
    public static boolean isPalindrome(int number) {
        boolean mark = true;
        if(number==0){
            return true;
        }
        String s = String.valueOf(number);
        int left = 0, right = s.length()-1;
        while (left < (s.length() / 2)) {
            if (s.charAt(left) != s.charAt(right)) {
                mark = false;
                break;
            }
            left++;
            right--;
        }
        return mark;
    }

    public static void main(String[] args){
        int number=1000021;
        System.out.println(isPalindrome(number));
    }

}
