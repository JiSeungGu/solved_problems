package Silver1;

import java.util.*;

public class 음하철도_구구팔 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int current_x = sc.nextInt();
        int current_y = sc.nextInt();

        int dx = sc.nextInt();
        int dy = sc.nextInt();

//        int plus_value = gcd(dx, dy);
        int plus_value = gcd(Math.min(dx, dy), Math.max(dx, dy));
        dx /= plus_value;
        dy /= plus_value;
//        int count = Integer.MAX_VALUE;
//        int count = Math.abs(current_x - x) + Math.abs(current_y - y);
        int count = (current_x - x) * (current_x - x) + (current_y - y) * (current_y - y);
        int[] close_x = new int[1];
        int[] close_y = new int[1];
        close_x[0] = current_x;
        close_y[0] = current_y;

//        while(current_x != x && current_y != y) {
        while (true) {
            current_x += dx;
            current_y += dy;

            int new_dist = (current_x - x) * (current_x - x) + (current_y - y) * (current_y - y);
//            int new_dist = Math.abs(current_x - x) + Math.abs(current_y - y);
            if (new_dist >= count) break;  // 거리가 줄어들지 않으면 종료
//            if (current_x > 100 && current_y > 100) break;
//            if (Math.abs(current_x - x) + Math.abs(current_y - y) >= count) break;

//            if (plus_value != 1) {

//                current_x += dx / plus_value;
//                current_y += dy / plus_value;

//            } else {

//            }

//            if(current_x>0 && current_y>0 && current_x<=x && current_y<=y) {
//            if(current_x>0 && current_y>0) {
//            if (Math.abs(current_x - x) + Math.abs(current_y - y) < count) {

//                int temp = Math.min(
//                        (Math.abs(current_x - x) + Math.abs(current_y - y)), count);
//                );

//                if (temp < count) {
            count = new_dist;
            close_x[0] = current_x;
            close_y[0] = current_y;
//                }
//            } else {
//                break;
//            }
        }

        System.out.println(close_x[0] + " " + close_y[0]);
    }

    //유클리드 호재법을 이용한 최대 공약수 구하는 함수
    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}

//    public static int gcd(int x, int y) {
//        if (y == 0) return Math.abs(x);  // 절댓값만 유지
//        return gcd(y, x % y);
//    }
//
//    public static int gcd(int x, int y) {
//
//        if (y == 0) return x;
//        return gcd(y, x % y);
//    }
