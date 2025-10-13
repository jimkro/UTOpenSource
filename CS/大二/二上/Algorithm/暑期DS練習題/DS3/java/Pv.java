import java.util.*;
public class Pv {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            if(n==0) break;
            PriorityQueue<double[]>q=new PriorityQueue<>((a,b)->{
                if(a[3]!=b[3])return Double.compare(b[3],a[3]);
                else if(a[2]!=b[2])return Double.compare(b[2],a[2]);
                else if(a[1]!=b[1])return Double.compare(a[1],b[1]);
                else return Double.compare(a[0],b[0]);
            });//no,weight,speed,dicibel
            for(int i=0;i<n;i++){
                double temp[]=new double[4];
                for(int j=0;j<4;j++){
                    temp[j]=sc.nextDouble();
                }
                q.add(temp);
            }
            while(!q.isEmpty()){
                System.out.print((int)q.poll()[0]+" ");
            }
            System.out.println("");
        }
        sc.close();
    }
}