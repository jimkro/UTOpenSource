//2024.10.14 Monday Nigth. 23min understand + 9min outline + 28min implement = 60min Finish~!
import java.util.*;
public class main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		
		for(int c=0; c<cases; c++){
			String temp = sc.nextLine();
			int days = sc.nextInt();
			int parties = sc.nextInt();
			
			//System.out.println("days: " + days);////test message
			//System.out.println("parties: " + parties);////test message
			
			HashMap<Integer, Boolean> map = new HashMap<>(); //record loss
			for(int p=0; p<parties; p++){ //run each party
				int CD = sc.nextInt();
				//System.out.println("p" + (p+1) + ": " + CD);////test message
				for(int d=CD; d<=days; d += CD){
					if((d % 7 != 0) && (d % 7 != 6)){
						map.put(d, true);
					}
				}
			}
			
			int loss = 0;
			for(int key : map.keySet()){
				loss++;
			}
			
			System.out.println(loss);
		}
	
	}
}