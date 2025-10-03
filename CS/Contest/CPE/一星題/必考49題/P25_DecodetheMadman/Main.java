import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        String ori = "234567890-=ertyuiop[]\\dfghjkl;'cvbnm,./"; //原始碼
        String dec = "`1234567890qwertyuiop[asdfghjklzxcvbnm,"; //解碼版
        
        while(sc.hasNext()){
            String line = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            
            //讀數入的各個字元
            for(int i=0;i<line.length();i++){
                //對照原始碼表
                for(int j=0;j<ori.length();j++){
                    //找到了就去對應解碼表
                    if(line.charAt(i)==ori.charAt(j)){
                        sb.append(dec.charAt(j));
                        break;
                    }else if(line.charAt(i)==' '){ //空格直接存入
                        sb.append(' ');
                        break;
                    }
                }

            }
            //輸出
            System.out.println(sb.toString());
        }
    }
}