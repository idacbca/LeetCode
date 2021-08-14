public class No43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ans = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';
                ans[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            int add = ans[i] / 10;
            ans[i] = ans[i] % 10;
            ans[i - 1] += add;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if (i == 0) {
                if (ans[i] != 0) {
                    sb.append(ans[i]);
                }
            } else {
                sb.append(ans[i]);
            }
        }
        return sb.toString();
    }
}
