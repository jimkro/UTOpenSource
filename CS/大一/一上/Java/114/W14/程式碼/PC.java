import java.util.*;

public class PC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int[] tea = new int[3];
            int[] boba = new int[3];
            for (int i = 0; i < 3; i++) {
                tea[i] = sc.nextInt();
                boba[i] = 10 - tea[i];
            }

            int currTea = 500;
            int currBoba = 500;
            int idx = 0;
            
            while (currTea > 0 && currBoba > 0) {
                currTea -= tea[idx];
                currBoba -= boba[idx];
                idx = (idx + 1) % 3;
            }

            if (currBoba <= 0 && currTea <= 0) System.out.println("Finished at the same time");
            else if (currBoba > currTea) System.out.printf("Remaining %d cc Boba\n", currBoba);
            else System.out.printf("Remaining %d cc Tea\n", currTea);
            
        }
        sc.close();
    }
}