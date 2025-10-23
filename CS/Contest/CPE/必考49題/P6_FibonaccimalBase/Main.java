import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //cases
        int cases = sc.nextInt();
        //deal with each input
        while(cases--!=0){

            //input N
            int N = sc.nextInt(); 
            //creat Fibonacci Sequence
            ArrayList<Integer> fibs = new ArrayList<>();
            fibs.add(1); //F(1) = 1
            fibs.add(2); //F(2) = 2
            while(true){
                int nextfib = fibs.get(fibs.size()-1) + fibs.get(fibs.size()-2); //F(N) = F(N-1) + F(N-2)
                if(nextfib>N) break; 
                fibs.add(nextfib);
            }
            
            // Main
            StringBuilder sb = new StringBuilder(); //Fibonacci Base
            boolean leadingOne = false; //check 1 would be the first one
            int current = N;

            
            for(int i=fibs.size()-1;i>=0;i--){
                if(current>=fibs.get(i)){
                    sb.append('1');
                    current-=fibs.get(i);
                    leadingOne = true;
                }else if (leadingOne){
                    sb.append('0');
                }
            }

            //output
            System.out.println(N+" = "+sb.toString()+" (fib)");


        }
        sc.close();
    }
}