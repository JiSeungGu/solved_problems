package Silver3;

import java.util.Scanner;

//1로만들기
public class One로만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();


        System.out.println(Math.min(calculation(x,0),
                calculation((x-1)%3 ==0 ? x-1 : x,1)
                ));

    }

    public static int calculation(int x,int count) {
        System.out.println("x 주입: "+x);
        System.out.println("count :"+count);
        while (!(x == 1)) {

            if ((x % 3 == 0)) {
                count++;
                x = x / 3;
                System.out.println("1x :"+x);
            } else if((x-1)%3 == 0 && x % 2 ==0 && (x-1)/3 < x/2 ) {
                count++;
                count++;
                x = (x-1) / 3;
                System.out.println("2x :"+x);
            }
            else if ((x % 2 == 0)) {
                count++;
                x = x / 2;
                System.out.println("3x :"+x);
            } else {
                count++;
                x -= 1;
                System.out.println("4x :"+x);
            }
        }
        System.out.println("count :"+count);
        return count;
    }
}
