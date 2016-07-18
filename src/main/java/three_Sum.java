package main.java;

/**
 * Created by lxl on 16/7/15.
 * 这道题的要点:
 *     1、首先需要注意List<List<Integer>> res = new ArrayList<List<Integer>>()这种一张大表里嵌套了几张小表的写法,尤其注意实现的方
 *        式，由于List是接口，所有外层由ArrayList来实现，但内层还是List<Integer>,同时不要忘记括号
 *     2、本道题如果用暴力穷举，复杂度为O(n3),会超时,所以降低其复杂度
 *     3、关键思路:
 *               1)、首先使用Arrays工具类对数组进行排序,复杂度为O(nlogn),略小于O(n2)
 *               2)、固定一个数，然后从中找出两个数，所以循环遍历到本数组长度的length－2的前一位，因为要找两个数，必须确保剩余的数组中有
 *                   两个数
 *               3)、使用两个数组，一个指向头部，一个指向尾部，然后比较三个数的和是否为0,若为0，则加入;如果小于0,则left++;大于0，则right--;
 *               4)、中间寻找的过程中注意寻在相同数字的情况，它们可以直接略去
 *     4、注意Arrays类和Array的区别
 *     5、注意List内的一些方法,比如add方法,比如get方法等
 *     6、这种题目是一个系列，注意区别比较
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class three_Sum {
    static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static List<List<Integer>> threeSum(int[] nums){

        if(nums==null||nums.length<3){
            return res;
        }
        //给数组排序
        Arrays.sort(nums);
        int length = nums.length;
        for(int i=0;i<length-2;++i){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            findthreenumber(nums,i+1,length-1,nums[i]);
        }
        return res;
    }
    public static void findthreenumber(int[] nums,int begin,int end,int target){
        int left=begin;
        int right=end;
        //List<Integer> answer = new ArrayList<Integer>();
        while(left<right){
            if(nums[left]+nums[right]+target==0){
                //***关键***,注意这个写在这里的原因，只有找到一组新的解，才生成一个list
                List<Integer> answer = new ArrayList<Integer>();
                answer.add(target);
                answer.add(nums[left]);
                answer.add(nums[right]);
                //加入结果集中
                res.add(answer);
                //去重
                while(left<right&&(nums[left]==nums[left+1])) left++;
                while(left<right&&(nums[right]==nums[right-1])) right--;
                left++;
                right--;
            }else if(nums[left]+nums[right]+target<0){
                left++;
            }else{
                right--;
            }
        }
    }

    public static void main(String[] args){
        int[] nums={-1, 0, 1, 2, -1, -4};
        //threeSum(nums);
        for(List<Integer> meizu :threeSum(nums)){
            for(Integer meige:meizu){
                System.out.print(meige+",");
                System.out.print(" ");

            }
            System.out.println();
        }
    }
}
