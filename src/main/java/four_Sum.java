package main.java;

/**
 * Created by lxl on 16/8/20.
 *
 * 本题要点：
 *
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class four_Sum {

    public static List<List<Integer>> fourSum(int[] nums,int target){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0){
            return res;
        }
        //排序数组
        Arrays.sort(nums);

        for(int i=nums.length-1;i>2;i--) {
            List<List<Integer>> curRes = threeSum(nums, i - 1, target - nums[i]);
            for (int j = 0; j < curRes.size(); ++j) {
                curRes.get(j).add(nums[i]);
            }
            res.addAll(curRes);
        }
        return res;

    }

    //求三个数字之和
    public static List<List<Integer>> threeSum(int[] nums,int index,int target){
        List<List<Integer>> Res = new ArrayList<List<Integer>>();
        for(int i=index;i>1;--i){
            if(i==index||nums[i]!=nums[i+1]){
                List<List<Integer>> curRes = twoSum(nums,i-1,target-nums[i]);
                for(int j=0;j<curRes.size();++j){
                    curRes.get(j).add(nums[i]);
                }
                Res.addAll(curRes);
            }
        }
        return Res;
    }

    //求两个数字之和
    public static List<List<Integer>> twoSum(int[] nums,int rear,int target){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int l=0;
        int r=rear;
        while(l<r){
            if((nums[l]+nums[r])==target){
                List<Integer> localR = new ArrayList<Integer>();
                localR.add(nums[l]);
                localR.add(nums[r]);
                res.add(localR);
                l++;
                r--;
                //关键之处
                while(l<r&&nums[r]==nums[r+1]) r--;
                while(l<r&&nums[l]==nums[l-1]) l++;
            }
            else if((nums[l]+nums[r])>target){
                r--;
            }
            else{
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums={1,0,-1,0,-2,2};
        int target=0;
        List<List<Integer>> res = fourSum(nums,target);
        for(List<Integer> item:res){
            for(Integer i:item){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}
