import java.util.*;

public class c007 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = 0;
        while (s.hasNextLine()) {
            String a = s.nextLine();
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '"') {
                    count++;
                    if (count % 2 != 0) {
                        System.out.print("``");
                    } else {
                        System.out.print("''");
                    }

                } else {
                    System.out.print(a.charAt(i));
                }
            }
            System.out.println();
        }
        s.close();
    }

}
