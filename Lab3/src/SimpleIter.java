public class SimpleIter {
    public static int solution (double[][] matr, double[][] vector, double eps, double[][] tmp) {
        int numbOfIter = 0;
        double[][] xPrev = new double[tmp.length][tmp[0].length];

        do {
            for (int i = 0; i < tmp.length; i++) {
                for (int j = 0; j < tmp[0].length; j++) {
                    xPrev[i][j] = tmp[i][j];
                }
            }
            System.arraycopy(Matrix.sum(Matrix.multiple(matr, xPrev), vector), 0, tmp, 0, tmp.length);

            numbOfIter++;
        } while (Matrix.norm(Matrix.diff(tmp, xPrev)) >= eps);

        return numbOfIter;
    }
}
