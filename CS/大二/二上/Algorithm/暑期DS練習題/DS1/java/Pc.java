import java.util.*;
class Pc{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            int stra[]=new int[2];
            int strb[]=new int[2];
            String a=sc.next();
            String b=sc.next();
            int n=a.length(),index=0;
            for(int i=0;i<n;i++){
                if(index<2&&a.charAt(i)!=b.charAt(i)){
                    stra[index]=a.charAt(i);
                    strb[index++]=b.charAt(i);
                }
            }
            if(index==0)System.out.println("True");
            else if(index!=2)System.out.println("False");
            else{
                if(stra[0]==strb[1]&&stra[1]==strb[0])System.out.println("True");
                else System.out.println("False");
            }
        }
        sc.close();
    }
}