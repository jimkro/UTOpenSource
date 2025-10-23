package 一星題.必考49題.P8_FunnyEncryptionMethod;

import java.util.*;

public class Best {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        while(cases--!=0) {
            //輸入
            String str = sc.nextLine();

            //計算b1
            int N = Integer.parseInt(str, 10); //把字串轉成10進位int
            String str_10_Binary = Integer.toBinaryString(N); //把10進位int轉成2進位字串
            int b1 = count(str_10_Binary); //計算1的數量
            
            //計算b2
            int N1 = Integer.parseInt(str, 16); //把字串轉成16進位int
            String str_16_Binary = Integer.toBinaryString(N1); //把16進位int轉成2進位字串
            int b2 = count(str_16_Binary); //計算1的數量

            System.out.println(b1 + " " + b2);
        }

        sc.close();
    }

    //計算1的數量
    private static int count(String str) {
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
}