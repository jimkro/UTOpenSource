import java.util.*;
public class Pd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int num=sc.nextInt();
            StringBuilder sb=new StringBuilder();
            while(num>0){
                if((num&1)==1)sb.append(1);
                else sb.append(0);
                num>>=1;
            }
            String bin=sb.reverse().toString();
            int n=sb.length();
            String a1="",a2="";
            if(n/2>8){
                int start=Math.max((n/2-8)/2,0);
                a1=bin.substring(start,start+8);
                a2=bin.substring(n/2+start,n/2+start+8);
            }
            else{
                a1=bin.substring(0,n/2);
                a2=bin.substring(n/2,n);
            }
            String b1="",b2="",b3="";
            if(n/3>0){
                int start2=Math.max((n/3-8)/3,0);
                b1=bin.substring(start2,start2+8);
                b2=bin.substring(start2+n/3,start2+n/3+8);
                b3=bin.substring(start2+2*n/3,start2+2*n/3+8);
            }
            else{
                int start2=Math.max((n/3-8)/3,0);
                b1=bin.substring(0,n/3);
                b2=bin.substring(n/3,2*n/3);
                b3=bin.substring(2*n/3,n);

            }
            int num1=Integer.parseInt(a1,2);
            int num2=Integer.parseInt(a2,2);
            int num3=Integer.parseInt(b1,2);
            int num4=Integer.parseInt(b2,2);
            int num5=Integer.parseInt(b3,2);
            int h1=num1^num2;
            int h2=(num3^num5)^num4;
            System.out.println(h1+" "+h2);
        }
        sc.close();
    }
}
