package Silver4;

import java.util.Scanner;

public class 토너먼트ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 참가자 수 (사용 안 해도 됨)
        int jimin = sc.nextInt();
        int hansu = sc.nextInt();
        int round = 0;

        while (jimin != hansu) {  // 두 사람이 만나면 종료
            jimin = (jimin + 1) / 2;
            hansu = (hansu + 1) / 2;
            round++;
        }

        System.out.println(round);
    }
}
