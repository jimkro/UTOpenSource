import java.util.*;
public class Pk {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
             int n=sc.nextInt();
             int ans=1;
             while(n!=1){
                if(n%2==1){
                    n=n*3+1;
                }
                else{
                    n=n/2;
                }
                ans++;
             }
             System.out.println(ans);
        }
        sc.close();

    }
}
