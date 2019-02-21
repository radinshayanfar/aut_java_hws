import java.util.Scanner;

/**
 * Q1
 */
public class Q1 {

    static char[][] arr = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.next().charAt(0);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != '*') {
                    arr[i][j] = (char)(mineCount(i, j) + '0');
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int charProcess(char c) {
        return (c == '*') ? 1 : 0;
    }

    static int mineCount(int x, int y) {
        int n = arr.length;
        int m = arr[0].length;

        int count = 0;
        if (x != 0) {
            if (y != 0) count += charProcess(arr[x - 1][y - 1]);
            count += charProcess(arr[x - 1][y]);
            if (y != m - 1) count += charProcess(arr[x - 1][y + 1]);
        }
        if (y != 0) count += charProcess(arr[x][y - 1]);
        if (y != m - 1) count += charProcess(arr[x][y + 1]);
        if (x != n - 1) {
            if (y != 0) count += charProcess(arr[x + 1][y - 1]);
            count += charProcess(arr[x + 1][y]);
            if (y != m - 1) count += charProcess(arr[x + 1][y + 1]);
        }

        return count;
    }
}