import java.util.*;

public class PB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int speed_a = sc.nextInt();
            int attack_a = sc.nextInt();
            int speed_b = sc.nextInt();
            int attack_b = sc.nextInt();

            // 紀錄誰是贏家
            int winner = -1;

            // 記錄走多遠
            int dist_a = speed_a, dist_b = 1000 - speed_b;

            // 如果還是面對面的情況
            while (dist_a <= dist_b) {
                // 互相在攻擊範圍
                if (dist_a + attack_a >= dist_b && dist_b - attack_b <= dist_a) {
                    if (speed_a > speed_b) winner = 1;
                    else if (speed_a < speed_b) winner = 2;
                    break;
                }
                // B 在 A 的攻擊範圍
                else if (dist_a + attack_a >= dist_b) winner = 1;
                // A 在 B 的攻擊範圍
                else if (dist_b - attack_b <= dist_a) winner = 2;
                if (winner != -1) break;

                dist_a += speed_a;
                dist_b -= speed_b;
            }

            if (winner == -1) System.out.println("No winner");
            else if (winner == 1) System.out.println("Player A win");
            else System.out.println("Player B win");
        }
        sc.close();
    }
}