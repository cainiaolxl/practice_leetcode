package main.java;

/**
 * Created by lxl on 16/7/19.
 * 这道题的坑点：
 *     1、首先注意digits==null||digits的长度为0这种特殊情况
 *     2、这道题的思路跟树的深度有限遍历很想，仔细体会其递归过程，注意递归出口的判断为index==digits.length(),
 *        尤其注意digits有几位,就需要有几个字符的组合,所以tmp这个数组的长度为digits.length()
 *     3、注意new String(char[] tmp)这个方法,String内部有这个构造方法
 *
 *
 *
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class letter_combinations {
    public static List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<String>();

        Map<Character,String> map = new HashMap<Character, String>();
        map.put('0',"");
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if(digits==null||digits.length()==0){
            return res;
        }

        char[] temp = new char[digits.length()];//确定组合有多少位数，遍历一棵数一样
        getResult(digits, 0, temp, map, res);
        return res;

    }

    public static void getResult(String digits,int index,char[] temp,Map<Character,String> map,List<String> res){
        if(index==digits.length()){
            res.add(new String(temp));
            return;
        }
        for(int i=0;i<map.get(digits.charAt(index)).length();++i){
            temp[index] = map.get(digits.charAt(index)).charAt(i);
            getResult(digits,index+1,temp,map,res);
        }
    }

    public static void main(String[] args){
        String digits = "234";
        List<String> r = letterCombinations(digits);
        for(String s:r){
            System.out.println(s);
        }
    }
}
