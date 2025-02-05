package Silver2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 나무자르기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Long M = sc.nextLong();
        int[] tree = new int[N];
        int[] treeM = new int[N];
        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
        }
//        Arrays.sort(tree, Comparator.reverseOrder());


//        int left = Arrays.stream(tree).min().getAsInt();
        int left = 0;
        int right = Arrays.stream(tree).max().getAsInt();
        long sum = 0;
        int half = 0;
        int result =0;
        while (left <= right) {
            half = (left + right) / 2;

            for (int i = 0; i < N; i++) {
                sum += (Math.max(tree[i] - half, 0));
            }

            if (sum >= M) {
                result = half;
                left = half+1;
            } else {
                right = half-1;
            }
            sum =0;
        }
        System.out.println(result);
    }
}
