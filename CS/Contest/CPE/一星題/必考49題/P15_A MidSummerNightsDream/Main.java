import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            //輸入
            int N = sc.nextInt();
            int[] numbers = new int[N];
            for(int i=0;i<N;i++){
                numbers[i] = sc.nextInt();
            }
            //排序
            Arrays.sort(numbers);
            //計算
            int ans1 = 0;
            int ans2 = 0;
            int ans3 = 0;
            
            if(N%2==1){ //陣列大小是奇數
                ans1 = numbers[N/2];
                ans3 = 1; //固定的
                for(int i=0;i<N;i++){
                    if(numbers[i]==numbers[N/2]){
                        ans2++;
                    }
                }
            }else{ //陣列大小是偶數
                ans1 = numbers[N/2-1];
                for(int i=0;i<N;i++){
                    if(numbers[i]>= numbers[N/2-1] && numbers[i]<= numbers[N/2]){
                        ans2++;
                    }
                }
                for(int i=numbers[N/2-1];i<=numbers[N/2];i++){
                    ans3++;
                }

            }
            //輸出
            System.out.println(ans1+" "+ans2+" "+ans3);


        }
    }
}