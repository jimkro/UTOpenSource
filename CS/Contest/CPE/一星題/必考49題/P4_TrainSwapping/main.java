package 一星題.必考49題.P4_TrainSwapping;
import java.util.*;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
    
        while(cases--!=0){

            int trainLength = sc.nextInt();
            
            //解長度是0的特殊狀況
            if(trainLength==0){
                System.out.println("Optimal train swapping takes 0 swaps.");
            }
            //建立train陣列
            int[] train = new int[trainLength];

            //將順序存為陣列
            for(int i=0;i<trainLength;i++){
                train[i] = sc.nextInt();
            }
            //output
            System.out.println("Optimal train swapping takes "+bubbleSort(train)+" swaps.");

        }
    }
    
    //計算交換次數的方法(bubbleSort)
    public static int bubbleSort(int[] sorts){
        int result = 0;
        int top = sorts.length;
        while(top!=1){
            for(int i=1;i<top;i++){
                if(sorts[i-1]>sorts[i]){
                    result++;
                    int temp = sorts[i-1];
                    sorts[i-1] = sorts[i];
                    sorts[i] = temp;
                }
            }
            top--;
        }
        
        return result;
    }
    
}
