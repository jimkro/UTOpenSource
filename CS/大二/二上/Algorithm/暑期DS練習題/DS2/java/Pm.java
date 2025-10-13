import java.util.*;
public class Pm {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int ca=1;
        while(sc.hasNextInt()){
             int n=sc.nextInt();
             int limit=sc.nextInt();
             if(n==-1)break;
             int ans=1;
             int copy=n;
             while(n!=1&&n<=limit){
                if(n%2==1){
                    n=n*3+1;
                }
                else{
                    n=n/2;
                }
                ans++;
             }
            if(n>limit)ans--;
            System.out.println("Case "+ca+":"+" K = "+copy+", limit = "+limit+", number of terms = "+ans);
            ca++;
        }
        sc.close();
    }
}
