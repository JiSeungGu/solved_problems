package Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class 땅따먹기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int board = sc.nextInt();
        sc.nextLine();  // 🚀 개행 문자 제거!

        String[] civilwar = new String[board];
        for (int i = 0; i < board; i++) {
            civilwar[i] = sc.nextLine();
        }

        for (int i = 0; i < board; i++) {
            long size = Long.parseLong(civilwar[i].split(" ")[0]);
            double sizehalf = (double) size / 2.0;

            String[] tokens = civilwar[i].split(" ");  // 공백으로 분리된 배열 생성
            String[] realcivilwar = Arrays.copyOfRange(tokens, 1, tokens.length); // 첫 번째 숫자 제외하고 복사

            long[] army = new long[(int) size];
            int number = 0;
            for (String armynumber : realcivilwar) {

                army[number] = Long.parseLong(armynumber);
                number++;
            }
            //오름차순 정렬
            Arrays.sort(army);
            long[] distinct = Arrays.stream(army).distinct().toArray();

            long start = army[0];
            int count = 1;
            int maxNumberArray = 0;
            int[] maxNumber = new int[distinct.length];
            for (int j = 1; j < size; j++) {
                if (start == army[j]) {
                    count++;
                }
                if (!(start == army[j]) || j + 1 == size ) {
                    maxNumber[maxNumberArray] = count;
                    start = army[j];
                    maxNumberArray++;
                    count = 1;
                }
            }

            int maxCount = 0;
            long target = -1;

            for (int k = 0; k < distinct.length; k++) {
                if (maxNumber[k] > maxCount) {  // ✅ 가장 많이 등장한 군대 번호 찾기
                    maxCount = maxNumber[k];
                    target = distinct[k];
                }
            }
            // ✅ 절반 이상인지 검사 후 출력
            if ((double) maxCount > sizehalf) {  // 🚀 `>=`로 수정해야 함!
                System.out.println(target);
            } else {
                System.out.println("SYJKGW");
            }
        }
    }
}