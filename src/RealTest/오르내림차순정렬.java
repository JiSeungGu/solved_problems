package RealTest;

import java.util.*;

public class 오르내림차순정렬 {

    public static int[] solution(int[] arr) {

        //정렬후 가운데 기준 값 빼낸다.
        Arrays.sort(arr);
        System.out.println("길이 " + arr.length);
        arr = Arrays.stream(arr).distinct().toArray();
        int[] result = new int[arr.length];
        System.out.println("길이 " + arr.length);
        List<Integer> two = new ArrayList<>();
        List<Integer> one = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr.length % 2 == 0) {
                if (i < arr.length / 2) one.add(arr[i]);
                else two.add(arr[i]);
            } else {
                if (i <= arr.length / 2) one.add(arr[i]);
                else two.add(arr[i]);

            }
        }
        System.out.println(Arrays.toString(arr));
        one.sort(Collections.reverseOrder());
        Collections.sort(two);

        System.out.println(Arrays.toString(one.toArray()));
        System.out.println(Arrays.toString(two.toArray()));

        int oneCount = 0;
        int twoCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) % 2 == 0) result[i] = two.get(twoCount++);
            else result[i] = one.get(oneCount++);
        }
        System.out.println("출력: " + Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {

        solution(new int[]{50, 98, 38, 11, 13, 90, 82, 83, 70});
        solution(new int[]{3, -2, 8, 5, 3, 9});
        solution(new int[]{3, 6, 7, 7, 2, 6, 0, -2, 6, -1, 13});


    }
}
