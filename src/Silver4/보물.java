package Silver4;

import java.util.*;

public class 보물 {

    public static void main(String[] args) {
//       Tip.  A,B라는 배열이 있었을대 B의 기준으로 A의 index를 내림차순 정렬을 하기 위해서.
//        Arrays.sort(B, (i, j ) -> B[j] - B[i])순으로 하면된다.
//        나는 처음에 while, for문으로 정리를 하려고 했어서 문제를 틀림.
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array_A = new int[size];
        int[] array_Atemp = new int[size];
        int[] array_B = new int[size];
        Integer[] array_Btemp = new Integer[size];  // B의 원래 위치를 저장할 인덱스 배열

        for (int i = 0; i < size; i++) array_A[i] = sc.nextInt();
        for (int i = 0; i < size; i++) {
            array_B[i] = sc.nextInt();
            array_Btemp[i] = i;
        }

//        int[] array_C = new int[size];
//
//        array_C = Arrays.copyOf(array_B, array_B.length);
//        Arrays.sort(array_C);

        // A를 오름차순 정렬은한다.
        Arrays.sort(array_A);

        // B순서대로 인덱스 변경
        Arrays.sort(array_Btemp,(i,j) -> array_B[j] - array_B[i]);

        // 가장 높은 값이 있는 B Index값에 A의 가장 작은값부터 기입.
        for (int i = 0; i < size; i++) {
            array_Atemp[array_Btemp[i]] = array_A[i];
        }

        // 저장된 순번으로 A를 정렬한다.
        array_A = Arrays.copyOf(array_Atemp,array_Atemp.length);
        int sum =0;
        for (int i = 0; i < size; i++) {
            sum += array_A[i] * array_B[i];
        }
        System.out.println(sum);
    }
}
