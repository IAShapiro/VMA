import java.util.Formatter;

public class Gauss {
    public static double solution(double[][] matr, double[][] vector, double[][] E) {
        double det = 1;
        for (int i = 0; i < matr[0].length; i++) {
            det *= Gauss.divLeadElem(matr, vector, i, E);
            Gauss.diffLinesForward(matr, vector, i, E);
        }

        for (int i = matr[0].length - 1; i >= 0; i--) {
            Gauss.diffLinesReverse(matr, vector, i, E);
        }
        return det;
    }

    private static double divLeadElem(double[][] matr, double[][] vector, int numbOfLine, double[][] E) {
        double leadElem = matr[numbOfLine][numbOfLine];
        if (Math.abs(matr[numbOfLine][numbOfLine] - 0.) > 0.00000001) {
            vector[numbOfLine][0] /= matr[numbOfLine][numbOfLine];
            for (int i = 0; i < E[0].length; i++) {
                E[numbOfLine][i] /= matr[numbOfLine][numbOfLine];
            }
        }
        for (int i = matr[0].length - 1; i > numbOfLine - 1; i--) {
            if (Math.abs(matr[numbOfLine][numbOfLine] - 0.) > 0.00000001) {
                matr[numbOfLine][i] /= matr[numbOfLine][numbOfLine];
            }
        }
        return leadElem;
    }

    private static void diffLinesForward(double[][] matr, double[][] vector, int numbOfLine, double[][] E) {
        for (int i = numbOfLine + 1; i < matr[0].length; i++) {
            vector[i][0] -= matr[i][numbOfLine] * vector[numbOfLine][0];
            for (int j = 0; j < matr.length; j++) {
                 E[i][j] -= matr[i][numbOfLine] * E[numbOfLine][j];
            }
            for (int j = matr[0].length - 1; j > numbOfLine - 1; j--) {
                matr[i][j] -= matr[i][numbOfLine] * matr[numbOfLine][j];
            }
        }
    }

    private static void diffLinesReverse(double[][] matr, double[][] vector, int numbOfLine, double[][] E) {
        for (int i = 0; i < numbOfLine; i++) {
            vector[i][0] -= matr[i][numbOfLine] * vector[numbOfLine][0];
            for (int j = 0; j < matr.length; j++) {
                E[i][j] -= matr[i][numbOfLine] * E[numbOfLine][j];
            }
            matr[i][numbOfLine] = 0;
        }
    }

    public static void printMatrix(double[][] matr, double[][] vector) {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                Formatter frm = new Formatter();
                System.out.print(" " + frm.format("%3.6e", matr[i][j]) + " ");
            }
            Formatter frm = new Formatter();
            System.out.println(" | " + frm.format("%3.6e", vector[i][0]));
        }
        System.out.println();
    }

}
