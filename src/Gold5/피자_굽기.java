package Gold5;

import java.util.*;

public class 피자_굽기 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int D = sc.nextInt();
        int N = sc.nextInt();

        int[] depth = new int[D];
        int[] meal = new int[N];
        for (int i = 0; i < D; i++) {
            depth[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            meal[i] = sc.nextInt();
        }

        for (int i = 1; i < D; i++) {
            depth[i] = Math.min(depth[i], depth[i - 1]);
        }
        int depthlength = D;
        for (int i = 0; i < N; i++) {
            while (depthlength > 0 && depth[depthlength - 1] < meal[i]) {
                depthlength--;
            }
            if (depthlength == 0) {
                System.out.println(0);
                return;
            }
            //피자를 넣었으니까 깊이를 줄임.
            depthlength--;
        }
        System.out.println(depthlength+1);
    }
}
