import java.util.*;

public class PC_cmp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] arr = new String[m];
            for (int i = 0; i < m; i++) arr[i] = sc.next();

            Arrays.sort(arr, (m1, m2) -> {
                int count1 = count(m1);
                int count2 = count(m2);
                return count1 - count2;
            });

            for (int i = 0; i < m; i++) {
                System.out.println(arr[i]);
            }
        }
        sc.close();
    }

    public static int count(String s) {
        int count = 0;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) > s.charAt(j)) count++;
            }
        }
        return count;
    }
}