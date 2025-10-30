import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            double[][] points = new double[4][2];
            for(int i=0;i<4;i++){
                for(int j=0;j<2;j++){
                    points[i][j] = sc.nextDouble();
                }
            }
            double[] start = startPoint(points);
            double[] ans = new double[2];
            for(double[] point : points){
                if(!Arrays.equals(point,start)){
                    ans[0] += point[0];
                    ans[1] += point[1];
                }
            }
            ans[0] -= start[0];
            ans[1] -= start[1];
            
            System.out.printf("%.3f %.3f\n",ans[0],ans[1]);

        }
        sc.close();
    }
    private static double[] startPoint(double[][] points){
        for(int i=0;i<4;i++){
            double n1 = points[i][0];
            double n2 = points[i][1];
            for(int j=i+1;j<4;j++){
                if(n1 == points[j][0] && n2 == points[j][1]){
                    return new double[]{n1,n2};
                }
            }
        }
        return null;
    }
}