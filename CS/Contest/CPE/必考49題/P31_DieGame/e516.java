package CPE;
import java.util.*;

public class e516 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int times = sc.nextInt();

            if (times == 0){
                break;
            }
                            //上北下南   上東下西
            int[][] dice1 = {{1,2,6,5},{1,4,6,3}};
            int[][] dice2 = {{1,2,6,5},{1,4,6,3}};

            for (int i = 0; i < times; i++){
                String s = sc.next();

                switch(s){
                    case("north"):

                        for (int j = 1; j <= 3; j++){
                            dice2[0][j] = dice1[0][j-1];
                        }
                        dice2[0][0] = dice1[0][3];
                        dice2[1][0] = dice2[0][0];
                        dice2[1][2] = dice2[0][2];
                        break;

                    case("south"):
                        for (int j = 0; j < 3; j++){
                            dice2[0][j] = dice1[0][j+1];
                        }
                        dice2[0][3] = dice1[0][0];
                        dice2[1][0] = dice2[0][0];
                        dice2[1][2] = dice2[0][2];
                        break;

                    case("east"):
                        for (int j = 1; j <= 3; j++){
                            dice2[1][j] = dice1[1][j-1];
                        }
                        dice2[1][0] = dice1[1][3];
                        dice2[0][0] = dice2[1][0];
                        dice2[0][2] = dice2[1][2];
                        break;

                    case("west"):
                        for (int j = 0; j < 3; j++){
                            dice2[1][j] = dice1[1][j+1];
                        }
                        dice2[1][3] = dice1[1][0];
                        dice2[0][0] = dice2[1][0];
                        dice2[0][2] = dice2[1][2];
                        break;
                }

                for (int k = 0; k < 2; k++){
                    for (int z = 0; z < 4; z++){
                        dice1[k][z] = dice2[k][z];
                    }
                }
            }
            System.out.println(dice2[0][0]);
        }
        sc.close();
    }    
}
