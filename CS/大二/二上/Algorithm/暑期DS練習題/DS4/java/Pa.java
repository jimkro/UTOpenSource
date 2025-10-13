import java.util.*;
class Pa{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        boolean yaa=false;
        while(true){
            int v=sc.nextInt();
            int e=sc.nextInt();
            int method=sc.nextInt();
            if(v==0&&e==0&&method==0)break;
            if(yaa){
                System.out.println("");
            }
            yaa=true;
            int arr[][]=new int[v][v];
                for(int i=0;i<v;i++){
                    Arrays.fill(arr[i],100);
                    arr[i][i]=0;
                }
                for(int i=0;i<e;i++){
                    int v1=sc.nextInt();
                    int v2=sc.nextInt();
                    int value=sc.nextInt();
                    arr[v1-1][v2-1]=value;
                    arr[v2-1][v1-1]=value;
                }
            if(method==0){
                for(int i=0;i<v;i++){
                    for(int j=0;j<v;j++){
                        System.out.printf("%3d",(arr[i][j]));
                        if(j!=v-1) System.out.print(" ");
                    }
                    System.out.println();
                }
            }
            else{
                for(int i=0;i<v;i++){
                    System.out.print((i+1));
                    for(int j=0;j<v;j++){
                        if(arr[i][j]!=0&&arr[i][j]!=100)System.out.print(" "+(j+1)+" "+(arr[i][j]));
                    }
                    System.out.println();
                }
            }
        }
        sc.close();
    }
}