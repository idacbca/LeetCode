public class No342 {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0b10101010101010101010101010101010) == 0;
    }
}
