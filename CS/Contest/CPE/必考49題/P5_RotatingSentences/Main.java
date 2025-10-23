import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strData = new ArrayList<>();
        //把字串存入ArrayList
        while(sc.hasNextLine()){
            strData.add(sc.nextLine());
        }
        //找最長的字串長度
        int max = 0;
        for(int i=0;i<strData.size();i++){
            if(strData.get(i).length()>max){
                max = strData.get(i).length();
            }
        }
        //把字串長度補齊
        for(int i=0;i<strData.size();i++){
            while(strData.get(i).length()!=max){
                strData.set(i,strData.get(i)+' '); //要加空白字元以補齊長度
            }
        }
        //輸出
        for(int i=0;i<max;i++){ //第i個字元

            for(int j=strData.size()-1;j>=0;j--){ //第j個字串
                System.out.print(strData.get(j).charAt(i));
            }
            System.out.println(); //換行
        }
    }
}