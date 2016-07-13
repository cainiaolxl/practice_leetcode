package main.java;

/**
 * Created by lxl on 16/7/12.
 * 本题的要点:
 *   1、题目的大概意思是通过集合的下标i以及对应的index[i]作垂直于x轴的线段,然后随机在这些线段中找一条线，再找一条别的线段，同本条垂直与x
 *     轴的线段以及x轴围成一个封闭图形，求所能围成图形的最大面积
 *   2、要求面积，只能想到长方形的面积是最大的，故只要找出它们中面积最大的，即为结果
 *   3、第一种想到的解法即为二重循环(穷举),但是暴力不出来，出现tle
 *   4、第二中解法采用了类似贪心的思想,两边设置一个指针,由于长方形的面积取决于它的短边，故面积为(right-left)*min(height[left],height[right])
 *   5、最后一点需要注意左右指针的移动,当height[left]<height[right]时,left++,因为当height[left]<height[right]时,right-1,right-2,...
 *      它们同height[left]组成的面积永远要小于height[left],height[right],right,left组成的面积(贪心的思想）
 *
 *
 */
public class container_with_most_water {
    //暴力解法，时间复杂度o(n2)
//    public static int maxArea(int [] height){
//        int area=0;
//        for(int i=0;i<height.length;++i) {
//            int left = i;
//            for (int j = i + 1; j < height.length; ++j) {
//                int right = j;
//                int sum = 0;
//                sum = (right - left) * min(height[left], height[right]);
//                if (sum > area) {
//                    area = sum;
//                }
//            }
//        }
//        return area;
//    }
//    public static int min(int a,int b){
//        return (a<b?a:b);
//    }

    public static int maxArea(int[] height) {
        int area = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int sum = 0;
            sum = (right - left) * min(height[left], height[right]);
            if (sum > area) {
                area = sum;
            }
            //
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return area;
    }
        public static int min(int a,int b) {
            return (a < b ? a : b);
        }



    public static void main(String[] args){
        int[] height={1,2,4,3,6,5};
        System.out.println(maxArea(height));
    }

}
