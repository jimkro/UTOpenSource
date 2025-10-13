import java.util.*;
public class Po {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int ca=1;
        while(sc.hasNextInt()){
            int target=sc.nextInt();
            if(target<0)break;
            int temp=1;
            int ans=0;
            while(temp<target){
                temp<<=1;
                ans++;
            }
            System.out.println("Case "+ca+": "+ans);
            ca++;
        }
        sc.close();
    }
}