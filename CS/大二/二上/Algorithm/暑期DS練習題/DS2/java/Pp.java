import java.util.*;
public class Pp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int ca=1;
        while(sc.hasNextInt()){
            int num=sc.nextInt();
            if(num==0)break;
            int ability=sc.nextInt();
            PriorityQueue<Integer>q=new PriorityQueue<>();
            int rule=0,norule=0;
            for(int i=0;i<num;i++){
                int close=Integer.MAX_VALUE;
                for(int j=0;j<num;j++){
                    int a=sc.nextInt();
                    if(Math.abs(a-ability)<close)close=Math.abs(a-ability);
                    q.add(Math.abs(a-ability));
                }
                rule+=close;
            }
            for(int i=0;i<num;i++)norule+=q.poll();
            if(rule==norule){
                System.out.println("Case "+ca+": "+rule+" VS. "+norule);
                System.out.println("Perfect Teammate.");
            }
            else{
                System.out.println("Case "+ca+": "+norule+" VS. "+rule);
                System.out.println("Just Teammate.");
            }
            ca++;
        }
        sc.close();
    }
}
