package Silver1;


import java.util.Scanner;

public class 팔 {

    public static int solution(int min, int max) {
        int count = 0;
        int dls = 1;
        int sum = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int num = i;
            int numberlength = String.valueOf(i).length();
            int number = numberlength-1;
            Math.pow(10,number);
//            System.out.println("확인 :"+Math.pow(10,0));
            while (number >= 0) {
//                System.out.println("dls :"+dls);
//                System.out.println("무한반복인가.." + number);
//                System.out.println("(Math.pow(10, number) :"+(Math.pow(10, number)));
//                System.out.println("(Math.pow(10, number) :"+(int) (dls * (Math.pow(10, number))));
                dls = (int) (dls * (Math.pow(10, number)));
                if (num / dls  == 8) {
//                    System.out.println("count증가!");
                    count++;
                    num = (int) (num % dls);
//                    System.out.println("num 확인 "+num);
                } else {
                    num = (int) (num % dls);
//                    num -= (int) (i / Math.pow(dls, number) * (dls * number));
//                    System.out.println("num 확인 "+num);
                }
//                System.out.println("number :"+number);
                number--;
//                System.out.println("number :"+number);
                dls =1;
            }
            sum = Math.min(sum, count);
            count = 0;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(String.valueOf(888).length());
        int min = sc.nextInt();
        int max = sc.nextInt();

        System.out.println(solution(min, max));
    }
}
