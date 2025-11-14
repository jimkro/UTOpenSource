import java.util.*;
class pc{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int V=sc.nextInt();
            int E=sc.nextInt();
            int method=sc.nextInt();
            if(V==0)break;
            int arr[][]=new int [V+1][V+1];

            for(int a[]:arr){
                Arrays.fill(a,100);
            }

            for(int i=0;i<E;i++){
                int v1=sc.nextInt();
                int v2=sc.nextInt();
                int value=sc.nextInt();
                arr[v1][v2]=value;
                arr[v2][v1]=value;
            }
            for(int i=1;i<=V;i++){
                arr[i][i]=0;
            }
            if(method==0){
                for(int i=1;i<=V;i++){
                    for(int j=1;j<=V;j++){
                        System.out.printf("%3d ",arr[i][j]);
                    }
                    System.out.println();
                }
            }
            if(method==1){
                for(int i=1;i<=V;i++){
                    System.out.print(i+" ");
                    for(int j=1;j<=V;j++){
                        if(arr[i][j]!=100&&arr[i][j]!=0)System.out.print(j+" "+arr[i][j]+" ");
                    }
                    System.out.println();
                }
            }
            

            System.out.println();
        }
    }
}
