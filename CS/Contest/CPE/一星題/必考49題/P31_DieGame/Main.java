import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            //指令數量
            int N = sc.nextInt();
            //終止條件
            if(N==0) break;
            //吸走換行
            sc.nextLine();
            //初始狀態
            int top = 1;
            int north = 2;
            int west = 3;
            //跑指令
            while(N--!=0){
                String cmd = sc.nextLine();
                if(cmd.equals("north")){ //北
                    int temp = top;
                    top = 7-north;
                    north = temp;
                }else if(cmd.equals("south")){ //南
                    int temp = top;
                    top = north;
                    north = 7-temp;
                }else if (cmd.equals("west")){ //西
                    int temp = top;
                    top = 7-west;
                    west = temp;
                }else{ //東
                    int temp = top;
                    top = west;
                    west = 7-temp;
                }
            }
            //輸出
            System.out.println(top);
        }
        sc.close();
    }
}