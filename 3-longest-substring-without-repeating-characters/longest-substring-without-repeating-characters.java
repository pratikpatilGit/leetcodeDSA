class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int maxLength = 0;

        int charMap[] = new int[128];

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            left = Math.max(left, charMap[ch]);
            charMap[ch] = right + 1;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}