import java.util.*;

public class PC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            for (int i = 0; i < s.length(); i+=3) {
                int total = 0;
                
                // 三進位轉十進位
                for (int j = i; j < i+3; j++) {
                    total = total * 3 + (s.charAt(j) - 'A');
                }

                // 空白另外處理
                if (total == 26) System.out.print(" ");
                else System.out.print((char)(total + 'a'));
            }
            System.out.println();
        }
        sc.close();
    }
}