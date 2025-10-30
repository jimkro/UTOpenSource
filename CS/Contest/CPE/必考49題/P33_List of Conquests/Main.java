import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        
        Map<String,Integer> map = new TreeMap<>();
        while (testCases--!=0){
            String country = sc.next();
            sc.nextLine();
            map.put(country,map.getOrDefault(country,0)+1);
        }   

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.printf("%s %d\n",entry.getKey(),entry.getValue());
        }
        sc.close();
        
    }
}