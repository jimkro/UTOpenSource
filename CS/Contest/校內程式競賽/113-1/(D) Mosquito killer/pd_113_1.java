/*
解題想法
用泡泡排序法
分貝大的往後排
分貝相同 速度快的往後排
速度相同 重量小的往後排
重量相同 早出現的往後排
最後從後往前印就是答案
(也可以讓會先死的往前排，就不用比誰先出現)
(我快寫完才發現順序反了，但懶得改w)
 */

package UTCS_program_contest;
import java.util.*;

public class pd_113_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){
            int cases = sc.nextInt();
            if (cases == 0) break;
            float[][] rec = new float[cases][4];
            
            for (int i = 0; i < cases; i++){
                for (int j = 0; j < 4; j++){
                    rec[i][j] = sc.nextFloat();
                }
            }

            for (int i = 0; i < cases-1; i++){ //前項
                for (int j = i+1; j < cases; j++){ //後項
                    float[] temp = new float[4];
                    if (rec[i][3] > rec [j][3]){ //前項分貝較大
                        for (int c = 0; c < 4; c++){ //往後排
                            temp[c] = rec[i][c];
                            rec[i][c] = rec[j][c];
                            rec[j][c] = temp[c];
                        }
                    }else if (rec[i][3] == rec [j][3]){ //分貝相等
                        if (rec[i][2] > rec [j][2]){ //前項速度較大
                            for (int c = 0; c < 4; c++){ //往後排
                                temp[c] = rec[i][c];
                                rec[i][c] = rec[j][c];
                                rec[j][c] = temp[c];
                            }
                        }else if (rec[i][2] == rec [j][2]){ //速度相等
                            if (rec[i][1] < rec [j][1]){ //後項比較重
                                for (int c = 0; c < 4; c++){ //往後排
                                    temp[c] = rec[i][c];
                                    rec[i][c] = rec[j][c];
                                    rec[j][c] = temp[c];
                                }
                            }else if (rec[i][1] == rec [j][1]){ //重量一樣
                                if (rec[i][0] < rec [j][0]){ //前項編號小
                                    for (int c = 0; c < 4; c++){ //往後排
                                        temp[c] = rec[i][c];
                                        rec[i][c] = rec[j][c];
                                        rec[j][c] = temp[c];
                                    }
                                }
                            }
                        }
                    }
                }
            }

            for (int i = cases-1; i >= 0; i--){
                System.out.print((int)rec[i][0] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
