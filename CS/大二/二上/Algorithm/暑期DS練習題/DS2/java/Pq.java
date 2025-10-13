import java.util.*;
public class Pq {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int board=sc.nextInt();
            int poster=sc.nextInt();
            int right=0,left=0;
            int height[]=new int[board];
            int wid[]=new int[poster];
            for(int i=0;i<board;i++){
                height[i]=sc.nextInt();
                if(height[i]>right)right=height[i];
            }
            for(int i=0;i<poster;i++){
                wid[i]=sc.nextInt();
            }
            int ans=0;
            while(left<=right){
                int m=left+(right-left)/2;
                if(good(height,wid,m)){
                    ans=m;
                    left=m+1;
                }
                else{
                    right=m-1;
                }
            }
            System.out.println(ans);
        }
    }
    private static boolean good(int h[],int w[],int target){
        int i=0;
        int index=0;
        if(w.length==0)return true;
        for(int b:h){
            if(b>=target){
                index++;
            }
            else index=0;
            if(i<w.length&&index>=w[i]){
                index=0;
                i++;
            }
            if(i==w.length)return true;
        }
        return false;
    }
}
