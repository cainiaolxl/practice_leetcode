package main.java;

/**
 * Created by lxl on 16/7/7.
 *   这道题几个要点：
 *   1、开头的空格都忽略不计;
 *   2、空格忽略后如果遇到'+',则默认整个结果都为正;如果遇到'－',则结果为负;
 *   3、如果忽略空格后第一个字符为'+'或者'-'号,之后第二个字符如果不是数字那么结果为0；如果之后的字符为数字，那么结果为计算到那个是数字
 *     字符的位置为止;
 *   4、sum的类型选择很重要，应该double;因为如果sum选择long,虽然是64位,可能会发生溢出，一旦溢出，符号位可能会发生变化，就有变成负数的可
 *     能
 *
 */

public class stringToInteger {

    public static int trans(String str){
        double sum=0;
        int mark=1;
        char ch;

        //字符串为空或者为null
        if(str==null||str.length()==0){
            return 0;
        }
        int i=0;
        ch=str.charAt(i);
        while(ch ==' '){
            i++;
            ch=str.charAt(i);
        }

        ch=str.charAt(i);
        if(ch=='+'){
            mark=1;
            ++i;
        }
        else if(ch=='-'){
            mark=-1;
            ++i;
        }

        for(int j=i;j<str.length();++j){
            ch = str.charAt(j);
            if(ch>='0'&&ch<='9'){
                sum=sum*10+(ch-'0');
            }
            else{
                sum=sum*mark;
                if(sum>Integer.MAX_VALUE){
                    sum=Integer.MAX_VALUE;
                }
                if(sum<Integer.MIN_VALUE){
                    sum=Integer.MIN_VALUE;
                }
                return (int)sum;
            }

        }
        sum=sum*mark;
        if(sum>Integer.MAX_VALUE){
            sum=Integer.MAX_VALUE;
        }
        if(sum<Integer.MIN_VALUE){
            sum=Integer.MIN_VALUE;
        }
        return (int)sum;

    }
    public static void main(String[] args){
        String str="9223372036854775809";
        System.out.println(trans(str));
    }
}