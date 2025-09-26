class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int windowAvg = 0;
        int targetSum = threshold * k;
        int count = 0;

        for (int i = 0; i < k; i++) {
            windowAvg += arr[i];
        }

        if (targetSum <= windowAvg) {
            count++;
        }

        for (int i = k; i < arr.length; i++) {
            windowAvg += arr[i] - arr[i - k];
             if (targetSum <= windowAvg) {
                 count++;
             }
        }

        return count;
    }
}