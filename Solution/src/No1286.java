import java.util.ArrayDeque;
import java.util.Deque;

public class No1286 {
    Deque<String> combinations = new ArrayDeque<>();

    public No1286(String characters, int combinationLength) {
        int n = characters.length();
        // generate bitmasks from 0..00 to 1..11
        for (int bitmask = 0; bitmask < 1 << n; bitmask++) {
            // use bitmasks with k 1-bits
            if (Integer.bitCount(bitmask) == combinationLength) {
                // convert bitmask into combination
                // 111 --> "abc", 000 --> ""
                // 110 --> "ab", 101 --> "ac", 011 --> "bc"
                StringBuilder curr = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if ((bitmask & (1 << n - j - 1)) != 0) {
                        curr.append(characters.charAt(j));
                    }
                }
                combinations.push(curr.toString());
            }
        }
    }

    public String next() {
        return combinations.pop();
    }

    public boolean hasNext() {
        return !combinations.isEmpty();
    }
}

// Follow up: using runtime next computation rather than precomputation.
class CombinationIterator {
    String characters;
    int bitmask, n, k;

    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        this.n = characters.length();
        this.k = combinationLength;
        bitmask = (1 << n) - (1 << n-k);
    }

    public String next() {
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if ((bitmask & (1 << n - i - 1)) != 0) {
                curr.append(characters.charAt(i));
            }
        }

        bitmask--;
        while (Integer.bitCount(bitmask) != k && bitmask > 0) {
            bitmask--;
        }

        return curr.toString();
    }

    public boolean hasNext() {
        return bitmask > 0;
    }
}
