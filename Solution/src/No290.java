import java.util.Map;
import java.util.HashMap;

public class No290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> charToString = new HashMap<>();
        Map<String, Character> stringToChar = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (charToString.containsKey(c) && !words[i].equals(charToString.get(c))) {
                return false;
            } else {
                charToString.put(c, words[i]);
            }
            if (stringToChar.containsKey(words[i]) && c != stringToChar.get(words[i])) {
                return false;
            } else {
                stringToChar.put(words[i], c);
            }
        }
        return true;
    }
}
