package 一星題.必考49題.P45_SummingDigits;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            //用String存以避免大數
            String line = sc.nextLine();
            if(line.charAt(0)=='0'){ //字串不能用 line=="0" 來運算 要用line.equals("0")
                break;
            }
            System.out.println(DigitsSum(line));

            
        }
    }

    private static String DigitsSum(String line){

        int sum = 0;

        //算位數和
        for(char c:line.toCharArray()){
            sum += c-'0'; //要把char轉int要 -'0'
        }

        if(sum/10==0){
            return sum+"";
        }

        return DigitsSum(sum+"");
    }
}
