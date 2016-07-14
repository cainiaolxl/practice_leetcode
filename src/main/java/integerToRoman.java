package main.java;

/**
 * Created by lxl on 16/7/13.
 * 本题的要点:
 *   1、由于题目所限制的数字范围比较小，所以用比较笨的方法，列出了所有代表的数字
 *   2、熟悉下罗马字符中I,V,X,L,C,D,M所代表的数字
 *   3、String二维数组的形式及其初始化要注意里面的花括号
 *   4、注意String s=null和String s=""的区别
 */
public class integerToRoman {
    public static String intToRoman(int num){
        //数字范围是到3999,所以千位写到3000
        String[][] dict={{"","I","II","III","IV","V","VI","VII","VIII","IX"},
                         {"","X","XX","XXX","IL","L","LX","LXX","LXXX","XC"},
                         {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                         {"","M","MM","MMM"}
                        };
        int row=0;
        String result="";
        while(num>0){
            int number = num%10;
            result = dict[row][number]+result;
            row++;
            num/=10;
        }
        return result;

    }

    public static void main(String[] args){
        int num=3999;
        System.out.println(intToRoman(num));
    }
}
