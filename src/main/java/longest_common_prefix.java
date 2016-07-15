package main.java;

/**
 * Created by lxl on 16/7/14.
 * 这道题的要点:
 *   1、求字符串数组中最大的公共前缀
 *   2、首先要求出最短的那个字符串的长度
 *   3、注意特殊情况,即长度为0，或者长度为1时的返回值
 */
public class longest_common_prefix {
    public static String longestCommonPrefix(String[] strs){
        if(strs.length==1){
            return strs[0].toString();
        }
        String res="";
        if(strs.length==0){
            return res;
        }
        for(int i=0;i<min_length(strs);++i){
            char ch=strs[0].charAt(i);
            boolean mark=true;
            for(int j=0;j<strs.length;++j){
                if(ch!=strs[j].charAt(i)){
                    mark=false;
                    break;
                }
            }
            if(mark){
                res+=ch;
            }else{
                break;
            }
        }
        return res;
    }
    //寻找自俯冲数组中最小长度的字符串
    public static int min_length(String[] strs){
        int short_length=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;++i){
            if(short_length>strs[i].length()){
                short_length = strs[i].length();
            }
        }
        return short_length;
    }
    public static void main(String[] args){
        String[] strs ={};
        System.out.println(longestCommonPrefix(strs));
    }
}
