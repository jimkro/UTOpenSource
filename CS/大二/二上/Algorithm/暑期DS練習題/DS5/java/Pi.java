// import java.util.*;
// public class Pi {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         while(sc.hasNextInt()){
//             int n=sc.nextInt();
//             Map<Integer,TreeNode>mpp=new HashMap<>();
//             Map<TreeNode,TreeNode>parent=new HashMap<>();
//             while(n-->1){
//                 int a=sc.nextInt();
//                 int b=sc.nextInt();
//                 TreeNode q=mpp.getOrDefault(a,new TreeNode(a));
//                 mpp.put(a,q);
//                 TreeNode q2=mpp.getOrDefault(b,new TreeNode(b));
//                 mpp.put(b,q2);
//                 parent.put(q2,q);
//             }
//             int n1=sc.nextInt(),n2=sc.nextInt();
//             TreeNode p=mpp.get(n1);
//             TreeNode q=mpp.get(n2);
//             TreeNode ans=dfs(parent,p,q);
//             System.out.println(ans.val);
//         }
//     }
//     static class TreeNode{
//         int val;
//         TreeNode(int val){
//             this.val=val;
//         }
//     }
//     private static TreeNode dfs(Map<TreeNode,TreeNode>parent,TreeNode p,TreeNode q){
//         Set<TreeNode>ance=new HashSet<>();
//         while(p!=null){
//             ance.add(p);
//             p=parent.get(p);
//         }
//         while(q!=null){
//             if(ance.contains(q))return q;
//             q=parent.get(q);
//         }
//         return null;
//     }
// }
import java.util.*;
public class Pi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            int node[]=new int[n];
            Arrays.fill(node,-1);
            for(int i=0;i<n-1;i++){
                int f=sc.nextInt(),c=sc.nextInt();
                node[c]=f;
            }
            int left=sc.nextInt(),right=sc.nextInt();
            Set <Integer>s1=new HashSet<>();
            Set <Integer>s2=new HashSet<>();
            s1.add(left);
            s2.add(right);
            while(true){
                int next1=node[left];
                if(next1!=-1){
                    s1.add(node[left]);
                    left=node[left];
                }
                int next2=node[right];
                if(next2!=-1){
                    s2.add(node[right]);
                    right=node[right];
                }
                if(s1.contains(next2)){
                    System.out.println(next2);
                    break;
                }
                if(s2.contains(next1)){
                    System.out.println(next1);
                    break;
                }
            }
        }
    }
   
}

