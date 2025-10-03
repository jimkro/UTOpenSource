package 一星題.必考49題.P36_BeatTheSpread;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //測資數
        int cases = sc.nextInt();

        while(cases--!=0){
            //輸入
            int sum = sc.nextInt();
            int gap = sc.nextInt();

            //若結果會有負數或小數則不可能
            if(sum<gap || ((sum+gap)%2==1)){
                System.out.println("impossible");
                continue;
            }
            //正常輸出
            System.out.println((sum+gap)/2 + " " + (sum-gap)/2);
        }
    }
}
