import java.util.*;

public class PE {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int c = sc.nextInt();
            if (c == 0) break;
            int tEnter = sc.nextInt();
            int iEnter = sc.nextInt();
            int tExit = sc.nextInt();
            int iExit = sc.nextInt();
            n = sc.nextInt();
            String[] vehicles = new String[n];
            for (int i = 0; i < n; i++) vehicles[i] = sc.next();

            if (c == 1) FIFO(vehicles, tEnter, iEnter, tExit, iExit);
            else FILO(vehicles, tEnter, iEnter, tExit, iExit);
            System.out.println();
        }
        sc.close();
    }

    // 先進先出
    public static void FIFO(String[] vehicles, int tEnter, int iEnter, int tExit, int iExit) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += tExit;
            total -= tEnter;
            tEnter += iEnter;
            tExit += iExit;
        }

        for (String s : vehicles) System.out.println(s);
        System.out.printf("%.2f\n", (double)total / n);
    }

    // 先進後出
    public static void FILO(String[] vehicles, int tEnter, int iEnter, int tExit, int iExit) {
        int total = 0;
        tExit += (n - 1) * iExit;
        for (int i = 0; i < n; i++) {
            total += tExit;
            total -= tEnter;
            tEnter += iEnter;
            tExit -= iExit;
        }

        for (int i = n-1; i >= 0; i--) System.out.println(vehicles[i]);
        System.out.printf("%.2f\n", (double)total / n);
    }
}