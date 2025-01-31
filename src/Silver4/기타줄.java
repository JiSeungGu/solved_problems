package Silver4;

import java.util.Arrays;
import java.util.Scanner;

public class 기타줄 {
    public static void main(String[] args) {

        // 끊어진 기타줄의 개수 N
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        // 기타줄 브랜드 M
        int brand = sc.nextInt();

        //6개묶음가격.
        int[] pakage = new int[brand];

        //단일 가격
        int[] onePrice = new int[brand];

        for (int i = 0; i < brand; i++) {
            pakage[i] = sc.nextInt();
            onePrice[i] = sc.nextInt();
        }

        int PakagePrice = (line/6) * Arrays.stream(pakage).min().getAsInt();
        int onebyone = 0;
        //패키지 + 낱개를 구매하는 경우
        if((line%6) * Arrays.stream(onePrice).min().getAsInt() > Arrays.stream(pakage).min().getAsInt()) {
            onebyone = Arrays.stream(pakage).min().getAsInt();
        } else {
            onebyone = (line%6) * Arrays.stream(onePrice).min().getAsInt();
        }

        //낱개만 구매하는경우를 모르고 안 넣었다. 문제를 신중하게 읽어야할듯.
        int minOne = line * Arrays.stream(onePrice).min().getAsInt();
        System.out.println(Math.min(onebyone+PakagePrice, minOne));
    }
}
