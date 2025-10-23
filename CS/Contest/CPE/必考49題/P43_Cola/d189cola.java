package cpe;
import java.util.*;
public class d189cola {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNextInt()){
            int n=s.nextInt();
            int k=n;
            int a=0;
            int b=0;
            int count=0;
            while(k>=3){
                a=k/3;
                if(a>0){
                    b=k%3;
                    if(a==2&b==2){
                        b+=1;
                        k=a+b;
                        count+=a;
                    }  
                    else{
                        k=a+b;
                        count+=a;
                    }
                }else{
                    break;
                    
                }
                     
            }
            if(k==2){
                count+=1;
            }   
            System.out.println(n+count);

        }
        s.close();
        
    }
    
}
