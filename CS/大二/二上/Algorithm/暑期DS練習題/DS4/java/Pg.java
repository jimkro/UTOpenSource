import java.util.*;
class Pg{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int cas=1;
        while(sc.hasNextInt()){
            boolean yaa=false;
            int pointed[]=new int[101];
            boolean appear[]=new boolean[101];
            List<List<Integer>> relation=new ArrayList<>();
            for(int i=0;i<101;i++){
                relation.add(new ArrayList<>());
            }
            while(sc.hasNextInt()){
                int n1=sc.nextInt();
                int n2=sc.nextInt();
                if(n1==0 && n2==0) break;
                if(n1==-1&&n2==-1){
                    yaa=true;
                    break;
                }
                appear[n1]=true;
                pointed[n2]++;
                relation.get(n1).add(n2);
            }
            if(yaa)break;
            int root=0;
            boolean isTree=true;
            
            for(int i=1;i<101;i++){
                if(pointed[i]>1)isTree=false;
                else if(pointed[i]==0&&appear[i]&&root!=0)isTree=false;
                else if(pointed[i]==0&&appear[i]){
                    root=i;
                }
            }
            boolean visited[]=new boolean[101];
            boolean onstack[]=new boolean[101];
            boolean nocycle[]=new boolean[1];
            nocycle[0]=true;
            dfs(relation, root,visited,onstack,nocycle);
            for(int i=1;i<101;i++){
                if(appear[i]&&!visited[i])isTree=false;
            }
            if(isTree&&nocycle[0]){
                System.out.println("Case "+cas+" is a tree. Root is "+root+".");
            }
            else{
                System.out.println("Case "+cas+" is not a tree.");
            }
            cas++;
        }
        sc.close();
    }
    private static void dfs(List<List<Integer>> relation,int node,boolean visited[],boolean onstack[],boolean nocycle[]){
        visited[node]=true;
        onstack[node]=true;
        for(int next:relation.get(node)){
            if(!visited[next]){
                dfs(relation,next,visited,onstack,nocycle);
                if(!nocycle[0])return;
            }
            else if(onstack[next]){
                nocycle[0]=false;
                return;
            }
        }
        onstack[node]=false;
    }
}