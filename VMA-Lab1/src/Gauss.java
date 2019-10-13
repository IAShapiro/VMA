public class Gauss {
    public static double solution(double[][] matr, double[][] vector) {
        double det = 1;

        for (int i = 0; i < matr[0].length; i++) {
            det *= Gauss.divLeadElem(matr, vector, i);
            Gauss.diffLinesForward(matr, vector, i);
        }

        double[][] result = new double[vector.length][1];

        for (int i = vector.length - 1; i >= 0; i--)
        {
            result[i][0] = vector[i][0];
            for (int j = i + 1; j < result.length; j++) {
                result[i][0] -= matr[i][j] * result[j][0];
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                vector[i][j] = result[i][j];
            }
        }

        return det;
    }

    public static double[][] inverseMatr(double[][] matr) {
        double[][] invMatr = new double[matr.length][matr.length];
        for (int i = 0; i < matr.length; i++) {
            double[][] matrCopy = matr.clone();
            double[][] vector = new double[matr.length][1];
            for (int j = 0; j < vector.length; j++) {
                vector[j][0] = (j == i ? 1 : 0);
                matrCopy[j] = matr[j].clone();
            }

            Gauss.solution(matrCopy, vector);

            for (int j = 0; j < matr.length; j++) {
                invMatr[j][i] = vector[j][0];
            }
        }
        return invMatr;
    }

    private static double divLeadElem(double[][] matr, double[][] vector, int numbOfLine) {
        double leadElem = matr[numbOfLine][numbOfLine];
        vector[numbOfLine][0] /= matr[numbOfLine][numbOfLine];

        for (int i = matr[0].length - 1; i > numbOfLine - 1; i--) {
            matr[numbOfLine][i] /= matr[numbOfLine][numbOfLine];
        }
        return leadElem;
    }

    private static void diffLinesForward(double[][] matr, double[][] vector, int numbOfLine) {
        for (int i = numbOfLine + 1; i < matr[0].length; i++) {
            vector[i][0] -= matr[i][numbOfLine] * vector[numbOfLine][0];

            for (int j = matr[0].length - 1; j > numbOfLine - 1; j--) {
                matr[i][j] -= matr[i][numbOfLine] * matr[numbOfLine][j];
            }
        }
    }

}
