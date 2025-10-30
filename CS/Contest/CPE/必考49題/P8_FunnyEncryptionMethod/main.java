package 一星題.必考49題.P8_FunnyEncryptionMethod;
import java.util.*;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt(); //測資數量

        //逐筆接收資料
        while(cases--!=0){
            int N = sc.nextInt();
            System.out.println(D10ToD2get1(N)+" "+D16ToD2get1(N));
        }

        
    }

    //十進位轉二進位後返回1的數量
    public static int D10ToD2get1(int x1) {
        int result = 0;

        //利用StringBuilder來建立二進位字串
        StringBuilder sb = new StringBuilder();

        //十進位轉二進位
        while(x1!=0){
            sb.append(x1%2);
            x1 /= 2;
        }

        //計算二進位中1的數量
        for(char c:sb.toString().toCharArray()){
            if(c=='1'){
                result++;
            }
        }

        return result;
    }

    //十六進位轉二進位後返回1的數量
    public static int D16ToD2get1(int x1) {

        int D10 = 0; //十進位的x1
        int times = 0; //16的次方數

        //十六進位十轉進位
        while(x1!=0){
            D10 += (x1%10) * Math.pow(16,times);
            x1 /= 10;
            times++;
        }

        //直接用上面寫好的方法回傳十進位轉二進位後1的數量
        return D10ToD2get1(D10);
    }

}
