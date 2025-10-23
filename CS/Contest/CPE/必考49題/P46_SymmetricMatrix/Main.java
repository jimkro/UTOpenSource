import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        short cases = sc.nextShort();
        
        for(int i=1;i<=cases;i++){
            sc.next(); // N
            sc.next(); // =
            int N = sc.nextInt();
            sc.nextLine(); // %n
            long[][] data =  new long[N][N];
            boolean NonSymmetric = false;
            boolean negative = false;

            //取得陣列
            for(int row=0;row<N;row++){
                for(int column=0;column<N;column++){
                    data[row][column] = sc.nextLong();
                    if(data[row][column]<0){
                        negative = true;
                    }
                }
            }
            if(negative){
                System.out.println("Test #"+i+": Non-symmetric.");
                continue;
            }

            //
            for(int row=0;row<N;row++){
                for(int column=0;column<N;column++){
                    if(data[row][column]!=data[N-1-row][N-1-column]){
                        System.out.println("Test #"+i+": Non-symmetric.");
                        NonSymmetric = true;
                        break;
                    }
                }
                if(NonSymmetric) break;
            }
            if(NonSymmetric) continue;

            System.out.println("Test #"+i+": Symmetric.");



        }
    }
}