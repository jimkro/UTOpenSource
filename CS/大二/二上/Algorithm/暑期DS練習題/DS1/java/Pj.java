import java.util.*;
public class Pj {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long power[]=new long[26];
        power[0]=1;
        for(int i=1;i<=25;i++){
            power[i]=power[i-1]*2;
        }
        while(sc.hasNextInt()){
            int m=sc.nextInt();
            int n=sc.nextInt();
            long ans=(power[n]-1)*m;
            System.out.println(ans);
        }
        sc.close();
    }
}
