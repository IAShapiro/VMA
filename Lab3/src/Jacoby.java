public class Jacoby {
    public static double[][] formMatrAndVectB(double[][] matr, double[][]matrB, double[][] vector) {
        double[][] vectorb = new double[matr[0].length][1];
        for (int i = 0; i < matr[0].length; i++) {
            vectorb[i][0] = vector[i][0] / matr[i][i];
        }
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                matrB[i][j] = ((i == j) ? 0 : (-matr[i][j] / matr[i][i]));
            }
        }

        return vectorb;
    }

    public static int solution(double[][] matr, double[][] vector, double eps, double[][] tmp) {
        return SimpleIter.solution(matr, vector, eps, tmp);
    }
}
