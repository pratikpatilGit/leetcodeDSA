class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double windowAvg = 0;
        double maxAverage = 0;

        for (int i = 0; i < k; i++) {
            windowAvg += nums[i];
        }

        maxAverage = windowAvg;

        for (int i = k; i < nums.length; i++) {
            windowAvg += nums[i] - nums[i - k];
            maxAverage = Math.max(maxAverage, windowAvg);
        }

        return maxAverage/k;
    }
}