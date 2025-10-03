import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        while (testCases--!=0){
            Map<String,Integer> map = new HashMap<>();
            int sum = 0;
            while(true){
                if(!sc.hasNextLine()) break;
                String tree = sc.nextLine();
                if(tree.isEmpty()){
                    break;
                }
                map.put(tree,map.getOrDefault(tree,0)+1);
                sum++;
            }
            ArrayList<String> arr = new ArrayList<>(map.keySet());
            Collections.sort(arr);
            for(String tree : arr){
                System.out.printf("%s %.4f\n",tree,(double)map.get(tree)/sum * 100);
            }
            
            
        }
        
    }
}