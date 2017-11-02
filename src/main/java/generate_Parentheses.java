package main.java;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by lxl on 17/8/10.
 * 本题需要考虑的点:
 *     1、用递归回溯的思路,关键是找到临界条件
 *
 */
public class generate_Parentheses {

    /*
     left和right代表应当并入当前结果的左右括号数量;
     当left>right时,表示右括号的数量大于左边的括号,这种情况应该不并入结果;
     比较理想的情况是左边的括号全部进入当前结果,然后随着进入右括号;或者是当前情况下有左边括号进入时,保证右括号也进入当前结果;
     临界条件的选择:
         1、右括号的数量大于左括号的数量,即left>right,这种情况应该结束当前递归;
         2、当left==right==0,找到当前一组解,并入结果集,并结束;
    */
    public static List<String> BackTrace(List<String> result, String s, int left, int right) {
        if (left > right) {
            return null;
        }

        if ((left == 0) && (right == 0)) {
            result.add(s);
            return result;
        }

        if (left > 0) {
            BackTrace(result, s + "(", left - 1, right);
        }

        if (right > 0) {
            BackTrace(result, s + ")", left, right - 1);
        }

        return result;

    }

    public static List<String> generateParentensis(int n){
        List<String> res = new ArrayList<String>();
        BackTrace(res,"",n,n);
        return res;
    }

    public static void main(String[] args){
        int target =2;
        List<String> rr = new ArrayList<String>();
        rr = generateParentensis(target);
        for(String tt : rr){
            System.out.println(tt);
        }
    }
}


