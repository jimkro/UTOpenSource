import java.util.*;

public class PF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            double mk_health = 30, mk_attack = 10, mk_mul = 1.3;
            double pk_health = 50, pk_attack = 25, pk_mul = 1.25;

            // 先把兩者拉到同一level
            mk_health *= Math.pow(mk_mul, n-1); // level1不需要乘倍率 所以次方數為n-1
            mk_attack *= Math.pow(mk_mul, n-1);
            pk_health *= Math.pow(pk_mul, n-1);
            pk_attack *= Math.pow(pk_mul, n-1);

            int count = 0;
            
            while (!check(mk_health, mk_attack, pk_health, pk_attack)) {
            mk_health *= mk_mul;
            mk_attack *= mk_mul;
            count++;
            if (count + n > 50) {
                    count = 0;
                    break;
                }
            }
            
            System.out.println(count);
        }
        sc.close();
    }
    
    // 檢查mk每升一level能不能打敗pk
    public static boolean check(double mk_health, double mk_attack, double pk_health, double pk_attack) {
        while (mk_health > 0 && pk_health > 0) {
            pk_health -= mk_attack;
            mk_health -= pk_attack;
        }
        
        return (pk_health < 0 && mk_health > 0);
    }
}



// 另一種解法 : 看雙方需要多少次才能擊敗對方
// mk花費的次數必須大於pk花費的次數 不然會一起死掉
// while (Math.ceil(pk_health / mk_attack) >= Math.ceil(mk_health / pk_attack)) {
//     count++;
//     mk_health *= mk_mul;
//     mk_attack *= mk_mul;

//     if (count + n > 50) {
//         count = 0;
//         break;
//     }
// }