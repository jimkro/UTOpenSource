// ���ۤ@�U�A��JAVA���Ӥw
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            double s = sc.nextDouble();
            double a = sc.nextDouble();
            String d = sc.next();

            // �[�W�a�y�b�|
            s += 6440.0;

            // ������׼�
            if (d.equals("min")) {
                a /= 60;
            }

            // ���P�쨤
            a %= 360;

            // ���� 180 �פ�
            a = Math.min(Math.abs(360-a),a);

            // �]�w��X�榡
            double arc = s * a * Math.PI / 180;
            double chord = s * Math.sin(a / 2 * Math.PI / 180) * 2;
            System.out.printf("%.6f %.6f%n",arc,chord);
        }

        sc.close();
    }
}
