import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) { 
            int N = sc.nextInt();

            if(N==0) break;

            String Binary = Integer.toBinaryString(N); //轉成二進位字串
            int Paritybit = 0;

            for(char c:Binary.toCharArray()){
                Paritybit += c - '0';
            }
            
            System.out.println("The parity of "+Binary+" is "+Paritybit+" (mod 2).");
        }
    }
}