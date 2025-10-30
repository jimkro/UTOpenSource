package cpe;

import java.util.*;

public class d097jollyjumpers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {

            int n = s.nextInt();
            if (n == 0) {
                break;
            }

            int[] jollyjumper = new int[n];
            for (int i = 0; i < n; i++) {
                jollyjumper[i] = s.nextInt();

            }

            ArrayList<Integer> check = new ArrayList<>();
            boolean count = true;
            for (int i = 0; i < n - 1; i++) {
                check.add(Math.abs(jollyjumper[i] - jollyjumper[i + 1]));
            }
            for (int j = 1; j <= n - 1; j++) {
                if (!check.contains(j)) {
                    count = false;
                }
            }

            if (count) {
                System.out.println("Jolly");
            } else {
                System.out.println("Not jolly");
            }

        }
        s.close();

    }

}
