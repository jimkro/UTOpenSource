import java.util.*;
public class Pa {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            int k=sc.nextInt();
            long arr[]=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            PriorityQueue<Long>pq=new PriorityQueue<>();
            Arrays.sort(arr);
            for(int i=1;i<n;i++){
                pq.add(arr[i]-arr[i-1]);
            }
            long ans=0;
            while(k-->0){
                ans+=pq.poll();
            }
            System.out.println(ans);
        }
    }
}
