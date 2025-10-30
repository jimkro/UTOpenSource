package 一星題.必考49題.P3_TeXQuotes;

import java.util.*;
public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int check = 1; //正的表示第一次遇到" 負的表示第二次遇到"
        

        while(sc.hasNext()){
            StringBuilder sb = new StringBuilder();
            String line = sc.nextLine();
            for(char c:line.toCharArray()){
                if(c=='"' && check==1){
                    sb.append('`');
                    sb.append('`');
                    check *= -1;
                }else if(c=='"' && check == -1){
                    sb.append("'");
                    sb.append("'");
                    check *= -1;
                }else{
                    sb.append(c);
                }

            }
            System.out.println(sb.toString());
        }
    }
}
