package com.algorithm.leetcode.editor.cn;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-06-07 10:54
 */
public class Sqrtx69 {

    public int mySqrt(int x) {
        int left = 0, right = x, mid = -1, res;
        while (left < right) {
            mid = (right - left) / 2 + left;
            res = x / mid;
            if (mid > res) {
                // mid 太大了
                right = mid - 1;
            } else if (mid < res) {
                // mid 太小了
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        Sqrtx69 sqrtx69 = new Sqrtx69();
        System.out.println(sqrtx69.mySqrt(6));
    }

}
