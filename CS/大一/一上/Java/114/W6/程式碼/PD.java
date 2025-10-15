import java.util.*;

public class PD  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String ans = "";
        for (int i = 0; i < s.length(); i+=2) {
            String binary = s.substring(i, i+2);
            ans += (char)(Integer.parseInt(binary, 2) + 'A');
        }
        System.out.println(ans);
        
        sc.close();
    }
}