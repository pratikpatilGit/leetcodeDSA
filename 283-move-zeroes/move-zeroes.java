class Solution {
    public void moveZeroes(int[] nums) {
        int lastzero = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[lastzero];
                nums[lastzero] = nums[i];
                nums[i] = temp;

                lastzero++; 
            }
        }
    }
}