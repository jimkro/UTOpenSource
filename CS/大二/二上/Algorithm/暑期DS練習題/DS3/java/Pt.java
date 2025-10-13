import java.util.*;
public class Pt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int M=sc.nextInt();
            int n=sc.nextInt();
            int money[]=new int[M];
            for(int i=0;i<M;i++){
                money[i]=sc.nextInt();
            }
            int copy[]=Arrays.copyOf(money, M);
            System.out.println(1);
            for(int i=0 ,step=0;i<M&&step<n;i++,step++){
                int temp=copy[i];
                int j=i-1;
                while(j>=0&&temp>copy[j]){
                    copy[j+1]=copy[j];
                    j--;
                }
                copy[j+1]=temp;
                for(int num:copy){
                    System.out.print(num+" ");
                }
                System.out.println("");
            }
            int copy2[]=Arrays.copyOf(money, M);
            System.out.println(2);
            for(int i=M-1,step=0;i>=0&&step<n;i--,step++){
                for(int j=M-1;j>0;j--){
                    if(copy2[j]>copy2[j-1]){
                        int te=copy2[j];
                        copy2[j]=copy2[j-1];
                        copy2[j-1]=te;
                    }
                }
                for(int num:copy2){
                    System.out.print(num+" ");
                }
                System.out.println("");
            }
            int copy3[]=Arrays.copyOf(money, M);
            System.out.println(3);
            for(int i=0,step=0;i<M&&step<n;i++,step++){
                int maxindex=i;
                for(int j=i+1;j<M;j++){
                    if(copy3[j]>copy3[maxindex])maxindex=j;
                }
                int temp=copy3[i];
                copy3[i]=copy3[maxindex];
                copy3[maxindex]=temp;
                for(int num:copy3){
                    System.out.print(num+" ");
                }
                System.out.println("");
            }
        }
        sc.close();
    }
}

