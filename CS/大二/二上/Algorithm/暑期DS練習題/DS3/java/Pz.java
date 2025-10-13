import java.util.*;
public class Pz {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String str=sc.nextLine();
            if(str.equals(""))break;
            String temp=str+str;
            Set<String>s=new HashSet<>();
            int n=str.length();
            for(int i=0;i<n;i++){
                String st=temp.substring(i,i+n);
                if(!s.contains(st)){
                    System.out.print(st+" ");
                    s.add(st);
                }
            }
            System.out.println("");
        }
        sc.close();
    }
}
