package 一星題.必考49題.P13_HashmatTheBraveWarrior;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){

            String line1 = sc.next();
            String line2 = sc.next();

            System.out.println((new BigInteger(line1)).subtract(new BigInteger(line2)).abs()); //(A-B)取絕對值
        }
    }
}
