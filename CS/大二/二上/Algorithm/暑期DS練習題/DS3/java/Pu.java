import java.util.*;
public class Pu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            if(n==0)break;
            int i=0,j=n-1;
            int abi[]=new int[n];
            for(int k=0;k<n;k++){
                abi[k]=sc.nextInt();
            }
            Arrays.sort(abi);
            System.out.println(n/2);
            while(i<j){
                System.out.print(abi[i++]+abi[j--]+" ");
            }
            System.out.println("");
        }
        sc.close();
    }
}