import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        outer:
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            int minBase = 0; // 找最小的可能base
            StringBuilder validLine = new StringBuilder(); // 存合法字元

            for(char c : line.toCharArray()){
                int value = charValue(c);
                if(value != -1){
                    minBase = Math.max(minBase,value); // 找最小base
                    validLine.append(c); // 存入合法字元
                }
            }
            // 如過找到最大的數值<2 (例如:"1","0") 要強制調為2，而其餘狀況要比最大數值多1才有可能是base(例如:"5"不可能是5進位)
            minBase = minBase < 2 ? 2 : minBase + 1;

            line = validLine.toString();
            
            for(int base = minBase;base<=62;base++){
                if(check(line,base)){
                    System.out.println(base);
                    continue outer;
                }
            }
            
            System.out.println("such number is impossible!");
        }
    }
    // 把字元對應到數值
    private static int charValue(char c){
        if('0'<=c && c<='9') return c - '0';
        if('A'<=c && c<='Z') return c - 'A' + 10;
        if('a'<=c && c<='z') return c - 'a' + 36;
        return -1;
    }
    // 檢查是否滿足題目要求
    private static boolean check(String line,int base){
        long value = 0;
        int MOD = base - 1;
        for(int i=line.length()-1;i>=0;i--){
            value = value * base + charValue(line.charAt(i));
            value %= MOD; // 先mod或後mod不會影響最後的結果，但能夠縮減value的大小避免overflow
        }
        return value == 0;
    }
}
