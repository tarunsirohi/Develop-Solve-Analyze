import java.util.Arrays;

public class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums); // Step 1: Sort the array
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = lowerBound(nums, i + 1, nums.length - 1, lower - nums[i]);
            int right = upperBound(nums, i + 1, nums.length - 1, upper - nums[i]);
            count += (right - left);
        }

        return count;
    }

    // Find the first index where nums[index] >= value
    private int lowerBound(int[] nums, int start, int end, int value) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    // Find the first index where nums[index] > value
    private int upperBound(int[] nums, int start, int end, int value) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
