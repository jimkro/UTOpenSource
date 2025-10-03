//2024.10.8週二放學 費時64分鐘，和同學在圖書館以及芭比的播放下一次過了！！！
//A~Z: 65~90
//a~z: 97~122

import java.util.*;
public class Q7_WhatsCryptanalysis{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //////start//////
        int line = sc.nextInt();
        sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<line; i++){
            String[] t = sc.nextLine().split(""); // t = [n, e, x, t,  , l, i, n, e,  , h, a, h, a, p, p]
            for(int j=0; j<t.length; j++){ //讀當前列的每一個字元 t[j]
                int index = (int)t[j].charAt(0); //取得當前字元的ASCII code = index
                if(index >= 97 && index <= 122){ //如果是小寫字母
                    int newIndex = index - 32; //代表其大寫的ASCII code
                    char thingToMap = (char) newIndex;
                    if(map.containsKey(thingToMap)){
                        map.put(thingToMap, map.get(thingToMap) + 1);
                    }else{
                        map.put(thingToMap, 1);
                    }
                }else if(index >= 65 && index <=122){  //如果是大寫字母
                    char thingToMap = (char) index;
                    if(map.containsKey(thingToMap)){
                        map.put(thingToMap, map.get(thingToMap) + 1);
                    }else{
                        map.put(thingToMap, 1);
                    }
                }else{ //如果都不是
                    continue;
                }
            }
        }
        
        ////////以下開始狗屎環圈派對//////
        //System.out.println("派對開始");

        int maxNum = 0;
        for(char key : map.keySet()){
            if(map.get(key) > maxNum){
                maxNum = map.get(key);
            }
        } 

        while(maxNum != 1){
            for(char key : map.keySet()){
                if(map.get(key) == maxNum){ //抓到有maxNum的pair
                    System.out.println(key + " " + map.get(key));
                }
            } 
            maxNum--;
        }
    } 
}