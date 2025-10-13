import java.util.*;
class Pf{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int v=sc.nextInt();
            int e=sc.nextInt();
            int start=sc.nextInt();
            List<List<int[]>> relation=new ArrayList<>();
            for(int i=0;i<=v;i++){
                relation.add(new ArrayList<>());
            }
            for(int i=0;i<e;i++){
                int v1=sc.nextInt();
                int v2=sc.nextInt();
                int value=sc.nextInt();
                relation.get(v1).add(new int[]{v2,value});
                relation.get(v2).add(new int[]{v1,value});
            }
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]);
            pq.add(new int[]{start,0});
            int best[]=new int[v+1];
            Arrays.fill(best,Integer.MAX_VALUE);
            best[start]=0;
            while(!pq.isEmpty()){
                int cur[]=pq.poll();
                int node=cur[0],value=cur[1];
                for(int nextNode[]:relation.get(node)){
                    int next=nextNode[0],newValue=nextNode[1]+value;
                    if(newValue<best[next]){
                        best[next]=newValue;
                        pq.add(new int[]{next, newValue});
                    }
                }
            }
            for(int i=1;i<=v;i++){
                System.out.print(best[i]+" ");
            }
            System.out.println("");
        }
        sc.close();
    }
}