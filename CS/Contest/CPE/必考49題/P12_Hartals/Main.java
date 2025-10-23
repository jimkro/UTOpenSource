package 一星題.必考49題.P12_Hartals;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lost = 0; //損失的工作天數量
        int testCases = sc.nextInt();
        while (testCases--!=0) { 
            int days = sc.nextInt(); //模擬天數
            int partys = sc.nextInt(); //政黨數量
            int[] partys_data = new int[partys]; //罷會週期

            //紀錄各政黨的罷會週期
            for(int i=0;i<partys;i++){
                partys_data[i] = sc.nextInt();
            }
            //逐日模擬
            for(int day=1;day<=days;day++){
                //各個政黨
                for(int eachParty=0;eachParty<partys;eachParty++){
                    //是政黨的週期且非假日
                    if(day%partys_data[eachParty]==0 && day%7 != 6 && day%7 != 0){
                        lost++; //紀錄損失的天數
                        break; //若一天已有罷會則直接跳過該天避免不同政黨重複計算
                    }
                }
            }

            //輸出
            System.out.println(lost);
            
            //重製lost
            lost = 0;
        }
    }
    
}
