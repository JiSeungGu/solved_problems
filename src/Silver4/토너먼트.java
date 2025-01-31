package Silver4;


import java.util.*;

public class 토너먼트 {

    public static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int jimin = sc.nextInt();
        int hansu = sc.nextInt();

        List<Boolean> tonerments = new ArrayList<>(Collections.nCopies(N, false));
        tonerments.set(jimin - 1, true);
        tonerments.set(hansu - 1, true);

        for (int i = 0; i < N; i++) {
            tonerments = tonermentStart(tonerments);
            if (tonerments.size() == 1) {
                break;
            }
        }
    }

    public static List<Boolean> tonermentStart(List<Boolean> tonerments) {
        count++;
        List<Boolean> NextTonerments = new ArrayList<>();
        for (int i = 0; i < tonerments.size(); i += 2) {
            //상대선수가 없는경우
            if (i + 1 >= tonerments.size()) {
                NextTonerments.add(tonerments.get(i));
                break;
            }
            //지민이거나 한수인경우
            if (tonerments.get(i)) {
                //지민이거나 한수가 같이 싸우는경우
                if (tonerments.get(i + 1)) {
                    System.out.println(count);
                    NextTonerments.add(tonerments.get(i + 1));
                    //지민이랑 한수가 같이싸우지 않는경우
                } else {
                    NextTonerments.add(tonerments.get(i));
                }
                //지민이랑 한수가 같이 싸우지 않는 경우
            } else if (tonerments.get(i + 1)) {
                NextTonerments.add(tonerments.get(i + 1));
            } else if (!(tonerments.get(i) && tonerments.get(i + 1))) {
                NextTonerments.add(tonerments.get(i));
            }
        }
        return NextTonerments;
    }
}
