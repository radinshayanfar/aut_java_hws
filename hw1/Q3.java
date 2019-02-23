import java.util.Scanner;

/**
 * Q3
 */
public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder[] strings = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            strings[i] = new StringBuilder(sc.next());
        }
        if (n == 0) return;
        StringBuilder intersection = strings[0];
        for (int i = 1; i < n; i++) {
            intersection = stringIntersection(intersection, strings[i]);
        }
        System.out.print(intersection);
    }

    private static StringBuilder stringIntersection(StringBuilder s1, StringBuilder s2) {

        StringBuilder intersection = new StringBuilder();
        for (int i = 0; i < s1.length() - 1; i++) {
            for (int j = s1.length(); j >= i + 1 + intersection.length(); j--) {
                String t = s1.substring(i, j);
                if (s2.indexOf(t) != -1 || s2.reverse().indexOf(t) != -1) {
                    intersection = new StringBuilder(t);
                }
            }
        }
        return intersection;

    }
}