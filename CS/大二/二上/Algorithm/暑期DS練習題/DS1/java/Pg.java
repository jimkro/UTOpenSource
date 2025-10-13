import java.util.*;
class Pg{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String str=sc.next();
            int index=1,ans=0;
            for(char c:str.toCharArray()){
                if(c=='O'){
                    ans+=index;
                    index++;
                }
                else{
                    index=1;
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}