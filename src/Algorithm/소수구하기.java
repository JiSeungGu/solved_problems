package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소수구하기 {


    //소수 개수를 구할때
    public static int getPrimeCount(int number) {

        int count = 0;
        int num = number;
        if (number < 2) return 0; //1은 소수 하나


        //2으로 나눠질때까지
        while (number % 2 == 0) {
            count++;
            num /= 2;
        }

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                count++;
                num /= i;
            }
        }

        if (num > 1) count++;

        return count;
    }

    //소수 리스트를 구할때
    public static List getPrimelist(int number) {

        int num = number;
        List<Integer> list = new ArrayList<>();

        while (num % 2 == 0) {
            list.add(2);
            num /= 2;
        }

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                list.add(i);
                num /= i;
            }
        }

        if (num > 1) list.add(num);

        return list;
    }

    //단일 소수 판별
    public static boolean isPrime(int number) {
        int num = number;

        if (num < 2) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }

        return true;
    }

    //다중 소수 판별 (에라토스테네스의 체)
    public static boolean[] isManyPrime(int Max) {

        boolean[] isPrime = new boolean[Max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;


        for (int i = 2; i * i <= Max; i++) {
            if (isPrime[i])
                for (int j = i; j * j <= Max; j += i) {
                    isPrime[j] = false;
                }
        }



        return isPrime;
    }


    public static void main(String[] args) {

    }
}
