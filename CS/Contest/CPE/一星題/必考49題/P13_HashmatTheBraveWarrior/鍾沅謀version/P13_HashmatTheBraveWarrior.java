//2024.10.14 Monday Night 16min finished
import java.util.*;
public class main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()){
			String temp = sc.nextLine();
			if(temp.isEmpty()) break;
			
			String[] t = temp.split(" ");
			long a = Long.parseLong(t[0]);
			long b = Long.parseLong(t[1]);
			
			if(a<b){
				System.out.println(b-a);
			}else{
				System.out.println(a-b);
			}
		
		}//end of while
	}
}