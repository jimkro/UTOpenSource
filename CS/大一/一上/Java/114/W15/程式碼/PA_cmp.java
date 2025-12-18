import java.util.*;

public class PA_cmp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 需要排序字串
        List<String> list = new ArrayList<>();
        // 看過的字串 (小寫)
        Set<String> seen = new HashSet<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            // 目前累積的英文字
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) { 
                if (Character.isAlphabetic(c)) sb.append(c);
                else {
                    // 沒看過並且字串長度不為零才可加入 List 裡面
                    if (sb.length() != 0 && !seen.contains(sb.toString().toLowerCase())) {
                        list.add(sb.toString());
                        seen.add(sb.toString().toLowerCase());
                    }
                    sb = new StringBuilder();
                }
            }

            // 處理最後一筆
            if (sb.length() != 0 && !seen.contains(sb.toString().toLowerCase())) {
                list.add(sb.toString());
                seen.add(sb.toString().toLowerCase());
            }
        }
        
        // sort
        list.sort((s1, s2) -> {
            // 轉為小寫再排序
            String lower1 = s1.toLowerCase();
            String lower2 = s2.toLowerCase();
            return lower1.compareTo(lower2);
        });

        for (String s : list) System.out.println(s);
        sc.close();
    }
}