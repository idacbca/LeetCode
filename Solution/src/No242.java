public class No242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }
        for (char ch : t.toCharArray()) {
            if (--freq[ch-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
