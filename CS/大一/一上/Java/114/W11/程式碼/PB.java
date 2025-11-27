import java.util.*;

public class PB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            String s = sc.next();
            int total = check(s);
            if (total % 13 == 0) System.out.println(total + " YES");
            else System.out.println(total + " NO");
        }
        sc.close();
    }

    // 算總和
    public static int check(String s) {
        // 存切下來的數字
        List<Integer> list = new ArrayList<>();
        int j = s.length();
        while (j >= 3) {
            String s1 = s.substring(j-3, j);
            list.add(Integer.parseInt(s1));
            j -= 3;
        }

        // 處理字串長度不是3的倍數的情況
        if (j > 0) {
            String s1 = s.substring(0, j);
            list.add(Integer.parseInt(s1));
        }

        // 算總和 一加一減
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) total += list.get(i);
            else total -= list.get(i);
        }

        return Math.abs(total);
    }
}