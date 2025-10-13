import java.util.*;
class pf{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int V=sc.nextInt();
            int E=sc.nextInt();
            if(V==0)break;
            List<List<Integer>>relation=new ArrayList<>();
            for(int i=0;i<=V;i++){
                relation.add(new ArrayList<>());
            }
            for(int i=0;i<E;i++){
                int v1=sc.nextInt();
                int v2=sc.nextInt();
                relation.get(v1).add(v2);
                relation.get(v2).add(v1);
            }
            for(int i=1;i<=V;i++){
                Collections.sort(relation.get(i));
            }
            boolean visited[]=new boolean [V+1];
            Stack<Integer>q=new Stack<>();
            q.add(1);
            while(!q.isEmpty()){
                int node=q.pop();
                if(visited[node])continue;
                visited[node]=true;
                System.out.print(node+" ");
                for(int next:relation.get(node)){
                    if(!visited[next]){
                        q.add(next);
                    }
                }
            }
            System.out.println();
        }
    }
}