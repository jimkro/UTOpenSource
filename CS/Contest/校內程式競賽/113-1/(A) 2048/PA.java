import java.util.*;
public class PA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int N = sc.nextInt();
            String cmd = sc.next();
            
            // 建立地圖
            int[] field = new int[N];
            for(int i=0;i<N;i++){
                field[i] = sc.nextInt();
            }
            // 移動
            for(char c:cmd.toCharArray()){
                
                if(c=='R'){ // 向右
                    // 用i,j來比對
                    int i = N-1;
                    int j = N-2;
                    // 負責建立新的地圖的index
                    int creater = N-1;

                    while(i>=0 && j>=0){
                        // 跳過0
                        if(field[i]==0){
                            i--;
                            continue;
                        } 
                        // 跳過0
                        if(field[j]==0 || j==i){ // 要注意j跟i可能卡在一起所以要讓j路過i
                            j--;
                            continue;
                        }
                        
                        if(field[i]==field[j]){ // 合併
                            field[creater] = field[i] * 2;
                            creater--; 
                            i = j - 1;
                            j -= 2;
                        }else{ // 遇到不一樣，先把在i的先定位 (例如4,2先把2定位好)
                            field[creater] = field[i];
                            creater--;
                            // 刷新位置
                            i = j;
                            j--;
                        }
                    }
                    // 如果只有一個指標溢出時i會沒紀錄到，補紀錄
                    if(j<0 && i>=0){
                        field[creater] = field[i];
                        creater--;
                    }
                    // 補0
                    for(int k=creater;k>=0;k--){
                        field[k] = 0;
                    }

                }else{ // 向左(邏輯相同，方向顛倒)
                    int i = 0;
                    int j = 1;
                    int creater = 0;
                    while(i<N && j<N){
                        if(field[i]==0){
                            i++;
                            continue;
                        } 
                        if(field[j]==0 || j==i){
                            j++;
                            continue;
                        }
                        
                        if(field[i]==field[j]){
                            field[creater] = field[i] * 2;
                            creater++;
                            i = j + 1;
                            j += 2;
                        }else{
                            field[creater] = field[i];
                            creater++;
                            i = j;
                            j++;
                        }
                    }
                    if(j>=N && i<N){
                        field[creater] = field[i];
                        creater++;
                    }
                    for(int k=creater;k<N;k++){
                        field[k] = 0;
                    }
                }
            }

            //輸出
            for(int n:field){
                System.out.print(n+" ");
            }
            System.out.println();
            
        }     
    }
    
}
