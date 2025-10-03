//2024.10.9週三下午 費時50分鐘，於圖書館完成 #偏簡單
import java.util.*;
public class Q9_PrimaryArithmetic{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String temp = sc.nextLine();
            if(temp.equals("0 0")){
                break;
            }
            String[] t = temp.split(" ");
            

            //對齊兩數的長度，較短的數字前面補0
            StringBuilder pad = new StringBuilder();
            if(t[0].length() > t[1].length()){ //左大
                
                for(int p=0; p<(t[0].length() - t[1].length()); p++){
                    pad.append("0");
                } 
                //t[1] = ("0").repeat(t[0].length() - t[1].length()) + t[1];
                t[1] = pad.toString() + t[1];
            }else if(t[0].length() < t[1].length()){ //右大
                for(int p=0; p<(t[1].length() - t[0].length()); p++){
                    pad.append("0");
                } 
                //t[0] = ("0").repeat(t[1].length() - t[0].length()) + t[0];
                t[0] = pad.toString() + t[0];
            }
            //System.out.println(t[0] + " " + t[1]);/* test message */

            //相加兩數，紀錄times
            int times = 0;
            
            int prePlus = 0;
            for(int i=t[0].length()-1; i>=0; i--){
                //System.out.println("inside for loop!");/* test message */
                int a = (int)t[0].charAt(i) - 48; 
                int b = (int)t[1].charAt(i) - 48; // a, b分別代表兩數字的「當前位數」
                //System.out.println("a,b,prePlus: " + a + "," +b + "," + prePlus);/* test message */

                if(a + b + prePlus >= 10){
                    times++;
                    //System.out.println("times+1!");/* test message */
                    prePlus = 1;
                }else{
                    prePlus = 0;
                }
            }
            if(times == 0){
                System.out.println("No carry operation.");
            }else if(times == 1){
                System.out.println(times + " carry operation.");
            }else{
                System.out.println(times + " carry operations.");
            }
            
        }   
    }
}