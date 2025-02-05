package Silver2;

import java.util.*;

public class 한줄로서기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] numberValue = new int[N];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int x = sc.nextInt();
            list.add(x);
        }
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (numberValue[j] == 0) {
                    if (count == list.get(i)) {
                        numberValue[j] = i + 1;
                        break;
                    }

                    count++;
                }
//                System.out.println(Arrays.toString(numberValue));
            }
        }
        for (int k = 0; k < N; k++) {
            System.out.print(numberValue[k] + " ");
        }
    }
}