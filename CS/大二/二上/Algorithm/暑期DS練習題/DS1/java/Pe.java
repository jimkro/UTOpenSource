import java.util.*;
public class Pe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String>lovebook=new ArrayList<>();
        while(sc.hasNextLine()){
            String str=sc.nextLine();
            if(str.equals("0"))break;
            StringBuilder word=new StringBuilder();
            StringBuilder output=new StringBuilder();
            int len=str.length();
            for(int i=0;i<len;i++){
                char c=str.charAt(i);
                if(Character.isLetter(c)){
                    word.append(c);
                }
                else{
                    if(word.length()>0){
                        String temp=word.toString();
                        word.setLength(0);
                        if(!lovebook.contains(temp)){
                            output.append(temp);
                            lovebook.add(0,temp);
                        }
                        else{
                            int index=lovebook.indexOf(temp);
                            output.append(index+1);
                            lovebook.remove(temp);
                            lovebook.add(0,temp);
                        }
                    }
                    output.append(c);
                }
            }
                if(word.length()>0){
                        String temp=word.toString();
                        word.setLength(0);
                        if(!lovebook.contains(temp)){
                            output.append(temp);
                            lovebook.add(0,temp);
                        }
                        else{
                            int index=lovebook.indexOf(temp);
                            output.append(index+1);
                            lovebook.remove(temp);
                            lovebook.add(0,temp);
                        }
                    }
                    
           System.out.println(output.toString());
        }
        sc.close();
    }
}
