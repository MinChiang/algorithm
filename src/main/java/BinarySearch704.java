/**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-06-07 11:37
 */
public class BinarySearch704 {

    /**
     * 写法1
     * [left, right]
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 写法2
     * [left, right)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 扩展：查询对应的数组左边界
     * [left, right)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search3(int[] nums, int target) {
        int left = 0, right = nums.length, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * 扩展：查询对应的数组左边界
     * [left, right]
     *
     * @param nums
     * @param target
     * @return
     */
    public int search4(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        BinarySearch704 binarySearch704 = new BinarySearch704();
        System.out.println("search : " + binarySearch704.search(new int[]{-1, 0, 3, 5, 9, 12}, 5));
        System.out.println("search2 : " + binarySearch704.search2(new int[]{6, 8, 9, 12, 44, 100, 234}, 44));
        System.out.println("search3 : " + binarySearch704.search3(new int[]{6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9}, 10));
    }

}
