import java.util.*;
public class PB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String line = sc.nextLine();
            int len = line.length();
            
            for(int i=0;i<len;i += 3){
                //三個一組取出子字串
                String sub = line.substring(i, i+3);
                //先轉成int再轉char
                char c = (char)Integer.parseInt(sub);
                //輸出
                System.out.print(c);
            }
            //換行
            System.out.println(); 
        }
    }
}
