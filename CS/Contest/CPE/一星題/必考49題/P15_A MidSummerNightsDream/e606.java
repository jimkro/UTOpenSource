package CPE;
import java.util.*;

public class e606{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			int cases = sc.nextInt();
            int count = 0;
			int arr[] = new int[cases];

			for(int i = 0; i < cases; i++){
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			int mid = arr[(cases-1)/2];
			int mid2 = arr[cases/2];
		

			for(int i = 0; i < cases; i++){
				if(arr[i] == mid || arr[i] == mid2) count++;
			}
			
			//有幾種最小可能
			int D = mid2 - mid + 1;
			
			System.out.println(mid +" "+ count +" "+ D);
			
		}
        sc.close();
	}
}