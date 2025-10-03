package 一星題.必考49題.P10_JollyJumpers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet set = new HashSet();

        while(sc.hasNextInt()){
            //測資數量
            int cases = sc.nextInt();
            int[] data = new int[cases];

            //輸入
            for(int i = 0;i<cases;i++){
                data[i] = sc.nextInt();
            }

            for(int i = 1;i<cases;i++){
                set.add(Math.abs(data[i]-data[i-1]));
            }

            if(setcheck(set)){
                System.out.println("Jolly");
            }else{
                System.out.println("Not jolly");
            }
        }
        
    }

    private static boolean setcheck(HashSet set){
        for(int i=1;i<=set.size();i++){
            if(!set.contains(i)){
                return false;
            }
        }
        return true;  
    }
    
}
