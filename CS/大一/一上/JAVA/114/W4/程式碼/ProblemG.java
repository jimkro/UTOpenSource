import java.util.*;

public class ProblemG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int minNum = 0, maxNum = 0;
            int d = sc.nextInt();
            if (d == -1)
                break;
            int l = sc.nextInt();
            maxNum = Math.max(d, l);
            minNum = Math.min(d, l);
            int a = sc.nextInt();
            maxNum = Math.max(maxNum, a);
            minNum = Math.min(minNum, a);
            int s = sc.nextInt();
            maxNum = Math.max(maxNum, s);
            minNum = Math.min(minNum, s);
            if (maxNum - minNum > 25)
                System.out.println("Nah");
            else if (d + l + a + s >= 350)
                System.out.println("In");
            else
                System.out.println("Nah");
        }
        sc.close();
    }
}
