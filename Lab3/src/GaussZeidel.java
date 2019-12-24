public class GaussZeidel {
    public static int solution(double[][] matr, double[][] vector, double eps, double[][] tmp) {
        int numbOfIter = 0;
        double[][] xPrev = new double[tmp.length][tmp[0].length];

        do {
            for (int i = 0; i < tmp.length; i++) {
                for (int j = 0; j < tmp[0].length; j++) {
                    xPrev[i][j] = tmp[i][j];
                }
            }

            for (int i = 0; i < tmp.length; i++) {
                tmp[i][0] = vector[i][0] / matr[i][i];
                for(int j = 0; j <= i - 1; j++) {
                    tmp[i][0] -= matr[i][j] * tmp[j][0] / matr[i][i];
                }
                for(int j = i+1; j < matr[0].length; j++) {
                    tmp[i][0] -= matr[i][j] * xPrev[j][0] / matr[i][i];
                }
            }

             numbOfIter++;
        } while (Matrix.norm(Matrix.diff(tmp, xPrev)) >= eps);

        return numbOfIter;
    }
}
