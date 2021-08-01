import java.util.Map;
import java.util.HashMap;

public class No383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            freq.put(magazine.charAt(i), freq.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!freq.containsKey(ransomNote.charAt(i)) || freq.get(ransomNote.charAt(i)) == 0) {
                return false;
            } else {
                freq.put(ransomNote.charAt(i), freq.get(ransomNote.charAt(i)) - 1);
            }
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] charFreq = new int[26];
        for (char ch : magazine.toCharArray()) {
            charFreq[ch-'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            if (--charFreq[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
