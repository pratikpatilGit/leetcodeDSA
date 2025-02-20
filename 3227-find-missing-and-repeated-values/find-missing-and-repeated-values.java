class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
       int n  = grid.length;
       int totalElement = n * n;
       int repeated = -1;
       int missing = -1;

       HashSet<Integer> hash = new HashSet<>();
       int sum = 0;

       for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                sum += num;
                if (hash.contains(num)) {
                    repeated = num;
                } else  {
                    hash.add(num);
                }
            }
       }

       for (int i = 1; i <= totalElement; i++) {
            if (!hash.contains(i)){
                missing = i;
                break;
            }
       }

       return new int[] {repeated, missing};
    }
}