package main.java;

/**
 * Created by lxl on 16/7/18.
 * 这道题的坑点:
 *      1、基本的思路和3three相同
 *      2、注意left,right指针的移动
 *      3、这道题算closestDis最好不要采用Math.abs这个函数,容易出现错误;最直接的方式就是比较哪个大，然后相减就OK
 *      4、由于数组是有序的,所以当temp_sum>target意味着数字太大,要往小取,right--;当temp_sum<target时，意味着要往大取,从而left++
 *      5、被这道题坑了太久,好好理解下left,right指针的左右移动
 *
 */
import java.util.Arrays;
import java.util.Map;

public class three_Sum_closest {

    public static int threeSumClosest(int[] nums,int target) {
        //***排好序的数组***
        Arrays.sort(nums);
        int length = nums.length;
        int res=Integer.MAX_VALUE;
        int dis=Integer.MAX_VALUE;
        for(int i=0;i<length-2;++i){
            int left=i+1;
            int right=length-1;
            while(left<right){
                int temp_sum=nums[i]+nums[left]+nums[right];

                if(temp_sum>target){
                    if(dis>(temp_sum-target)){
                        dis=temp_sum-target;
                        res=temp_sum;
                    }
                    right--;
                }
                if(temp_sum<target){
                    if(dis>(target-temp_sum)){
                        dis=target-temp_sum;
                        res=temp_sum;
                    }
                    left++;
                }
                if(temp_sum==target){
                    res=temp_sum;
                    return res;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums={-1,-1,1,1,3};
        int target=-1;
        System.out.println(threeSumClosest(nums,target));
    }
}

