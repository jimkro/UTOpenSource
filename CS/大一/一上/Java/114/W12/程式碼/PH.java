import java.util.*;

public class PH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = sc.nextInt();

        // 排序 方便找中位數
        Arrays.sort(arr);

        if (arr[2] - arr[0] < 10) System.out.println("final " + arr[1]);
        else System.out.println("check again");

        sc.close();
    }
}