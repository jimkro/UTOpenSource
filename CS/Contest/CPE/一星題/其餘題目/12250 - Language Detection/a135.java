package CPE;
import java.util.*;

public class a135 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String,String> lan = new HashMap<>();
        int cases = 0;
        lan.put("HELLO","ENGLISH");
        lan.put("HOLA","SPANISH");
        lan.put("HALLO","GERMAN");
        lan.put("BONJOUR","FRENCH");
        lan.put("CIAO","ITALIAN");
        lan.put("ZDRAVSTVUJTE","RUSSIAN");

        while (sc.hasNext()) {
            cases++;
            boolean a = false;
            String in = sc.next();
            switch (in) {
                case "#":
                    a = true;
                    break;
            }
            if (a) break;
            if (lan.containsKey(in)) System.out.println("Case "+ cases +": "+lan.get(in));
            else System.out.println("Case "+ cases +": UNKNOWN");
        }
        sc.close();
    }
}
