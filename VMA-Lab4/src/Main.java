public class Main {

    public static void main(String[] args) {
        final int K = -1;
        double[][] matr = {{8.30, 2.62 + 0.20 * K, 4.10, 1.90},
                {3.92, 8.45, 7.78 - 0.20 * K, 2.46},
                {3.77, 7.21 + 0.20 * K, 8.04, 2.28},
                {2.21, 3.65 - 0.20 * K, 1.69, 6.99}};

        double[] q = new double[matr.length];

        double[][] matrCopy = matr.clone();
        for (int i = 0; i < matr.length; i++) {
            matrCopy[i] = matr[i].clone();
        }

        double[][][] B = new double[matr.length + 1][matr.length][matr.length];
        B[0] = Matrix.getDiagMatr(matr.length, 1);

        double[][][] matrQ = new double[matr.length + 1][matr.length][matr.length];

        Faddeev.solution(matr, matrCopy, q, B);
        double[] lambda = {0.737802, 5.63574, 5.79103, 19.6154};

        Faddeev.formVectors(matrQ, lambda, B);

        System.out.println("Matrix B[1]-B[" + matr.length + "]:");

        for (int i = 1; i < matr.length + 1; i++) {
            Matrix.printMatr(B[i]);
        }

        System.out.print("Characteristic polynomial: x" + matr.length + " ");
        for (int i = 0; i < matr.length; i++) {
            System.out.print((q[i] < 0 ? "+ " : "- ") + Math.abs(q[i]) + (i == matr.length - 1 ? " = 0" :  ("x" +(matr.length - 1 - i) ))+ " ");
        }

        System.out.println("\nMatrix Q[1]-Q[" + matr.length + "]:");

        for (int i = 0; i < matr.length; i++) {
            Matrix.printMatr(Matrix.transpose(matrQ[i]));
        }

        for (int i = 0; i < matr.length; i++) {
            System.out.print("x" + (i + 1) + " = " + lambda[i] + ";\tvector[" + (i + 1) + "]T  = ");
            Matrix.printVectorInLine(matrQ[i][0]);
        }
    }
}
