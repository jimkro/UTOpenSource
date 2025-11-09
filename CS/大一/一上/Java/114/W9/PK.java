import java.util.*;

public class PK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            int[] alpha = new int[26];
            for (char c : s.toCharArray()) alpha[c-'a']++;
            int idx = -1;
            for (int i = 0; i < s.length(); i++) {
                if (alpha[s.charAt(i)-'a'] == 1) {
                    idx = i;
                    break;
                }
            }
            System.out.println(idx);
        }
        sc.close();
    }
}