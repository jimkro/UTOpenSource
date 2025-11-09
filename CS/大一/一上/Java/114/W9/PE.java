import java.util.*;

public class PE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-->0) {
            String s1 = sc.nextLine();
            String[] s = s1.split(" ");
            int maxCount = 0, count = 0, sum = 0;
            for (String a : s) {
                int now = Integer.parseInt(a);
                if (now + sum < 0) {
                    maxCount = Math.max(maxCount, count);
                    count = 0;
                    sum = 0;
                } else {
                    count++;
                    sum += now;
                }
            }
            maxCount = Math.max(maxCount, count);
            System.out.println(maxCount);
        }
        sc.close();
    }
}