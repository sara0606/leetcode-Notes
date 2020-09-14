package com.training.org.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明:
 *
 * @author kz
 * @date 2020/6/13 23:31
 * <p>
 * <br>UpdateNote:
 * <br>UpdateTime:
 * <br>UpdateUser:
 */
public class LeetCode5423 {

    public int minSumOfLengths(int[] arr, int tar) {

        List<Pair> list = new ArrayList<>();

        int[] sums = new int[arr.length];

        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            sums[i] = sum;
        }

        for(int i = 0; i < arr.length; i++){

            for(int j = i; j < arr.length; j++){
                int rt = sums[arr.length - 1] - sums[j];
                int lf = i == 0 ? 0 : sums[i - 1];
                int cur = sums[arr.length - 1] - lf - rt;
                if(cur == tar){
                    list.add(new Pair(i, j));
                }else if(cur > tar){
                    break;
                }
            }
        }

        if(list.size() < 2) {
            return -1;
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < list.size() - 1; i++){
            for(int j = i + 1; j < list.size(); j++){
                Pair lf = list.get(i);
                Pair rt = list.get(j);
                if(lf.rt < rt.lf){
                    ans = Math.min(ans, lf.length() + rt.length());
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    static class Pair{
        int lf;
        int rt;

        Pair(int lf, int rt){
            this.lf = lf;
            this.rt = rt;
        }

        int length(){
            return rt - lf + 1;
        }
    }
}
