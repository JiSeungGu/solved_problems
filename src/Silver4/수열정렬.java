package Silver4;

import java.util.Arrays;
import java.util.Scanner;

public class 수열정렬 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arrayA = new int[size];
        int[] arrayB = new int[size];
        int[] arrayP = new int[size];
        Boolean[] valuse = new Boolean[size];
        for (int i = 0; i < size; i++) {
            arrayA[i] = sc.nextInt();
            arrayP[i] = i;
            valuse[i] = false;
        }
        // 2, 1, 3, 1
        arrayB = Arrays.stream(arrayA).sorted().toArray();
        System.out.println("arrayA" + Arrays.toString(Arrays.stream(arrayB).toArray()));
        System.out.println(Arrays.stream(arrayA).min().getAsInt());
        int min = Arrays.stream(arrayA).min().orElse(0);
        int temp = 0;
        System.out.println("min :" + min);

        // 제일 작은거중에, 인덱스가 작은거를 찾아야함.
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                if(arrayA[i]==arrayB[j] && !valuse[j]) {
                    valuse[j] = true;
                    arrayP[i] = j;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(Arrays.stream(arrayP).toArray()));
    }
}

