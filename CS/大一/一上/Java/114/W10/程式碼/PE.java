import java.util.*;

public class PE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if (n == 0) break;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            
            int k = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[j] == i) {
                        arr[j] = arr[k];
                        arr[k] = i;
                        k++;
                        break;
                    }
                }
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}