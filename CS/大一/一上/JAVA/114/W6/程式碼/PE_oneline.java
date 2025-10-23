import java.util.*;
import java.math.BigInteger;

public class PE_oneline{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) System.out.println(new BigInteger(sc.next()).remainder(new BigInteger("330")).equals(BigInteger.ZERO) ? "nice gift" : "skip");
        sc.close();
    }
}