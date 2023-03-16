package com.example.csa_jsandvue;

import java.util.HashMap;

public class algorithm {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums,k));
        System.out.println(subarraySum2(nums, k));
    }
    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int cnt = 0;
        for (int i = 0;i<len;i++){
            int sum = 0;
            /**
             * 从下到达遍历 复杂度高
             * */
//            for (int j = i;j<len;j++){
//                while (true){
//                    if(j==len)
//                        break;
//                    sum += nums[j];
//                    if (sum==k){
//                        cnt++;
//                        break;
//                    }
//                    if(sum>k){
//                        break;
//                    }
//                    j++;
//                }
//            }
            /**
             * 从下到上遍历 降低复杂度
             * */
            for (int j = i;j>=0;j--){
                sum += nums[j];
                if(sum==k){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    //前缀和加哈希表 copy
    public static int subarraySum2(int[] nums, int k) {
        int cnt = 0,pre = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0;i< nums.length;i++){
            pre += nums[i];
            if (map.containsKey(pre-k)){
                cnt += map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return cnt;
    }
}
