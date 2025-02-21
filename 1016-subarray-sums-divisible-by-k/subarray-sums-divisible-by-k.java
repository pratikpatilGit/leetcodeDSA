class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);

        int currsum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            currsum += nums[i];
            int remainder = currsum % k;

            if (remainder < 0) {
                remainder += k;
            }

            if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
                remainderCount.put(remainder, remainderCount.get(remainder) + 1);
            } else {
                remainderCount.put(remainder, 1);
            }
        }
        return count;
    }
}