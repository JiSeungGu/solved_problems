package Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class 피보나치함수 {

//    public static int[] arrayV2;

//    public static int fibonacci(int n) {
//        if (n == 0) {
//            arrayV2[0] = 0;
//            return 0;
//        } else if (n == 1) {
//            arrayV2[1] = 1;
//            return 1;
//        }
//        return arrayV2[n] = fibonacci(n - 2) + fibonacci(n - 1);
//    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array_fibonacci = new int[n];
        for (int i = 0; i < n; i++) {
            array_fibonacci[i] = sc.nextInt();
        }
        // 피보나치 수열을 받은 입력중에 가장 큰수를 돌린다
        int[] arrayV2 = new int[Arrays.stream(array_fibonacci).max().getAsInt()+1];
        arrayV2[0] = 0;

        int max = Arrays.stream(array_fibonacci).max().getAsInt();
        if(max >= 1) {
            arrayV2[1] = 1;
            for (int i = 2; i <= max; i++) {
                arrayV2[i] = arrayV2[i-1] + arrayV2[i-2];
            }
        }
        for (int i = 0; i < n; i++) {
            if (array_fibonacci[i] > 1) {
                System.out.println(arrayV2[array_fibonacci[i] - 1] + " " + arrayV2[array_fibonacci[i]]);
            } else {
                System.out.println(array_fibonacci[i] == 0 ? "1 " + "0" :
                        "0 " + "1");
            }
        }
    }
}
