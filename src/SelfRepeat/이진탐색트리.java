package SelfRepeat;

import java.util.*;

public class 이진탐색트리 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int M = sc.nextInt();

        int[] array = new int[N];
        int right =0;
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
            right += array[i];
        }

        int left = Arrays.stream(array).max().getAsInt();
        int result =0;
        while( left <= right ) {
            int mid = (left+right)/ 2;

            int count=1;
            int sum=0;
            for(int i=0; i<N ; i++) {
                if((sum + array[i]) > mid) {
                    count++;
                    sum = array[i];
                } else {
                    sum += array[i];
                }
            }

            if(count <= M) {
                result = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        System.out.println(result);
    }
}
