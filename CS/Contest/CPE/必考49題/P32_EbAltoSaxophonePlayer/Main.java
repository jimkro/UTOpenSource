import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt(); //測資數量
        sc.nextLine(); //吸走換行符號

        //逐筆處理資料
        while(cases--!=0){

            //手指狀態 {編號,狀態,次數}
            int[][] data = {{0,0,0},{1,0,0},{2,0,0},{3,0,0},{4,0,0},{5,0,0},{6,0,0},{7,0,0},{8,0,0},{9,0,0},{10,0,0}}; //第一個{0,0,0}只是填充用的 這樣手指才能剛好對應到對的index(不用額外-1)
            //輸入的指令
            String cmd = sc.nextLine();
            //拿來暫存要讀的字串
            String current = "";
            for(char ch : cmd.toCharArray()){
                //把每個音調對應成要按的手指，要按就是1，不按就是0
                switch(ch){
                    case 'c':
                        current = "0111001111";
                        break;
                    case 'd':
                        current = "0111001110";
                        break;
                    case 'e':
                        current = "0111001100";
                        break;
                    case 'f':
                        current = "0111001000";
                        break;
                    case 'g':
                        current = "0111000000";
                        break;
                    case 'a':
                        current = "0110000000";
                        break;
                    case 'b':
                        current = "0100000000";
                        break;
                    case 'C':
                        current = "0010000000";
                        break;
                    case 'D':
                        current = "1111001110";
                        break;
                    case 'E':
                        current = "1111001100";
                        break;
                    case 'F':
                        current = "1111001000";
                        break;
                    case 'G':
                        current = "1111000000";
                        break;
                    case 'A':
                        current = "1110000000";
                        break;
                    case 'B':
                        current = "1100000000";
                        break;
                    default:
                        break;
                }
                //手指的按壓
                for(int i=1;i<=10;i++){
                    //原本狀態
                    int pass = data[i][1];
                    //變更狀態
                    if(current.charAt(i-1)=='0'){
                        data[i][1] = 0;
                    }else{
                        data[i][1] = 1;
                    }
                    //若原本沒按(0)現在按了(1)，就把按下次數+1
                    if(pass < data[i][1]){
                        data[i][2]++;
                    }

                }

            }
            //印出各個手指的按下總次數
            for(int i=1;i<=10;i++){
                if(i!=10){
                    System.out.print(data[i][2]+" "); //前面的要空格
                }else{
                    System.out.println(data[i][2]); //最後一個要換行
                }

            }
        }
    }

}