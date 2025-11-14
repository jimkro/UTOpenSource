import java.util.*;
class pb{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            int p=sc.nextInt();
            int board[]=new int[n];
            for(int i=0;i<n;i++){
                board[i]=sc.nextInt();
            }
            int poster[]=new int[p];
            for(int i=0;i<p;i++){
                poster[i]=sc.nextInt();
            }
            int left=0,right=1000000000;
            while(left<=right){
                int m=left+(right-left)/2;
                if(ok(board,poster,m)){
                    left=m+1;
                }else{
                    right=m-1;
                }
            }
            
            System.out.println(left);
        }
    }
    private static boolean ok(int board[],int poster[],int target){
        int index=0;
        int temp=0;
        for(int num:board){
            if(num>target){
                temp++;
            }else{
                temp=0;
            }
            while(index<poster.length&&temp>=poster[index]){
                temp-=poster[index];
                index++;
            }
        }
        return index==poster.length;
    }
}