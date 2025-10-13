import java.util.*;
public class Pw {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String str=sc.nextLine();
            int n=str.length();
            Stack<Character>opr=new Stack<>();
            List<String>res=new ArrayList<>();
            int i=0;
            while(i<n){
                char c=str.charAt(i);
                if(Character.isDigit(c)){
                    StringBuilder sb=new StringBuilder();
                    while(i<n&&Character.isDigit(str.charAt(i))){
                        sb.append(str.charAt(i));
                        i++;
                    }
                    res.add(sb.toString());
                    continue;
                }
                else if(c=='('){
                    opr.push(c);
                }
                else if(c==')'){
                    while(opr.peek()!='('){
                        res.add(opr.pop()+"");
                    }
                    opr.pop();
                }
                else if(isopr(c)){
                    while(!opr.isEmpty()&&precendence(opr.peek())>=precendence(c)){
                        res.add(opr.pop()+"");
                    }
                    opr.add(c);
                }
                i++;
            }
            while(!opr.isEmpty()){
                res.add(opr.pop()+"");
            }
            System.out.println(String.join(" ", res));
            process(res);
        }
    }
    private static boolean isopr(char c){
        String a="+-*/";
        return a.indexOf(c)>=0;
    }
    private static int precendence(char c){
        if(c=='+'||c=='-')return 1;
        else if(c=='*'||c=='/')return 2;
        return 0;
    }
    private static void process(List<String>postfix){
        if(postfix.size()==1)return;
        List<String>temp=new ArrayList<>();
        Stack<String>num=new Stack<>();
        int n=postfix.size();
        for(int i=0;i<n;i++){
            String s=postfix.get(i);
            if(!isopr(s.charAt(0))||s.length()>1){
                num.add(s);
                temp.add(s);
            }
            else{
                int b=Integer.parseInt(num.pop());
                int a=Integer.parseInt(num.pop());
                int le=temp.size();
                int result=0;
                temp.subList(le-2, le).clear();
                switch(s){
                    case "+":result=a+b; break;
                    case "-":result=a-b; break;
                    case "*":result=a*b; break;
                    case "/":result=a/b; break;
                }
                temp.add(result+"");
                for(int j=i+1;j<n;j++){
                    temp.add(postfix.get(j));
                }
                System.out.println(String.join(" ",temp));
                break;
            }
        }
        process(temp);
    }
}
