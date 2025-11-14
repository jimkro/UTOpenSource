import java.util.*;

public class PC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] arr = new String[m];
            for (int i = 0; i < m; i++) arr[i] = sc.next();

            int[] count = new int[m];
            for (int k = 0; k < m; k++) {
                int cnt = 0;
                for (int i = 0; i < n-1; i++) {
                    for (int j = i+1; j < n; j++) {
                        if (arr[k].charAt(i) > arr[k].charAt(j)) cnt++;
                    }
                }
                count[k] = cnt;
            }

            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < m-i-1; j++) {
                    if (count[j] > count[j+1]) {
                        int tmp = count[j];
                        count[j] = count[j+1];
                        count[j+1] = tmp;

                        String s = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = s;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                System.out.println(arr[i]);
            }
        }
        sc.close();
    }
}