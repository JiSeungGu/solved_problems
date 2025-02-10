package Algorithm;

import java.util.*;

public class ArraysTest {

    public static void main(String[] args) {

        String[] array = {"biski","apple", "banana", "kiwiA", "cherry"};

        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        System.out.println(Arrays.toString(array));
    }
}
