import java.util.*;

public class PG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int l = sc.nextInt();
            if (l == 0) break;
            int[] arr = new int[l];
            for (int i = 0; i < l; i++) arr[i] = sc.nextInt();
            for (int i = l-2; i >= 0; i--) {
                arr[i] = arr[i+1] + arr[i];
            }

            for (int i = 0; i < l; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}




















// int[] arr = new int[l];














