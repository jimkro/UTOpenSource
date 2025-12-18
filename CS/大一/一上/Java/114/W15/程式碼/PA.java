import java.util.*;

public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[10000];
        int idx = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            // 目前累積的英文字
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) { 
                if (Character.isAlphabetic(c)) sb.append(c);
                else {
                    // 看前面的字串有沒有一樣的
                    boolean same = false;
                    if (sb.length() != 0) {
                        for (int i = 0; i < idx; i++) {
                            if (arr[i].toLowerCase().equals(sb.toString().toLowerCase())) {
                                same = true;
                                break;
                            }
                        }
                        if (!same) {
                            arr[idx] = sb.toString();
                            idx++;
                        }
                    }
                    sb = new StringBuilder();
                }
            }

            // 處理最後一筆
            boolean same = false;
            if (sb.length() != 0) {
                for (int i = 0; i < idx; i++) {
                    if (arr[i].toLowerCase().equals(sb.toString().toLowerCase())) {
                        same = true;
                        break;
                    }
                }
                if (!same) {
                    arr[idx] = sb.toString();
                    idx++;
                }
            }
        }

        // bubble sort
        for (int i = 0; i < idx-1; i++) {
            for (int j = 0; j < idx-i-1; j++) {
                String s1 = arr[j].toLowerCase();
                String s2 = arr[j+1].toLowerCase();
                // 紀錄有沒有誰是誰的前綴的可能性
                boolean same = true;
                // 字串一個一個比大小 -> s1 比較大則互換
                for (int k = 0; k < Math.min(s1.length(), s2.length()); k++) {
                    if (s1.charAt(k) != s2.charAt(k)) {
                        same = false;
                        if (s1.charAt(k) > s2.charAt(k)) {
                            String tmp = arr[j];
                            arr[j] = arr[j+1];
                            arr[j+1] = tmp;
                        }
                        break;
                    }
                }

                // 處理長度不同但前綴相同的情況
                if (same && s1.length() > s2.length()) {
                    String tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for (int i = 0; i < idx; i++) System.out.println(arr[i]);
        sc.close();
    }
}