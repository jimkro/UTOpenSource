import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int caseCount = 0;
        while(caseCount++<testCases){
            int[] costs = new int[36];
            for(int i=0;i<36;i++){
                costs[i] = sc.nextInt();
            }
            int queries = sc.nextInt();
            if(caseCount != 1) System.out.println();
            System.out.printf("Case %d:\n",caseCount);
            for(int i=0;i<queries;i++){
                int num = sc.nextInt();
                List<Integer> ans = new ArrayList<>();
                findCheapestBases(ans, costs, num);
                System.out.printf("Cheapest base(s) for number %d:",num);
                for(Integer a : ans){
                    System.out.print(" "+a);
                }
                System.out.println();
            }
        }
        sc.close();
        
    }
    private static void findCheapestBases(List<Integer> ans,int[] costs,int num){
        int minCost = Integer.MAX_VALUE;
        for(int base = 2;base<=36;base++){
            int cost = 0;
            int n = num;
            if(n == 0) cost = costs[0];
            while(n != 0){
                cost += costs[n % base];
                n /= base;
            }
            if(cost < minCost){
                minCost = cost;
                ans.clear();
                ans.add(base);
            }else if(cost == minCost){
                ans.add(base);
            }
        }
    }
}