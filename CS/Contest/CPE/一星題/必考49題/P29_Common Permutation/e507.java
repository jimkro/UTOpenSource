package CPE;
import java.util.*;

public class e507{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		
		while(sc.hasNext()){
			String a = sc.next();
			String b = sc.next();
			int[] table1 = new int[26];
			int[] table2 = new int[26];
			
			for(int i = 0; i < a.length(); i++){
				int temp = a.charAt(i);
				if(temp >= 97 & temp <= 122){
                    table1[temp-97] ++;
                }
			}

			for(int i = 0; i < b.length(); i++){
				int temp = b.charAt(i);
				if(temp >= 97 & temp <= 122){
                    table2[temp-97] ++;
                } 
			}
			
			for(int i = 0; i < 26; i++){
				int repeat = Math.min(table1[i],table2[i]);
				for(int j = 0 ; j < repeat; j++){
					System.out.print((char)(i+97));
				}
			}
			System.out.println();
		}
        sc.close();
	}
}