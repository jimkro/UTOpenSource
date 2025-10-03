package w7;

import java.util.*;

public class practicemethodbubblesort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        for (int j = 1; j <= cases; j++) {
            int n = s.nextInt();
            int[] bubble = new int[n];
            for (int i = 0; i < n; i++) {
                bubble[i] = s.nextInt();
            }
            int result = bubblesort(bubble);
            System.out.println("Optimal train swapping takes " + result + " swaps.");
        }
        s.close();
    }

    public static int bubblesort(int[] sorts) {
        int result;
        int n = sorts.length;
        int count = 0;
        int tmp = 0;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < n - 1; j++) {
                if (sorts[j] > sorts[j + 1]) {
                    tmp = sorts[j];
                    sorts[j] = sorts[j + 1];
                    sorts[j + 1] = tmp;
                    count++;

                }

            }

        }
        result = count;
        return result;
    }
}