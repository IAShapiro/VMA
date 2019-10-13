import java.util.Formatter;

public class Matrix {
    public static double[][] multiple(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static void printMatr(double[][] matr) {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                Formatter frm = new Formatter();
                System.out.print(" " + frm.format("% 3.6e", matr[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printAugmentedMatrix(double[][] matr, double[][] vector) {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                Formatter frm = new Formatter();
                System.out.print(" " + frm.format("% 3.6e", matr[i][j]) + " ");
            }
            Formatter frm = new Formatter();
            System.out.println(" | " + frm.format("% 3.6e", vector[i][0]));
        }
        System.out.println();
    }

    public static double[][] diff(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }
}
