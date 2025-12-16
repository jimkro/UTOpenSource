import java.util.*;

public class e566 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long temp = a;
            boolean count = true;
            List<Long> arr = new ArrayList<Long>();
            arr.add(a);

            //隱藏測資有b = 0 (超壞!!!)
            if (b == 0){
                System.out.println("Boring!");
                count = false;
                temp = 0;
            }

            while (temp > 1){
                if (temp % b != 0){
                    System.out.println("Boring!");
                    count = false;
                    break;
                }else{
                    arr.add(temp / b);
                    temp /= b;
                }
            }

            if (count){
                for (int j = 0; j < arr.size(); j++){
                    System.out.print(arr.get(j) + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
