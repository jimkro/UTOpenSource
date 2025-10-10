import java.util.*;
class pg{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int low=sc.nextInt();
            int high=sc.nextInt();
            if(low>high){
                int ans=0;
                for(int i=high;i<=low;i++){
                    ans=Math.max(ans,cnt(i));
                }
                System.out.println(low+" "+high+" "+ans);
            }else{
                int ans=0;
                for(int i=low;i<=high;i++){
                    ans=Math.max(ans,cnt(i));
                }
                System.out.println(low+" "+high+" "+ans);

            }
            
        }
    }
    private static int cnt(int n){
        int cycle=1;
        while(n!=1){
            if(n%2==0)n/=2;
            else n=n*3+1;
            cycle++;
        }
        return cycle;
    }
}