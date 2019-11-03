public class SquareRoot {
    public static double[][] solution(double[][] matr, double[][] vector, double[][] s,  double[][] y) {
        double[][] solutions = new double[vector.length][1];

        calcS(matr, s);
        calcY(vector, s, y);
        calcX(solutions, s, y);
        return solutions;
    }

    private static void calcS(double[][] matr, double[][] s) {
        double sum = 0;

        for (int i = 0; i < s.length; ++i) {
            for (int j = i; j < s[0].length; ++j) {
                for (int k = 0; k < i; ++k) {
                    sum += s[k][i] * s[k][j];
                }

                if (i == j) {
                    s[i][j] = Math.sqrt(Math.abs(matr[i][j] - sum));
                } else {
                    s[i][j] = (matr[i][j] - sum) / s[i][i];
                }
                sum = 0;
            }
        }
    }

    private static void calcY(double[][] vector, double[][] s,  double[][] y) {
        double sum = 0;

        for (int i = 0; i < s.length; ++i) {
            for (int k = 0; k < i; ++k) {
                sum += s[k][i] * y[k][0];
            }
            y[i][0] = (vector[i][0] - sum) / s[i][i];

            sum = 0;
        }
    }

    private static void calcX(double[][] solutions, double[][] s,  double[][] y) {
        double sum = 0;

        for (int i = (s.length - 1); i >= 0; --i) {
            for (int k = (i + 1); k < s.length; ++k) {
                sum += s[i][k] * solutions[k][0];
            }

            solutions[i][0] = (y[i][0] - sum) / s[i][i];

            sum = 0;
        }
    }
}
