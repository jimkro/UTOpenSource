import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //cases
        short cases = sc.nextShort();
        while(cases--!=0){
            short N = sc.nextShort();
            short[] data = new short[N];

            //each number
            for(int i=0;i<N;i++){
                data[i] = sc.nextShort();
            }

            //sort data
            Arrays.sort(data);

            //get median
            short median = data[N/2];

            //sum
            int sum = 0;
            for(int i=0;i<N;i++){
                sum += Math.abs(data[i]-median);
            }

            //output
            System.out.println(sum);
        }
    }
}
////////////////////////////////////

//記憶體超標//