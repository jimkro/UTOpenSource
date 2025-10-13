import java.io.*;
import java.util.*;
public class Pn {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int len=Integer.parseInt(st.nextToken());
            String pre=st.nextToken();
            String in=st.nextToken();
            post(pre,in,sb,0,len-1,0,len-1);
            sb.append("\n");
            

        }
        System.out.println(sb);
    }
    private static void post(String pre,String in,StringBuilder sb,int preL,int preR,int inL,int inR){
        if(preL>preR) return;
        char root=pre.charAt(preL);
        int k=in.indexOf(root,inL);
        if(k==-1)return ;
        int leftSize=k-inL;
        post(pre,in,sb,preL+1,preL+leftSize,inL,k-1);
        post(pre,in,sb,preL+leftSize+1,preR,k+1,inR);
        sb.append(root);
    }
}
