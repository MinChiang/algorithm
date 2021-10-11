package com.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-06-08 7:56
 */
public class BinaryWatch401 {

    // 0 - 3 表示为小时
    // 4 - 9 表示为分钟
    int[] times = new int[]{8, 4, 2, 1, 32, 16, 8, 4, 2, 1};

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList();
        backtrack(turnedOn, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int count, List<Integer> selectedIndex, List<String> result) {
        int hour = calcHour(selectedIndex);
        int minutes = calcMinutes(selectedIndex);
        if (count == 0) {
            result.add(format(hour, minutes));
            return;
        }
        // 做选择
        int lastIndex = selectedIndex.isEmpty() ? -1 : selectedIndex.get(selectedIndex.size() - 1);
        for (int i = lastIndex + 1; i < times.length; i++) {
            if ((i <= 3 && (hour + times[i]) > 11) || (i >= 4 && (minutes + times[i]) > 59)) {
                // 这些情况是不可能的
                continue;
            }
            selectedIndex.add(i);
            backtrack(count - 1, selectedIndex, result);
            selectedIndex.remove(selectedIndex.size() - 1);
        }
    }

    private int calcHour(List<Integer> selectedIndex) {
        int hs = 0;
        for (Integer index : selectedIndex) {
            if (index <= 3) {
                hs += times[index];
            }
        }
        return hs;
    }

    private int calcMinutes(List<Integer> selectedIndex) {
        int ms = 0;
        for (Integer index : selectedIndex) {
            if (index >= 4) {
                ms += times[index];
            }
        }
        return ms;
    }

    private String format(int hs, int ms) {
        return hs + ":" + (ms < 10 ? ("0" + ms) : ms);
    }

    public static void main(String[] args) {
        BinaryWatch401 binaryWatch401 = new BinaryWatch401();
        System.out.println(binaryWatch401.readBinaryWatch(11));
    }

}
