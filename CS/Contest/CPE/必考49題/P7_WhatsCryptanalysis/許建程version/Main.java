import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //測資行數
        sc.nextLine(); //吃掉換行
        String[] lines = new String[N];
        //輸入並轉成大寫
        for(int i=0;i<N;i++){
            lines[i] = sc.nextLine().toUpperCase();
        }
        //建立ArrayList來存字母和數量
        ArrayList<Character> charData = new ArrayList<>(); 
        ArrayList<Integer> countData = new ArrayList<>();
        //讀字串找字母
        for(String line : lines){ //讀字串

            for(char c : line.toCharArray()){ //讀字元

                if(c-'A'>=0 && c-'A'<=25){ //若是A~Z
                    if(!charData.contains(c)){ //沒有的話就建立
                        charData.add(c);
                        countData.add(1);
                    }else{ //已經有的話就加1
                        countData.set(charData.indexOf(c),countData.get(charData.indexOf(c))+1);
                    }

                }
            }
        }
        //排序1 (依照出現次數排好(Bubble Sort))
        for(int i=1;i<charData.size();i++){
            for(int j=1;j<charData.size()-i+1;j++){
                if(countData.get(j-1)<countData.get(j)){
                    //交換
                    char chTemp = charData.get(j);
                    int coTemp = countData.get(j);
    
                    charData.set(j,charData.get(j-1));
                    countData.set(j,countData.get(j-1));
    
                    charData.set(j-1,chTemp);
                    countData.set(j-1,coTemp);
    
                }
            }
           
        }
        //排序2 (把出現次數相同但字母順序不對的排好)
        for(int i=1;i<charData.size();i++){
            for(int j=1;j<charData.size()-i+1;j++){
                if(countData.get(j-1)==countData.get(j) && charData.get(j-1)>charData.get(j)){ //例如 A,B A比較小所以要在前面
                    //交換
                    char chTemp = charData.get(j);
                    int coTemp = countData.get(j);
    
                    charData.set(j,charData.get(j-1));
                    countData.set(j,countData.get(j-1));
    
                    charData.set(j-1,chTemp);
                    countData.set(j-1,coTemp);
    
                }
            }
           
        }
        //輸出
        for(int i=0;i<charData.size();i++){
            System.out.println(charData.get(i)+" "+countData.get(i));
        }
    }
}