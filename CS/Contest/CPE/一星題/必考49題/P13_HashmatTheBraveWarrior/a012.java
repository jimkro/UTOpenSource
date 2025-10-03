package CPE;
import java.util.*;

public class a012 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLong()){
            long e = sc.nextLong();
            long h = sc.nextLong();

            System.out.println(Math.abs(e - h));
        }
        sc.close();
    }   
}
