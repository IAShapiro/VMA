import java.util.Formatter;

public class Matrix {
    public static void printVectorInLine(double[] v) {
        for (int j = 0; j < v.length; j++) {
            Formatter frm = new Formatter();
            System.out.print(" " + frm.format("% 3.6e", v[j]) + " ");
        }
        System.out.println();
    }

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

    public static double[][] constMul(double[][] matr, double c) {
        double[][] tmp = new double[matr.length][matr[0].length];
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                tmp[i][j] = matr[i][j] * c;
            }
        }
        return tmp;
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

    public static double[][] diff(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    public static double[][] transpose(double[][] a) {
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[i][j] = a[j][i];
            }
        }
        return c;
    }

    public static double spoor(double[][]a) {
        double tmp = 0;
        for (int i = 0; i < a[0].length; i++) {
            tmp += a[i][i];
        }
        return tmp;
    }

    public static double[][] getDiagMatr(int size, double c) {
        double[][] e = new double[size][size];
        for (int i = 0; i < size; i++) {
            e[i][i] = c;
        }
        return e;
    }

    public static double[][] sum(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }
}
