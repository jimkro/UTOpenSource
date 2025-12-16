import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int cases = sc.nextInt();
        int count = 1; // 記數
        while(cases--!=0){
            // 用2進位讀    
            int a = Integer.parseInt(sc.next(),2); 
            int b = Integer.parseInt(sc.next(),2);


            if(gcd(a,b)!=1){ 
                System.out.println("Pair #"+count+": All you need is love!");
            }else{ // 互質
                System.out.println("Pair #"+count+": Love is not all you need!");
            }
            count++;
        }
    }
    private static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    
}
