class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        if (s1.length() != s2.length()) {
            return false;
        }
        
        Map<Character, Integer> hash = new HashMap<>();
        
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            hash.put(ch, hash.getOrDefault(ch, 0) + 1);
        }
        
        
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (!hash.containsKey(ch)) {
                return false;
            }
            
            hash.put(ch, hash.get(ch) -1);
            if (hash.get(ch) < 0) {
                return false;
            }
        }
        
        for (int num : hash.values()) {
            if (num != 0) {
                return false;
            }
        }
        
        return true;
    }
}