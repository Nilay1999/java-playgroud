package Array;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 1, 2 };
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(arr));
    }
}
