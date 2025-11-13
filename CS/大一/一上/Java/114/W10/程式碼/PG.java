import java.util.*;

public class PG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            String s1 = sc.next();
            String s2 = sc.next();
            int[] alpha1 = new int[26];
            int[] alpha2 = new int[26];
            for (char c : s1.toCharArray()) alpha1[c-'A']++;
            for (char c : s2.toCharArray()) alpha2[c-'A']++;

            int count1 = 1, count2 = 1;
            for (int i : alpha1) {
                if (i != 0) count1 *= (i+1);
            }

            for (int i : alpha2) {
                if (i != 0) count2 *= (i+1);
            }

            if (count1 == count2) System.out.println("Draw");
            else if (count1 > count2) System.out.println("Player 1");
            else System.out.println("Player 2");
        }
        sc.close();
    }
}