package 一星題.必考49題.P2_MutantFlatworldExpolrers;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int xMax = sc.nextInt();  // 矩形土地的最大 x 坐標
        int yMax = sc.nextInt();  // 矩形土地的最大 y 坐標

        Set<String> scent = new HashSet<>();  // 用來記錄機器人掉落前的位置（有標記）

        while (sc.hasNext()) {
            // 接收機器人的初始 x, y, 方向
            int X = sc.nextInt();
            int Y = sc.nextInt();
            char Direction = sc.next().charAt(0);

            // 接收移動指令
            String order = sc.next();
            boolean isLost = false;  // 檢查機器人是否掉落

            // 移動指令處理
            for (int i = 0; i < order.length(); i++) {
                if (order.charAt(i) == 'F') {
                    // 記住原始位置，因為可能會掉落
                    int prevX = X;
                    int prevY = Y;

                    // 向前移動
                    if (Direction == 'N') Y++;
                    if (Direction == 'S') Y--;
                    if (Direction == 'E') X++;
                    if (Direction == 'W') X--;

                    // 邊界檢查
                    if (X > xMax || Y > yMax || X < 0 || Y < 0) {
                        // 如果當前位置沒有標記，則機器人掉落
                        if (!scent.contains(prevX + " " + prevY)) {
                            isLost = true;
                            scent.add(prevX + " " + prevY);  // 標記該位置
                            X = prevX;  // 恢復掉落前的位置
                            Y = prevY;
                            break;  // 終止移動
                        } else {
                            // 如果已經有標記，忽略這次掉落並回到原來位置
                            X = prevX;
                            Y = prevY;
                        }
                    }
                }
                
                // 右轉 (R)
                if (order.charAt(i) == 'R') {
                    if (Direction == 'N') {
                        Direction = 'E';
                    } else if (Direction == 'E') {
                        Direction = 'S';
                    } else if (Direction == 'S') {
                        Direction = 'W';
                    } else {
                        Direction = 'N';
                    }
                }
                
                // 左轉 (L)
                if (order.charAt(i) == 'L') {
                    if (Direction == 'N') {
                        Direction = 'W';
                    } else if (Direction == 'E') {
                        Direction = 'N';
                    } else if (Direction == 'S') {
                        Direction = 'E';
                    } else {
                        Direction = 'S';
                    }
                }
            }

            // 輸出最終結果
            if (isLost) {
                System.out.println(X + " " + Y + " " + Direction + " LOST");
            } else {
                System.out.println(X + " " + Y + " " + Direction);
            }
        }
    }
}
