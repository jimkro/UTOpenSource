import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            char[] arr1 = sc.nextLine().toCharArray();
            char[] arr2 = sc.nextLine().toCharArray();
            // 排序後比較方便查
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            // 存結果
            StringBuilder sb = new StringBuilder();
            // 找共同字元
            int i = 0;
            int j = 0;
            while(i<arr1.length && j<arr2.length){
                if(arr1[i]<arr2[j]) i++;
                else if(arr1[i]==arr2[j]){
                    sb.append(arr1[i]);
                    i++;
                    j++;
                }else{
                    j++;
                }
            }
            // 輸出
            System.out.println(sb.toString());
        }
    }
}
