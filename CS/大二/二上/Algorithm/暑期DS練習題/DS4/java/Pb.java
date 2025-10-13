import java.util.*;
class Pb{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(true){
            int v=sc.nextInt();
            int e=sc.nextInt();
            int method=sc.nextInt();
            if(v==0&&e==0&&method==0)break;
            if(method==0){
                List<List<Integer>> relation = new ArrayList<>();
                for(int i=0;i<=v;i++){
                    relation.add(new ArrayList<>());
                }
                for(int i=0;i<e;i++){
                    int v1=sc.nextInt();
                    int v2=sc.nextInt();
                    relation.get(v1).add(v2);
                    relation.get(v2).add(v1);
                }
                for(List<Integer> a:relation){
                    Collections.sort(a);
                }
                Queue<Integer> q=new LinkedList<>();
                boolean[] visited = new boolean[v+1];
                q.add(1);
                System.out.print(1);
                visited[1]=true;
                while(!q.isEmpty()){
                    int cur=q.poll();
                    for(int i=0;i<relation.get(cur).size();i++){
                        if(!visited[relation.get(cur).get(i)]){
                            visited[relation.get(cur).get(i)]=true;
                            System.out.print(" "+relation.get(cur).get(i));
                            q.add(relation.get(cur).get(i));
                        }
                    }
                }
            }
            else{
                List<List<Integer>> arr = new ArrayList<>();
                for(int i=0;i<=v;i++){
                    arr.add(new ArrayList<>());
                }
                for(int i=0;i<e;i++){
                    int v1=sc.nextInt();
                    int v2=sc.nextInt();
                    arr.get(v1).add(v2);
                    arr.get(v2).add(v1);
                }
                Stack<Integer>s=new Stack();
                boolean[] visited = new boolean[v+1];
                s.push(1);
                while(!s.isEmpty()){
                    int q=s.pop();
                    if(!visited[q]){
                        Collections.sort(arr.get(q));
                        visited[q]=true;
                        for(int a:arr.get(q)){
                            s.add(a);
                        }
                        System.out.print(q+" ");
                    }
                }
            }
            System.out.println();
        }
        sc.close();
    }
}