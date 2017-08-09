package main.java;

/**
 * Created by lxl on 17/6/21.
 * 本体要点：
 *     1、用进栈出栈的思想来解题;
 *     2、小地方需要注意:栈顶指针为0才可表明本次表达式符号是匹配的
 *                     指针会出现负数的情况,若为负数需要归0
 *
 */
public class Valid_partentheses {

    public static boolean isValid(String s){
        //结果不需要标记也行
        //boolean result = false;
        int length = s.length();
        if((length%2)!=0){
            return false;
        }
        char[] arr1 = s.toCharArray();
        //char数组的初始化
        char[] arr2 = new char[length];
        int mark = 0;
        for(int i=0;i<length;++i){
            if(mark<0) mark=0;
            //遇到{,(,[执行进栈操作
            if((arr1[i]=='{')||(arr1[i]=='(')||(arr1[i]=='[')){
                arr2[mark] = arr1[i];
                mark++;
            }

            //遇到},),]操作则进行匹配
            if((arr1[i]=='}')||(arr1[i]==')')||(arr1[i]==']')){
                if(mark==0) return false;
                if(arr1[i]=='}'){
                    //如果匹配成功
                    if(arr2[mark-1]=='{'){
                        //result = true;
                        mark--;
                    }else{
                        //result = false;
                        break;
                    }
                }

                if(arr1[i]==')'){
                    if(arr2[mark-1]=='('){
                        //result = true;
                        mark--;
                    }else{
                        //result = false;
                        break;
                    }
                }

                if(arr1[i]==']'){
                    if(arr2[mark-1]=='['){
                        //result = true;
                        mark--;
                    }else{
                        //result = false;
                        break;
                    }
                }
            }
        }
        //特别注意
        if(mark==0){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args){
        String s = "(()(";
        boolean r = isValid(s);
        System.out.print(r);

    }
}
