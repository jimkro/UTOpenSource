import java.util.*;
public class Pm {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String arr[]=sc.nextLine().trim().split("\\s+");
            int n=sc.nextInt();
            sc.nextLine();
            Map<String,Character>strToalp=new HashMap<>();
            Map<Character,String>alpTostr=new HashMap<>();
            for(int i=0;i<arr.length;i++){
                char c=arr[i].charAt(0);
                if(Character.isLetter(c)){
                    int temp=i+1;
                    StringBuilder sb=new StringBuilder();
                    while(temp>1){
                        sb.append(temp%2);
                        temp/=2;
                    }
                    strToalp.put(sb.reverse().toString(),c);
                    alpTostr.put(c,sb.toString());
                }
            }
            while(n-->0){
            String pass=sc.nextLine();
            if(Character.isLetter(pass.charAt(0))){
                int len=pass.length();
                for(int i=0;i<len;i++){
                    char ch=pass.charAt(i);
                    System.out.print(alpTostr.get(ch)+"");
                }
                System.out.println("");
            }
            else{
                int k=0;
                StringBuilder sb=new StringBuilder();
                while(k<pass.length()){
                    char c=pass.charAt(k);
                    sb.append(c);
                    if(!strToalp.containsKey(sb.toString())){
                        k++;
                    }
                    else{
                        System.out.print(strToalp.get(sb.toString())+"");
                        k++;
                        sb.setLength(0);
                    }
                }
                System.out.println("");
            }
        }
        }
    }
}
