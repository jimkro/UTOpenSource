import java.util.*;
public class PC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T--!=0){
            int N = sc.nextInt();
            List<int[]> list = new ArrayList<>();

            for(int i=0;i<N;i++){
                int[] data = new int[3]; // (標號，天數，罰金)
                data[0] = i+1;
                data[1] = sc.nextInt();
                data[2] = sc.nextInt();
                list.add(data);
            }

            list.sort(new Comparator<int[]>(){
                public int compare(int[] m1, int[] m2) {
                    
                    double r1 = 1.0 * m1[2] / m1[1];
                    double r2 = 1.0 * m2[2] / m2[1];

                    //比值大的在前
                    if (r1 != r2) {
                        return Double.compare(r2, r1);
                    }
                    //編號小的在前
                    return m1[0] - m2[0];
                }
            });

            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)[0]+" ");
            }
            System.out.println();
        }
    }
}
