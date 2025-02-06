package Silver2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 과자나눠주기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //조카 수
        int M = sc.nextInt();

        //과자의 수
        int N = sc.nextInt();

        //과자 길이
        int[] snack_length = new int[N];

        for (int i = 0; i < N; i++) {
            snack_length[i] = sc.nextInt();
        }

        int left = 1;
        int right = Arrays.stream(snack_length).max().getAsInt();
        int mid = 0;
        int sum = 0;
        int result = 0;
        while (left <= right) {

            mid = (left + right) / 2;

            for (int i = 0; i < N; i++) {
                sum += snack_length[i] / mid;
            }
            if (sum >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            sum = 0;
        }
        System.out.println(result);
    }
}
