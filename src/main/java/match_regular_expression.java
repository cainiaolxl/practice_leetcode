package main.java;

/**
 * Created by lxl on 16/7/11.
 *
 *  本题的要点:
 *      1、首先采用递归的思想，即将一个大问题转换为小问题;
 *      2、关键点在于对'*'号的匹配，即查看当前字符的下一个字符是否为'*';
 *      3、如果当前字符的下一个字符是'*',就要循环遍历s.substring(1)同p.substring(2)是否相等，一旦相等就返回true,如果遇到不等的
 *         情况,则需要判断当前的s与p.substring(2)是否相等，用递归的方式处理;
 *      4、如果当前字符的下一个字符不是'*',在s.length()大于0的情况下首先考虑p的当前字符是否为'.',不然考虑当前的s字符同p字符是否相等
 *         以及s,p的剩余字符是否相等;
 *      5、剩下两种特殊的情况，一种当p为0时,考虑s的长度是否为0; 当p的长度为1时,考虑当前p的字符是否为'.',若为点则考虑s当前的长度是否为1;
 *         不然则查看s与p的当前字符是否相等
 *
 *
 *
 */
public class match_regular_expression {
    public static boolean isMatch(String s,String p){
        if(p.length()==0){
            return (s.length()==0);
        }
        //如果p.length()==1
        if(p.length()==1){
            if(p.charAt(0)=='.'){
                return (s.length()==1);
            }
            else{
                return (p.equals(s));
            }
        }
        //
        if(p.charAt(1)!='*'){
            if(s.length()>0){
                if(p.charAt(0)=='.'){
                    return isMatch(s.substring(1),p.substring(1));
                }
                else{
                    return (s.charAt(0)==p.charAt(0)&&isMatch(s.substring(1),p.substring(1)));
                }
            }
            else
                return false;
        }
        else{
            while(s.length()>0&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.')){
                if(isMatch(s,p.substring(2))){
                    return true;
                }
                s=s.substring(1);
            }
            return isMatch(s,p.substring(2));
        }


    }

    public static void main(String[] args){
        String s="aaa";
        String p="aa*";
        System.out.println(isMatch(s,p));
    }

}
