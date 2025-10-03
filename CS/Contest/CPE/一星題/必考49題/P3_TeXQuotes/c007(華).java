package CPE;
import java.util.*;

public class c007 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 1;

        while (sc.hasNextLine()){
            String sen = sc.nextLine();
            for (int i = 0; i < sen.length(); i++){
                if (sen.charAt(i) == '"'){
                    if (count % 2 != 0){
                        System.out.print('`');
                        System.out.print('`');
                        count += 1;
                    }else{
                        System.out.print('\'');
                        System.out.print('\'');
                        count += 1;
                    }
                }else{
                    System.out.print(sen.charAt(i));
                }
                if (i == sen.length()-1){
                    System.out.println();
                }
            }
        }
        sc.close();
    }
}