package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxl on 16/7/14.
 *  本题的要点:
 *    1、关于Map的基本操作熟悉一遍(put,get,....)
 *    2、本道题目比较简单，每次加罗马字母对应的数字时，判断后一个字母是否大于前一个，如果大于需要将所对应的数字相减,同时注意指针的改变
 *       反之，则只需要不断相加即可
 *    3、Map<key,value>,括号内部放基本数据类型会报错，然而当放包装类型时不再报错,即Map<key,value>这里key和value为对象
 */
public class romanToInteger {
    public static int romanToInt(String s){
        Map<Character,Integer> dict = new HashMap<Character,Integer>();
        dict.put('I',1);
        dict.put('V',5);
        dict.put('X',10);
        dict.put('L',50);
        dict.put('C',100);
        dict.put('D',500);
        dict.put('M',1000);
        int sum=0;
        for(int i=0;i<s.length();++i){
            int j=i+1;
            if(j<s.length()&&(dict.get(s.charAt(j))>dict.get(s.charAt(i)))){
                sum+=dict.get(s.charAt(j))-dict.get(s.charAt(i));
                i=j;
            }
            else{
                sum+=dict.get(s.charAt(i));
            }
        }
        return sum;

    }
    public static void main(String[] args){
        String s="MCMXCVI";
        System.out.println(romanToInt(s));
    }
}
