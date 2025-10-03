import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            // Input
            String line = sc.nextLine();
            Map<Integer,Integer> map = new HashMap<>(); // ASCII -> Frequence

            for(char c : line.toCharArray()){
                map.put((int)c,map.getOrDefault((int)c,0)+1);
            }

            List<Map.Entry<Integer,Integer>> sortedList = new ArrayList<>(map.entrySet());
            // Sort (1.Frequence 2.ASCII)
            sortedList.sort((m1,m2)->{
                if(m1.getValue() != m2.getValue()){
                    return m1.getValue() - m2.getValue();
                }
                return m2.getKey() - m1.getKey();
            });
            // Output
            for(Map.Entry<Integer,Integer> entry : sortedList){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
        sc.close();
    }
}
