package Silver4;

import java.util.Arrays;
import java.util.Scanner;

public class 보물ver2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        Integer[] BIndex = new Integer[N];  // B의 원래 위치를 저장할 인덱스 배열

        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
            BIndex[i] = i;  // B의 원래 인덱스 저장
        }

        Arrays.sort(A);  // A를 오름차순 정렬

        // B의 값이 큰 순서대로 원래 인덱스를 정렬
        Arrays.sort(BIndex, (i, j) -> B[j] - B[i]);
        int[] sortedA = new int[N];  // B의 원래 순서를 유지하면서 A 배치
        for (int i = 0; i < N; i++) {
            sortedA[BIndex[i]] = A[i];  // B의 큰 값부터 A의 작은 값을 배치
        }

        // 최솟값 계산
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += sortedA[i] * B[i];
        }

        System.out.println(sum);
    }

}
