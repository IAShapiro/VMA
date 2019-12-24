public class Faddeev {
    public static void solution(double[][] a, double[][] tmpA, double[] q, double[][][] B) {
        for (int i = 0; i < a.length; i++) {
            tmpA = Matrix.multiple(a, B[i]);

            q[i] = Matrix.spoor(tmpA) / (i + 1);

            B[i + 1] = Matrix.diff(tmpA, Matrix.getDiagMatr(a.length, q[i]));
        }
    }

    public static void formVectors(double[][][] matrQ, double[] lambda, double[][][] B) {
        for (int i = 0; i < B[0].length; i++) {
            double[][] tmp = Matrix.getDiagMatr(B[0].length, Math.pow(lambda[i], B[0].length - 1));
            for (int j = 0; j < B[0].length - 1; j++) {
                tmp = Matrix.sum(tmp, Matrix.constMul(B[B[0].length - j - 1], Math.pow(lambda[i], j)));
            }
            matrQ[i] = Matrix.transpose(tmp);
        }
    }
}
