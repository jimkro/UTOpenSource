import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases-->0){
            int M = sc.nextInt();
            int N = sc.nextInt();
            int Q = sc.nextInt();
            System.out.println(M + " " + N + " " + Q);
            char[][] arr = new char[M][N];
            for(int i=0;i<M;i++){
                arr[i] = sc.next().toCharArray();
            }
            while(Q-->0){
                int r = sc.nextInt();
                int c = sc.nextInt();

                // ���H (r, c) �����ߪ��̤j��������
                int maxSize = 1; // �̤p����ά� 1x1
                char centerChar = arr[r][c];

                for (int size = 1; r - size >= 0 && r + size < M && c - size >= 0 && c + size < N; size++) {
                    boolean isValid = true;

                    // �ˬd�s�W���|����
                    for (int i = r - size; i <= r + size; i++) {
                        if (arr[i][c - size] != centerChar || arr[i][c + size] != centerChar) {
                            isValid = false;
                            break;
                        }
                    }
                    for (int j = c - size; j <= c + size; j++) {
                        if (arr[r - size][j] != centerChar || arr[r + size][j] != centerChar) {
                            isValid = false;
                            break;
                        }
                    }

                    if (!isValid) break;
                    maxSize = 2 * size + 1;
                }

                System.out.println(maxSize);
            }
        }
        sc.close();
        
    }
}