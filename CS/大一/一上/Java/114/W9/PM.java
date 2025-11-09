import java.util.*;

public class PM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int d = sc.nextInt();
            if (d == -1) break;
            int l = sc.nextInt();
            int a = sc.nextInt();
            int s = sc.nextInt();

            int maxNum = Math.max(Math.max(d, l), Math.max(a, s));
            int minNum = Math.min(Math.min(d, l), Math.min(a, s));
            
            if (maxNum-minNum <= 25 && d+l+a+s >= 350) System.out.println("In");
            else System.out.println("Nah");
        }
        sc.close();
    }
}