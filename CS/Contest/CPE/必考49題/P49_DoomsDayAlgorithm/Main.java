import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //建立月份換算天數對照(2011非閏年故二月只有28天)
        HashMap<Integer,Integer> monthdays = new HashMap<>();

        monthdays.put(1,31);
        monthdays.put(2,28);
        monthdays.put(3,31);
        monthdays.put(4,30);
        monthdays.put(5,31);
        monthdays.put(6,30);
        monthdays.put(7,31);
        monthdays.put(8,31);
        monthdays.put(9,30);
        monthdays.put(10,31);
        monthdays.put(11,30);
        monthdays.put(12,31);

        //input
        int cases = sc.nextInt();

        while(cases--!=0){
            int month = sc.nextInt();
            int day = sc.nextInt();
            int sumOfDay = 0;
            int FIRSTDAY = 1;
            
            //計算總天數
            //月換日
            for(int i=1;i<month;i++){
                sumOfDay += monthdays.get(i);
            }
            //總和
            sumOfDay += day;
            int gap = sumOfDay - FIRSTDAY;

            //求星期
            switch (gap%7) {
                case 0: 
                    System.out.println("Saturday");
                    break;
                case 1:
                    System.out.println("Sunday");
                    break;
                case 2:
                    System.out.println("Monday");
                    break;
                case 3:
                    System.out.println("Tuesday");
                    break;
                case 4:
                    System.out.println("Wednesday");
                    break;
                case 5:
                    System.out.println("Thursday");
                    break;
                case 6:
                    System.out.println("Friday");
                    break;
                default:
            }

        }
    }
}