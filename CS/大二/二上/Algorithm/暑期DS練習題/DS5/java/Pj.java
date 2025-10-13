import java.util.*;
public class Pj {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            int children[][]=new int[n+1][2];
            for(int i=1;i<=n;i++){
                children[i][0]=sc.nextInt();
                children[i][1]=sc.nextInt();
            }
            Queue<Integer>q=new LinkedList<>();
            q.offer(1);
            int depth=0;
            while(!q.isEmpty()){
                int size=q.size();
                depth++;
                for(int i=0;i<size;i++){
                    int cur=q.poll();
                    if(children[cur][0]!=0) q.offer(children[cur][0]);
                    if(children[cur][1]!=0) q.offer(children[cur][1]);
                }
            }
            System.out.println(depth);
        }
    }
}