// import java.util.*;

// public class Pb {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String tokens[] = sc.nextLine().split(" ");
//         int n = tokens.length;
//         long prefix[]=new long[n+1];
//         long max=0,curr=0;
//         for (int i=0;i<n;i++){
//             int temp=Integer.parseInt(tokens[i]);
//             prefix[i + 1]=prefix[i]+temp;
//             curr=Math.max(temp,curr+temp);
//             if(curr>max)max=curr;
//         }
//         StringBuilder sb=new StringBuilder();

//         while(sc.hasNextInt()) {
//             int q=sc.nextInt();
//             if(q>max){
//                 sb.append(0).append('\n');
//                 continue;
//             }
//             int res=n+1;
//             Deque<Integer> d=new ArrayDeque<>();
//             for (int i=0;i<=n;i++) {
//                 while(!d.isEmpty()&&prefix[i]-prefix[d.getFirst()]>=q)
//                     res=Math.min(res,i-d.pollFirst());
//                 while(!d.isEmpty()&&prefix[i]<=prefix[d.getLast()])
//                     d.pollLast();
//                 d.addLast(i);
//             }
//             sb.append(res).append('\n');
//         }
//         System.out.print(sb);
//     }
// }

import java.io.*;
import java.util.*;

public class Pb {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        String line=br.readLine();
        if (line==null||line.isEmpty()) return; 
        StringTokenizer st=new StringTokenizer(line);

        int n=st.countTokens();
        long[]prefix=new long[n+1];
        long max=0,curr=0;

        for (int i=0;i<n;i++) {
            int temp=Integer.parseInt(st.nextToken());
            prefix[i+1]=prefix[i]+temp;
            curr=Math.max(temp,curr+temp);
            if(curr>max)max=curr;
        }

        while((line=br.readLine())!=null&&!line.isEmpty()) {
            int q=Integer.parseInt(line.trim());
            if (q>max) { 
                sb.append(0).append('\n');
                continue;     
            }

            int res=n+1;
            Deque<Integer>d=new ArrayDeque<>();

            for(int i=0;i<=n;i++) {
                while(!d.isEmpty()&&prefix[i]-prefix[d.getFirst()]>=q) {
                    res = Math.min(res,i-d.pollFirst());
                    if(res==1)break;
                }
                if(res==1) break; 

              
                while(!d.isEmpty()&&prefix[i]<=prefix[d.getLast()])
                    d.pollLast();
                d.addLast(i);
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }
}
