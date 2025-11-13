import java.util.*;

public class PD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int[] arr = new int[s.length()];

            // 將英文轉成數字並換 n-1 補數
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) arr[i] = (n-1) - (s.charAt(i) - '0');
                else {
                    arr[i] = (n-1) - (s.charAt(i) - 'A' + 10);
                }
            }

            // 處理 >9 的數字
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (arr[i] >= 10) ans.append((char)(arr[i] - 10 + 'A'));
                else ans.append(arr[i] + "");
            }

            if (k == n-1) System.out.println(ans.toString());
            else System.out.println(add(arr, n));
        }
        sc.close();
    }

    // 換 n 補數
    public static String add(int[] arr, int n) {
        List<Integer> list = new ArrayList<>();
        // 記錄進位
        int curr = 1;

        // 處理 +1
        int i = arr.length-1;
        while (i >= 0) {
            int now = arr[i] + curr;
            list.add(now % n);
            curr = now / n;
            i--;
        }

        StringBuilder sb = new StringBuilder();
        // 處理進位
        if (curr > 0) sb.append(curr);
        
        for (int j = list.size()-1; j >= 0; j--) {
            if (list.get(j) >= 0 && list.get(j) <= 9) sb.append(list.get(j));
            else {
                sb.append((char)(list.get(j) - 10 + 'A'));
            }
        }
        
        return sb.toString();
    }
}