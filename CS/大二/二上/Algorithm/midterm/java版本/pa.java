import java.util.*;

class pa {
    public static void main(String args[]) {
        Scanner sc =new Scanner(System.in);
        StringBuilder output =new StringBuilder();
        //用StringBuilder 存，最後一次輸出，因為System.out.println會不斷刷新緩衝區，導致程式的執行時間過長
        while (sc.hasNextInt()) {
            int n =sc.nextInt();
            int arr[]=new int[n];
            for (int i=0;i<n;i++)arr[i]=sc.nextInt();

            mergesort(arr,0,n-1,output);

            output.append("\n\n"); 
        }
        System.out.print(output);
    }

    private static void mergesort(int arr[], int left, int right, StringBuilder output) {
        if (left>=right)return;

        int mid=left+(right-left)/2;
        mergesort(arr,left,mid,output);
        mergesort(arr,mid+1,right,output);
        merge(arr,left,mid,right);

        for (int num:arr) {
            output.append(num).append(" ");
        }
        output.append("\n");
    }

    private static void merge(int arr[], int left, int mid, int right) {
        int copy[]=new int[right-left+1];

 
        for (int i=left;i<=right;i++)copy[i-left]=arr[i];

        int i=left,j=mid+1,idx=left;

        while (i<=mid&&j<=right) {
            if (copy[i-left]<=copy[j-left])arr[idx++]=copy[i++-left];
            else arr[idx++]=copy[j++-left];
        }

        while(i<=mid)arr[idx++]=copy[i++-left];

    }
}
