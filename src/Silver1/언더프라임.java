package Silver1;

import java.util.*;

public class 언더프라임 {

//    에라토스테네스의 체
//    static boolean isPrime(int n){ // 시간복잡도 O(N)
//        if(n<2){
//            return false; // 1은 소수가 아니기에 false
//        }else{
//            for(int i = 2; i < n; i++){
//                if(n % i == 0) return false; // 나머지연산을 했을 때 0이 나오면 소수가 아니므로 false
//            }
//            return true; // 위의 case
//        }
//    }

    public static boolean[] getPrimeArray(int n) {
        boolean[] isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static int solution(int min, int max) {
        int count = 0;

        int result = 0;
        boolean[] isPrime = getPrimeArray(max + 1);
        int[] arraySub = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            if (isPrime[i]) arraySub[i] = i;
        }
//        System.out.println("Arrays.toString(arraySub) : "+ Arrays.toString(arraySub));
        for (int i = min; i <= max; i++) {
//            System.out.println("새로 시작하는 숫자 :"+i);
            List<Integer> numberList = new ArrayList<>();

            int number = i;

            while (number != 0 && number != 1) {

                if (arraySub[count] == 0) {
//                    System.out.println("arraySub[count] == 0 : "+arraySub[count]);
//                    System.out.println("count : "+count);
                    count++;
                    continue;
                }
                if (number % arraySub[count] == 0) {
//                    System.out.println("arraySub[count] : "+arraySub[count]);
                    numberList.add(arraySub[count]);
                    number /= arraySub[count];
                } else if (arraySub[count] < number) {
//                    System.out.println("arraySub[count] < number 조건");
                    count++;
                } else {
                    break;
                }
            }
            count = 0;

            if (isPrime[numberList.size()]) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();

        System.out.println(solution(min, max));
    }
}
