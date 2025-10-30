import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //測資數
        int testCases = sc.nextInt();
        //計次
        int times=1;

        while(testCases--!=0){
            //起始點
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            //目標點
            int goalX = sc.nextInt();
            int goalY = sc.nextInt();
            //計步器
            long counter = 0; //先把頭尾加進去
            //移動~
            if(startX==0 && startY == 0){
                startY = 1;
                counter++;
            }



            if((goalX+goalY) - (startX+startY) >1){ //相差大於一行
                counter += startY+goalX+1; //加1是為了左上往右下斜的那一步
                for(int i = startX+startY+2;i<goalX+goalY+1;i++){
                    counter+=i;
                }

            }else if((goalX+goalY) - (startX+startY)==1){ //相差一行
                counter += startY+goalX+1; //加1是為了左上往右下斜的那一步
            }else{//同行
                counter += startY - goalY; //算距離
            }
            

            //輸出
            System.out.println("Case "+times+": "+(counter));
            //計次
            times++;
        }
    }
}