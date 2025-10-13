import java.util.*;
public class Py {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String str=sc.nextLine();
            Stack<Character>s=new Stack<>();
            for(char c:str.toCharArray()){
                if(s.isEmpty()||c!=s.peek()){
                    s.add(c);
                }
                else s.pop();
            }
            if(s.isEmpty())System.out.println("SUCCESS");
            else System.out.println("FAIL");
        }
        sc.close();
    }
}
