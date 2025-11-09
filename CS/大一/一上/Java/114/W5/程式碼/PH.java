import java.util.*;

public class PH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) break;
            int ascii = (int)(sc.next().charAt(0));
            if (ascii - 'a' + n < 0) ascii += 26;
            ascii = (ascii - 'a' + n) % 26;
            System.out.println((char) (ascii + 'a'));
        }
        sc.close();
    }
}
