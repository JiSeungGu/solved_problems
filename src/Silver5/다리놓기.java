package Silver5;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;


public class 다리놓기 {

    static BigInteger factorial(int n) {
        if (n == 1) {
            return BigInteger.valueOf(1);
        }
        return BigInteger.valueOf(n).multiply(factorial(n-1));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int west = sc.nextInt();
        int east = sc.nextInt();
        int count = 0;
        BigInteger mn = factorial(east - west);
        BigInteger n = factorial(west);
        BigInteger m = factorial(east);

        System.out.println("m! :"+m);
        System.out.println("n! :"+n);
        System.out.println("mn! :"+mn);

        System.out.println(m.divide(n.multiply(mn)));

        System.out.println(1/4);

//        int[] west_case = new int[west];
//        int[] east_case = new int[east];
//
//        Arrays.fill(east_case,0,west_case.length,1);
//        System.out.println(east_case.length);
//        System.out.println("초기 배열 "+Arrays.toString(east_case));
//        east_case[4] = 1;
//        System.out.println("초기 배열 ");
//        System.out.println(Arrays.toString(east_case));

//        for(int i = west_case.length-1; i>=0; i--) {
//            int k = west_case.length-1;
//            if(west_case.length==east_case.length) {
//                count++;
//                break;
//            }
//            count++;
//            System.out.println("i :"+i);
//            east_case[i] = 0;
//            for( int j = i+1; j < east_case.length; j++) {
//
//                System.out.println("횟수 :"+count);
////                k++;
//                System.out.println("j :"+j);
//
//                System.out.println("해당 순번의 값은? :"+east_case[j]);
//                if(east_case[j]==1 ) {
//                    System.out.println("그만");
//                      Arrays.fill(east_case,i,j-1,0);
//                      System.out.println(Arrays.toString(east_case));
//                      break;
//                  }
//                if(j == east_case.length-1)
//                {
//                    east_case[j] = 1;
//                    count++;
//                    Arrays.fill(east_case,i,j,0);
//                     System.out.println(Arrays.toString(east_case));
//                     break;
//                }
//                east_case[j] = 1;
//                System.out.println(Arrays.toString(east_case));
//                count++;
////                if(j == east_case.length-1) {
////                    Arrays.fill(east_case,west_case.length,j,0);
////                }
//            }
//        }
//        System.out.println("횟수 :"+count);
    }
}
