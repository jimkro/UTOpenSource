import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            //輸入
            String line = sc.nextLine();
            String current = line;
            //終止條件
            if(line.charAt(0)=='0') break;
            //深度
            int degree = 1;
            
            
            //迴圈直到剩下一位數看是不是'9'並輸出
            while(true){
                
                //暫存各位數相加的值
                int sum = 0;
                //判斷是不是9的倍數
                if(current.length()==1){
                    
                    if(current.charAt(0)=='9'){
                        System.out.println(line+" is a multiple of 9 and has 9-degree "+degree+".");
                        break;
                    }else{
                        System.out.println(line+" is not a multiple of 9.");
                        break;
                    }
                }
                //各位數相加
                for(int i=0;i<current.length();i++){
                    sum+=current.charAt(i)-'0';
                }
                //轉成字串帶到下一輪繼續做
                current = sum+"";
                //若已達成('9')提前輸出避免多加一次
                if(current.length()==1 && current.charAt(0)=='9'){
                    System.out.println(line+" is a multiple of 9 and has 9-degree "+degree+".");
                    break;
                }
                //深度增加
                degree++;
                
            }

        }
    }

}