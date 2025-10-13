import java.util.*;
public class Pn {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int low=sc.nextInt();
            int up=sc.nextInt();
            int target=sc.nextInt();
            int ans=1;
            if(target<low||target>up){
                System.out.println(-1);
            }
            else{
                while(low<=up){
                    int m=low+(up-low)/2;
                    if(m==target){
                        System.out.println(ans);
                        break;
                    }
                    else if(m<target)low=m+1;
                    else if(m>target)up=m-1;
                    ans++;
                }
            }
        }
        sc.close();

    }
}
