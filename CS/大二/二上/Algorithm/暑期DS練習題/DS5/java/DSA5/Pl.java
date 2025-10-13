import java.util.*;
class Pl{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            int start=sc.nextInt();
            int end=sc.nextInt();
            List<List<Integer>>relation=new ArrayList<>();
            for(int i=0;i<=n;i++){
                relation.add(new ArrayList<>());
            }
            sc.nextLine();
            for(int i=1;i<=n;i++){
                String arr[]=sc.nextLine().trim().split("\\s+");
                int no=Integer.parseInt(arr[0]);
                for(int j=1;j<arr.length;j++){
                    int node=Integer.parseInt(arr[j]);
                    relation.get(no).add(node);
                    relation.get(node).add(no);
                }
            }
            Queue<int[]>q=new LinkedList<>();
            q.add(new int[]{start,0});
            boolean visited[]=new boolean[n+1];
            visited[start]=true;
            while(!q.isEmpty()){
                int cur[]=q.poll();
                int node=cur[0],len=cur[1];
                if(node==end){
                    System.out.println(len);
                    break;
                }
                for(int next:relation.get(node)){
                    if(!visited[next]){
                        q.add(new int[]{next,len+1});
                        visited[next]=true;
                    }
                }
            }
        }
    }
}