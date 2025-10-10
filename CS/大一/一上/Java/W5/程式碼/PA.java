import java.util.*;

public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            String s = "";
            if (a == 1)
                s += "handsome";
            else if (a == 2)
                s += "rich";
            else if (a == 3)
                s += "smart";

            if (b == 1)
                s += " Allcky";
            else if (b == 2)
                s += " Jimmy";
            else if (b == 3)
                s += " Chen";

            if (c == 1)
                s += " dances";
            else if (c == 2)
                s += " eats";
            else if (c == 3)
                s += " writes";

            System.out.println(s);
        }
        sc.close();
    }
}
