package cpe;

import java.util.*;

public class e561trainswapping1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        for (int i = 1; i <= cases; i++) {
            int n = s.nextInt();
            int[] train = new int[n];
            for (int j = 0; j < n; j++) {
                train[j] = s.nextInt();
            }
            int temp = 0;
            int count = 0;
            for (int k = n - 1; k > 0; k--) {
                for (int m = 0; m < n - 1; m++) {
                    if (train[m] > train[m + 1]) {
                        temp = train[m + 1];
                        train[m + 1] = train[m];
                        train[m] = temp;
                        count++;
                    }
                }
            }
            System.out.println("Optimal train swapping takes " + count + " swaps.");
        }
        s.close();
    }

}
