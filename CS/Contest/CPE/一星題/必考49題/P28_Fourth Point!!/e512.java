package CPE;
import java.util.*;

public class e512 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextDouble()){
			double point[][] = new double[4][2];
			double same[] = new double[2];
            double x = 0;
            double y = 0;

			for(int i = 0 ;i < 4; i++){
				for(int j = 0; j < 2; j++){
					point[i][j] = sc.nextDouble(); //儲存座標
				}
				//找相同座標
				for(int j = 0; j < i; j++){
					if (point[j][0] == point[i][0] && point[j][1] == point[i][1]){
						same[0] = point[i][0];
						same[1] = point[i][1];
					}
				}
			}
			
			//兩對角線相加
			for(int i = 0; i < 4; i++){
				if (!(point[i][0] == same[0] && point[i][1] == same[1])){
					x += point[i][0];
					y += point[i][1];
				}
			}

			System.out.printf("%.3f %.3f", x-same[0], y-same[1]);
			System.out.println();
		}
        sc.close();
    }
}
