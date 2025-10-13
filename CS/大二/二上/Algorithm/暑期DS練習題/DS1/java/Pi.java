import java.util.*;
class Pi{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(true){
            int limit=sc.nextInt();
            if(limit==0)break;
            Queue<Integer>res=new LinkedList<>();
            Queue<Integer>undo=new LinkedList<>();
            sc.nextLine();
            String str[]=sc.nextLine().split(" ");
            for(String s:str){
                int n=s.length(),number=0;
                for(int i=0;i<n;i++){
                    number*=10;
                    number+=s.charAt(i)-'0';
                }
                undo.offer(number);
            }
            while(!undo.isEmpty()){
                if(res.size()==limit){
                    int now=res.poll();
                    int upcom=undo.poll();
                    if(now>upcom){
                        res.add(now);
                        undo.add(upcom);
                    }
                    else{
                        res.add(upcom);
                        undo.add(now);
                    }
                    limit++;
                }
                else{
                    res.offer(undo.poll());
                }
            }
            while(res.size()!=1){
                System.out.print(res.poll()+" ");
            }
            System.out.print(res.poll());
            System.out.println("");
        }
        sc.close();
    }
}