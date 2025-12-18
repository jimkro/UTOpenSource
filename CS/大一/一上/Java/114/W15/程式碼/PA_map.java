import java.util.*;

public class PA_map {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TreeMap<Value的小寫樣式, 原本的樣子> -> 根據 Key 照字典序排
        Map<String, String> map = new TreeMap<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            // 目前累積的英文字
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) { 
                if (Character.isAlphabetic(c)) sb.append(c);
                else {
                    // 沒有存在過該字串的小寫樣式則加進 map
                    if (sb.length() != 0 && !map.containsKey(sb.toString().toLowerCase())) map.put(sb.toString().toLowerCase(), sb.toString());
                    sb = new StringBuilder();
                }
            }

            // 處理最後一筆
            if (sb.length() != 0 && !map.containsKey(sb.toString().toLowerCase())) map.put(sb.toString().toLowerCase(), sb.toString());
        }

        for (Map.Entry<String, String> entry : map.entrySet()) System.out.println(entry.getValue());
        sc.close();
    }
}