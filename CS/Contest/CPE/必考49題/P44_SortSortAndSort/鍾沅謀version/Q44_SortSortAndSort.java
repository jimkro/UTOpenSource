//2024.10.10週四國慶日 和媽媽姐姐在振興星巴克。約90分鐘完成，但是平台一直不給過，最後過了2.5個小時仍然沒有AC 真哭了啊啊啊啊啊 
//更：當天晚上又花了87分鐘，終於AC 超感動本來都啊算去睡了。想不到這次是HashMap背叛我，虧我那麼相信你TwT #小偏難
//共計：約4小時AC!
import java.util.*;
public class Q44_SortSortAndSort{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            //System.out.println("start of loop!");/* test message */
            String[] mn = sc.nextLine().split(" ");
            if(mn[0].equals("0") && mn[1].equals("0")){
                break;
            }
            //System.out.println("mn: " + Arrays.toString(mn));/* test message */
            int n = Integer.parseInt(mn[0]);
            int m = Integer.parseInt(mn[1]);
            //System.out.println("n = " + n + ", m = " + m);/* test message */
            //開始處理n個輸入
            int minMod = 999999999;
            ArrayList<Integer> L1 = new ArrayList<>(); //原本的值, mod過後的值
            for(int i=0; i<n; i++){
                int currentNum = sc.nextInt();
                sc.nextLine();

                if((currentNum % m) < minMod){
                    minMod = (currentNum % m);
                }
                L1.add(currentNum);
                L1.add(currentNum % m);
            }
            
            int afterMod = minMod;

            System.out.println(n + " " + m);
            while(afterMod <= (m-1)){ //每一輪處理一次aftermod的值

                ArrayList<Integer> oddList = new ArrayList<>();
                ArrayList<Integer> evenList = new ArrayList<>();
                for(int L=1; L<=(L1.size()-1); L+=2){ // L 代表mod值的index
                    int key = L1.get(L);
                    if(key == afterMod){ //如果這對數的mod值是當前要討論的

                        if(L1.get(L-1) % 2 == 0){ //是偶數
                            evenList.add(L1.get(L-1));
                        }else{ //是奇數
                            oddList.add(L1.get(L-1));
                        }
                    }
                }

                ///////輸出區///////
                //先輸出奇數(大到小)，再輸出偶數(小到大)
                Collections.sort(oddList, Collections.reverseOrder());
                Collections.sort(evenList);
                
                //System.out.println("oddList:" + oddList);/* test message */
                //System.out.println("evenList:" + evenList);/* test message */

                for(int o=0; o<oddList.size(); o++){
                    System.out.println(oddList.get(o));
                }
                for(int e=0; e<evenList.size(); e++){
                    System.out.println(evenList.get(e));
                }
                ///////輸出區結束///////
                afterMod++; //進入下一組mod值
            }
        } //end of while-loop
        System.out.println("0 0");
    } //end of main
} //end of class
