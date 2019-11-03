public class Main {

    public static void main(String[] args) {
        double det = 1;
        final int K = -1;
        double[][] matr = {{8.30, 2.62 + 0.20 * K, 4.10, 1.90},
                           {3.92, 8.45, 7.78 - 0.20 * K, 2.46},
                           {3.77, 7.21 + 0.20 * K, 8.04, 2.28},
                           {2.21, 3.65 - 0.20 * K, 1.69, 6.99}};
        double[][] vector = {{-10.65 + 0.20 * K}, {12.21}, {15.45 - 0.20 * K}, {-8.35}};

        double[][] matrCopy = matr.clone();
        for (int i = 0; i < matr.length; i++) {
            matrCopy[i] = matr[i].clone();
        }
        double[][] vectorCopy = vector.clone();
        for (int i = 0; i < vector.length; i++) {
            vectorCopy[i] = vector[i].clone();
        }
        double[][] s = new double[matr.length][matr[0].length];
        double[][] y = new double[vector.length][1];

        System.out.println("The original augmented matrix:");
        Matrix.printAugmentedMatrix(matrCopy, vectorCopy);

        vectorCopy = Matrix.multiple(Matrix.transpose(matrCopy), vectorCopy);
        matrCopy = Matrix.multiple(Matrix.transpose(matrCopy), matrCopy);

        System.out.println("Matrix after multiplication:");
        Matrix.printAugmentedMatrix(matrCopy, vectorCopy);

        vectorCopy = SquareRoot.solution(matrCopy, vectorCopy, s, y);

        System.out.println("Matrix S:");
        Matrix.printMatr(s);

        System.out.println("Vector y:");
        Matrix.printMatr(y);

        System.out.println("Vector of solutions:");
        Matrix.printMatr(vectorCopy);

        System.out.println("Check:");
        Matrix.printMatr(Matrix.multiple(matr, vectorCopy));

        System.out.println("The vector of residuals:");
        Matrix.printMatr(Matrix.diff(Matrix.multiple(matr, vectorCopy), vector));

        for (int i = 0; i < s.length; i++) {
            det *= s[i][i];
        }
        System.out.printf("The module of the determinant is % 3.6e \n", det);
    }
}
