import java.util.*;
class Ph{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int num=sc.nextInt();
            sc.nextLine();
            String str[]=sc.nextLine().split(" ");
            Queue<String>q=new LinkedList<>();
            for(String temp:str){
                q.offer(temp);
            }
            while(q.size()!=1){
                q.offer(q.poll());
                q.offer(q.poll());
                q.poll();
            }
            System.out.println(q.poll());
        }
        sc.close();
    }
}
