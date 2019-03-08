import java.util.Scanner;

class Matrix {
    private int[][] matrix;

    public Matrix(int rows, int columns) {
        matrix = new int[rows][columns];
    }

    public void setValue(int row, int column, int value) {
        matrix[row][column] = value;
    }

    public int getValue(int row, int column) {
        return matrix[row][column];
    }

    public void fillValues() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                setValue(i, j, sc.nextInt());
            }
        }
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(getValue(i, j) + " ");
            }
            System.out.println();
        }
    }

    public Matrix add(Matrix m2) {
        if (this.matrix.length != m2.matrix.length || this.matrix[0].length != m2.matrix[0].length) {
            return null;
        }
        Matrix m3 = new Matrix(this.matrix.length, this.matrix[0].length);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                m3.setValue(i, j, this.getValue(i, j) + m2.getValue(i, j));
            }
        }
        return m3;
    }

    public Matrix subtract(Matrix m2) {
        if (this.matrix.length != m2.matrix.length || this.matrix[0].length != m2.matrix[0].length) {
            return null;
        }
        Matrix m3 = new Matrix(this.matrix.length, this.matrix[0].length);
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                m3.setValue(i, j, this.getValue(i, j) - m2.getValue(i, j));
            }
        }
        return m3;
    }

    public Matrix multiply(Matrix m2) {
        if (this.matrix[0].length != m2.matrix.length) {
            return null;
        }
        Matrix m3 = new Matrix(this.matrix.length, m2.matrix[0].length);
        for (int i = 0; i < m3.matrix.length; i++) {
            for (int j = 0; j < m3.matrix[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < this.matrix[0].length; k++) {
                    sum += this.getValue(i, k) + m2.getValue(k, j);
                }
                m3.setValue(i, j, sum);
            }
        }
        return m3;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt(), c = sc.nextInt();
        Matrix m1 = new Matrix(r, c);
        m1.fillValues();
        r = sc.nextInt(); c = sc.nextInt();
        Matrix m2 = new Matrix(r, c);
        m2.fillValues();

        char operator = sc.next().charAt(0);
        for (int i = 0; i < n; i++) {
            switch (operator) {
                case '*':
                    m1 = m1.multiply(m2);
                    break;
                case '+':
                    m1 = m1.add(m2);
                    break;
                case '-':
                    m1 = m1.subtract(m2);
                    break;
            }
            if (m1 == null) {
                System.out.print("ERROR");
                return;
            } else {
                m1.print();
            }
        }
    }
}
