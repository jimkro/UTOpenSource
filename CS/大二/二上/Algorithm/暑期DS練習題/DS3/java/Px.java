import java.util.*;
public class Px {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String date=sc.next();
            String[]dateParts=date.split("/");
            int d=Integer.parseInt(dateParts[0]);
            int n=sc.nextInt();
            sc.nextLine();
            String str[]=sc.nextLine().split(" ");
            Set <Integer>s=new HashSet<>();
            for(String st:str){
                if(st.equals(""))break;
                s.add(Integer.parseInt(st));
            }
            int ans=0,index=0;
            Set <Integer>called=new HashSet<>();
            while(index<8){
                if(!s.contains(d)&&!called.contains(d)){
                    index++;
                    System.out.print(d+" ");
                    called.add(d);
                    int orid=d;
                    d=d+10;
                    if(d>n)d=(d-1)%10+1;
                    if(called.contains(d)){
                        d=orid+1;
                    }
                }
                else {
                    if(s.contains(d)){
                        called.add(d);
                        ans++;
                    }
                    int orid=d;
                    d=d+10;
                    if(d>n)d=(d-1)%10+1;
                    if(called.contains(d)){
                        d=orid+1;
                    }
                }
            }
            System.out.println("");
            System.out.println("Jimmy's angry number is "+ans);
        }
        sc.close();
    }
}