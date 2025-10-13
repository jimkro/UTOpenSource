import java.util.*;
public class Pr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int m=sc.nextInt();
            int n=sc.nextInt();
            int shop[]=new int[m];
            int expect[]=new int[n];
            for(int i=0;i<m;i++){
                shop[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                expect[i]=sc.nextInt();
            }
            Arrays.sort(shop);
            long total = 0;
            for (int i=0;i<n;i++) {
                total+=bs(shop,expect[i]);
        }
        System.out.println(total);
        }
        sc.close();
    }
    private static int bs(int shop[],int expect){
        int left=0,right=shop.length-1;
        int res=-1;
        while(left<=right){
            int m=left+(right-left)/2;
            if(shop[m]>=expect){
                res=shop[m];
                right=m-1;
            }
            else{
                left=m+1;
            }
        }
        return res==-1?0:res;
    }
}

