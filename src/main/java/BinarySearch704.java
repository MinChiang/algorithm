/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-06-07 11:37
 */
public class BinarySearch704 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch704 binarySearch704 = new BinarySearch704();
        System.out.println(binarySearch704.search(new int[]{-1, 0, 3, 5, 9, 12}, 4));
    }

}
