import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        while(sc.hasNext()){
            //計數
            counter++;
            //跳過條件
            boolean iscontinue = false;
            //陣列大小
            int size = sc.nextInt();
            //接收數列
            int[] data = new int[size];
            for(int i=0;i<size;i++){
                data[i] = sc.nextInt();
            }
            //檢查是否符合 "1<= b1 < b2 < b3 ..."
            for(int i=1;i<size;i++){
                if(data[i-1]<1 && data[i]<=data[i-1] ){
                    System.out.println("Case #"+counter+": It is not a B2-Sequence.");
                    iscontinue = true;
                    break;
                }
            }
            //跳過
            if(iscontinue) break;
            //檢查是否符合"其中所有的 bi + bj （i <= j）皆不相等"
            Set<Integer> set = new HashSet<>(); //存出現過的東西
            for(int i=0;i<size;i++){
                for(int j=i;j<size;j++){
                    if(!set.contains(data[i]+data[j])){ //若沒出現過就加入set中
                        set.add(data[i]+data[j]);
                    }else{ //若有出現過就輸出不適
                        System.out.println("Case #"+counter+": It is not a B2-Sequence.");
                        iscontinue = true;
                        break;
                    }
                }
                if(iscontinue) break;
            }
            if(iscontinue) continue;
            //都通過了的輸出
            System.out.println("Case #"+counter+": It is a B2-Sequence."); 
        



        }
    }
}