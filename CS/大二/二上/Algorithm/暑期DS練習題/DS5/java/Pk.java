import java.util.*;
class Pk{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String arr[]=sc.nextLine().trim().split("\\s+");
            int n=arr.length;
            if(arr[0].equals("None"))continue;
            TreeNode root=new TreeNode(Integer.parseInt(arr[0]),0);
            Queue<TreeNode>q=new LinkedList<>();
            q.add(root);
            int i=1;
            while(i<n&&!q.isEmpty()){
                TreeNode node=q.poll();
                if(node!=null&&i<n&&!arr[i].equals("None")){
                    node.left=new TreeNode(Integer.parseInt(arr[i]),i);
                    q.add(node.left);
                }
                else q.add(null);
                i++;
                if(node!=null&&i<n&&!arr[i].equals("None")){
                    node.right=new TreeNode(Integer.parseInt(arr[i]),i);
                    q.add(node.right);
                }
                else q.add(null);
                i++;
            }
            List<Integer>backtrack=new ArrayList<>();
            int temp[]=new int[1];
            dfs(backtrack,root,temp);
            }

    }
    static class TreeNode{
            int val;
            int seq;
            TreeNode left;
            TreeNode right;
            TreeNode(int val,int seq) {
                this.val=val;
                this.seq=seq;
            }
        }
    private static void dfs(List<Integer> backtrack,TreeNode node,int temp[]){
        if(node==null)return;
        temp[0]+=node.val;
        backtrack.add(node.seq);
        if(node.left==null&&node.right==null){
            int n=backtrack.size();
            System.out.print("The route ");
            for(int i=0;i<n-1;i++){
                System.out.print(backtrack.get(i)+"->");
            }
            System.out.println(backtrack.get(n-1)+" took "+temp[0]+".");
        }
        dfs(backtrack,node.left,temp);
        dfs(backtrack,node.right,temp);
        temp[0]-=node.val;
        backtrack.remove(backtrack.size()-1);
    }
}