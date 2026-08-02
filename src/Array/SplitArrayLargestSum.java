package Array;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int n : nums) {
            left = Math.max(n, left);
            right += n;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int splits = getSplits(nums, k, mid);

            if (splits > k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public int getSplits(int[] nums, int k, int max) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > max) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 2, 5, 10, 8 };
        int k = 2;

        System.out.println(new SplitArrayLargestSum().splitArray(arr, k));
    }
}
