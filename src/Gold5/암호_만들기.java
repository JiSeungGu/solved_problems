package Gold5;


import java.util.*;

public class 암호_만들기 {

    public static int L;
    public static int C;
    public static char[] arrays;
    public static List<Character> voew = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();

        C = sc.nextInt();

        arrays = new char[C];
        sc.nextLine();
        String temp = sc.nextLine();
        temp = temp.replaceAll(" ", "");
        arrays = temp.toCharArray();
        Arrays.sort(arrays);
        System.out.println(Arrays.toString(arrays));
        List<Character> list = new ArrayList<>();
//        dfs(0, L, vowels, 0);

        dfs(0, 0, 0, 0, "");
    }

    public static void dfs(int index, int count, int mo, int ja, String list) {


        if (count == L) {
            if (mo >= 1 && ja >= 2) {
                System.out.println(list);
            }
            return;
        }

        if (index >= arrays.length) return;

        char ch = arrays[index];

        boolean check = voew.contains(ch);

        list += ch;

        dfs(index + 1, count + 1, mo + (check ? 1 : 0), ja + (check ? 0 : 1), list);

        list = list.substring(0, list.length() - 1);

        dfs(index + 1, count, mo, ja, list);
    }
}

