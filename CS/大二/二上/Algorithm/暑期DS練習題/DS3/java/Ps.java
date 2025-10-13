import java.util.*;
public class Ps {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String str=sc.nextLine();
            int n=str.length();
            boolean yaa=true;
            for(int i=1;i<n;i++){
                if(n%i==0){
                    List<String>li=new ArrayList<>();
                    for(int j=0;j<n;j+=i){
                        li.add(str.substring(j,j+i));
                    }
                    Collections.sort(li);
                    StringBuilder sb=new StringBuilder();
                    for(String s:li){
                        sb.append(s);
                    }
                    if(!sb.toString().equals(str)){
                        System.out.println(sb.toString());
                        yaa=false;
                    }
                }
            }
            if(yaa)System.out.println("orz");
        }
        sc.close();
    }
}
