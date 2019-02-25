import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Q2 {

    private static HashMap<Integer, Integer> exp = new HashMap<>();
    private static HashMap<Integer, Double> integral = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.next());

        while (str.length() != 0) {
            parseNextExpression(str);
        }

        for (int i :
                exp.keySet()) {
            integral.put(i + 1, exp.get(i) / (double)(i + 1));
        }

        boolean f = false;
        List<Integer> keys = new ArrayList<>(integral.keySet());
        Collections.sort(keys);
        for(int i = keys.size() - 1; i >= 0; i--){
            printExpression(integral.get(keys.get(i)), keys.get(i), f);
            f = true;
        }

    }

    private static void add(int key, int value) {
        exp.put(key, exp.getOrDefault(key, 0) + value);
        if (exp.get(key) == 0) { exp.remove(key); }
    }

    private static void parseNextExpression(StringBuilder str) {

        int nextExp = 1;
        if (str.length() > 1) {
            int plusSign = str.indexOf("+", 1);
            int minusSign = str.indexOf("-", 1);
            if (plusSign == -1 && minusSign == -1) { nextExp = str.length(); }
            else if (plusSign > 0 && minusSign > 0) { nextExp = Math.min(plusSign, minusSign); }
            else { nextExp = Math.max(plusSign, minusSign); }
        }

        String thisExp = str.substring(0, nextExp);
        str.delete(0, nextExp);

        int xIndex = thisExp.indexOf('x');
        if (xIndex == -1) {
            add(0, Integer.parseInt(thisExp));
            return;
        }

        int zarib;
        if (xIndex == 0) {
            zarib = 1;
        } else {
            if (xIndex == 1 && thisExp.charAt(0) == '+') zarib = 1;
            else if (xIndex == 1 && thisExp.charAt(0) == '-') zarib = -1;
            else zarib = Integer.parseInt(thisExp.substring(0, xIndex));
        }
        int powerSignIndex = thisExp.indexOf('^');
        if (powerSignIndex == -1) {
            add(1, zarib);
            return;
        }
        add(Integer.parseInt(thisExp.substring(powerSignIndex + 1)), zarib);
    }

    private static void printExpression(Double z, int power, boolean f) {
        if (f && z > 0) {
            System.out.print('+');
        }
        if (z == -1) {
            System.out.print('-');
        }
        if (Math.abs(z) != 1) {
            final String pattern = "#.##";
            DecimalFormat df = new DecimalFormat(pattern);
            df.setRoundingMode(RoundingMode.DOWN);
            System.out.print(df.format(z));
        }
        if (power == 0) return;
        System.out.print('x');
        if (power != 1) {
            System.out.print("^" + power);
        }
    }

}
