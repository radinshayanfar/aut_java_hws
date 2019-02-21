import java.util.Scanner;

/**
 * Q4
 */
public class Q4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        for (int i = input.length(); i > 0; i--) {
            if (balancedParanthesis(input.substring(0, i))) {
                System.out.print(input.substring(0, i));
                break;
            }
        }
    }

    static boolean balancedParanthesis(String s) {
        int open = 0, close = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i)) == '(') open++;
            if ((s.charAt(i)) == ')') close++;
            if (close > open) return false;
        }
        return (open == close) ? true : false;
    }
}