// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0; // left pointer of the window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (map.containsKey(currentChar)) {
                // Move the left pointer to the right of the previous index of currentChar
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update or add the current character's index
            map.put(currentChar, right);

            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}