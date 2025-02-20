package Gold5;

import java.util.*;

public class 감소하는_수 {

    public static ArrayList<Long> list;
    public static int num;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        num = sc.nextInt();

        list = new ArrayList<>();
//            int count=1;
//            int target[] = new int[num];
            for(int i=0; i<=9;i++) {
                dfs(i,i);
            }


        Collections.sort(list);

         if(num >= list.size()) System.out.println(-1);
         else   System.out.println(list.get(num));

    }

    public static void dfs(long currentNum, int lastDigit) {

        list.add(currentNum);

        for(int i = lastDigit -1 ; i>=0;i --) {
            dfs( currentNum *10 +i, i);
        }
    }
}
