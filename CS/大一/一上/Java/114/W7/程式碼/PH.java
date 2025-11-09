import java.util.*;

public class PH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next();
            String b = sc.next();
            int first = toDec(a);
            int second = toDec(b);
            System.out.println(first + ":" + second);
        }
        sc.close();
    }

    public static int toDec(String s) {
        int sum = 0, two = 1;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '1') sum += two;
            two *= 2;
        }
        return sum;
    }
}