import java.util.*;
public class Pl {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=new String[31];
        str[0]="1";
        for(int i=1;i<=30;i++){
            String temp=str[i-1];
            int n=temp.length();
            int index=1;
            StringBuilder sb=new StringBuilder();
            for(int j=1;j<n;j++){
                if(temp.charAt(j)!=temp.charAt(j-1)){
                    sb.append(index);
                    sb.append(temp.charAt(j-1));
                    index=1;
                }
                else index++;
            }
            sb.append(index);
            sb.append(temp.charAt(n-1));
            str[i]=sb.toString();
        }
        while(sc.hasNextInt()){
             int n=sc.nextInt();
             if(n==-1)break;
             System.out.println(str[n]);
        }
        sc.close();
    }
}