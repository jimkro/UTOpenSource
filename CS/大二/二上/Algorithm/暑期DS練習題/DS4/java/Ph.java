import java.util.*;
public class Ph {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String arr[]=sc.nextLine().split(" ");
            TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
            Queue<TreeNode>q=new LinkedList<>();
            q.offer(root);
            int n=arr.length;
            int i=1;
            while(!q.isEmpty()&&i<n){
                TreeNode node=q.poll();
                if(i<n&&!arr[i].equals("None")){
                    node.left=new TreeNode(Integer.parseInt(arr[i]));
                    q.offer(node.left);
                }
                else q.offer(null);
                i++;
                if(i<n&&!arr[i].equals("None")){
                    node.right=new TreeNode(Integer.parseInt(arr[i]));
                    q.offer(node.right);
                }
                else q.offer(null);
                i++;
            }
            int total=totalSum(root);
            long ans[]=new long[1];
            product(root,total,ans);
            System.out.println(ans[0]);
        }
        sc.close();

    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    private static int totalSum(TreeNode node){
        if(node==null)return 0;
        return node.val+totalSum(node.left)+totalSum(node.right);
    }
    private static long product(TreeNode node,int total,long ans[]){
        if(node==null) return 0;
        long subSum=(long)node.val+product(node.left,total,ans)+product(node.right,total,ans);
        ans[0]=Math.max(ans[0],subSum*(total-subSum));
        return subSum;

    }
}
