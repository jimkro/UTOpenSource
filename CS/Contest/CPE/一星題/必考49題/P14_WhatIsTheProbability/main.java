package 一星題.必考49題.P14_WhatIsTheProbability;
import java.util.*;
public class main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //接收測資數量
        int testCases = sc.nextInt();
        //逐一跑每筆資料
        while(testCases--!=0){
            //接收資料
            int players = sc.nextInt(); //玩家數量
            double p = sc.nextDouble(); //成功機率
            int number = sc.nextInt();  //玩家編號
            double a1 = Math.pow(1-p,number-1) * p; //第一次勝利的機率(先輸number-1次再贏1次)
            double r = Math.pow(1-p,players); //計算公比r
            double ans = a1/(1-r);
            //輸出
            System.out.println(String.format("%.4f", ans)); //取小數點後4位的方法 記好

        }
    }
    
}
