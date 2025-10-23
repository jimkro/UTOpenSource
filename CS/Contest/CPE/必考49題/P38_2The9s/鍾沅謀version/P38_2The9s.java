import java.util.*;
public class P38_2The9s{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()){
			String l = sc.nextLine();
			if(l.equals("0")){
				break;
			}
			
			int ans = 0;
			int degree = nine_degree(l, ans);
			
			if(!(degree == -1)){
				System.out.println(l + " is a multiple of 9 and has 9-degree " + degree + ".");
			}else{
				System.out.println(l + " is not a multiple of 9.");
			}

		}//end of while
	}//end of main 
	
	public static int nine_degree(String num, int ans){
		if(num.length() == 1){
			if(num.equals("9")){
				if(ans == 0) ans++;
				return ans;
			}else{
				return -1;
			}
		}else{
			ans++;
			int S = 0;
			for(int i=0; i<num.length(); i++){
				S += num.charAt(i) - '0';
			}
			String new_num = (S + "");
			return nine_degree(new_num, ans);
		}
		
	}//end of nine_degree
}
