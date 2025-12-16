// 偷抄一下，改JAVA版而已
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            double s = sc.nextDouble();
            double a = sc.nextDouble();
            String d = sc.next();

            // 加上地球半徑
            s += 6440.0;

            // 分鐘轉度數
            if (d.equals("min")) {
                a /= 60;
            }

            // 換同位角
            a %= 360;

            // 換成 180 度內
            a = Math.min(Math.abs(360-a),a);

            // 設定輸出格式
            double arc = s * a * Math.PI / 180;
            double chord = s * Math.sin(a / 2 * Math.PI / 180) * 2;
            System.out.printf("%.6f %.6f%n",arc,chord);
        }

        sc.close();
    }
}
