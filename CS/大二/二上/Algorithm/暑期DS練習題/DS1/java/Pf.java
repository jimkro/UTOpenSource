import java.util.*;
class Pf{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            PriorityQueue<Integer>max=new PriorityQueue<>((a,b)->b-a);
            PriorityQueue<Integer>min=new PriorityQueue<>();
            long ans=0;
            int times=sc.nextInt();
            for(int i=0;i<times;i++){
                int num=sc.nextInt();
                if(max.isEmpty()||num<=max.peek()){
                    max.add(num);
                }
                else{
                    min.add(num);
                }
                while(max.size()>min.size()+1){
                    min.add(max.poll());
                }
                while(min.size()>max.size()){
                    max.add(min.poll());
                }
                if((i+1)%2==1) ans+=max.peek();
                else ans+=(min.peek()+max.peek())/2;
                
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
