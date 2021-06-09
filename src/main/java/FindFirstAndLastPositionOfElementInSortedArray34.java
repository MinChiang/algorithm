import java.util.Arrays;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-06-07 11:59
 */
public class FindFirstAndLastPositionOfElementInSortedArray34 {

    public int[] searchRange(int[] nums, int target) {
        // -20 -5 -4 1 2 2 2 2 2 2 2 4 6 7
        //  0  1  2  3 4 5 6 7 8 9 10111213
        int left = 0, right = nums.length - 1, mid = -1;
        boolean searchFlag = false;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // 刚好查找出来了
                searchFlag = true;
                break;
            }
        }

        if (!searchFlag) {
            return new int[0];
        }

        // 向左右两边扩散搜索
        int begin = search(nums, target, 0, mid, true);
        int end = search(nums, target, mid, nums.length - 1, false);
        return new int[]{begin, end};
    }

    private int search(int[] nums, int target, int left, int right, boolean isLeftDirect) {
        int mid = -1;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (isLeftDirect) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray34 findFirstAndLastPositionOfElementInSortedArray34 = new FindFirstAndLastPositionOfElementInSortedArray34();
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElementInSortedArray34.searchRange(new int[]{1, 2, 2, 2, 2, 2, 2, 4, 5, 6}, 2)));
    }

}
