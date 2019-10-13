public class Main {

    public static void main(String[] args) {
        final int K = -1;
        double det;
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

        System.out.println("The original augmented matrix:");
        Matrix.printAugmentedMatrix(matrCopy, vectorCopy);

        det = Gauss.solution(matrCopy, vectorCopy);
        System.out.println("Vector of solutions:");
        Matrix.printMatr(vectorCopy);

        System.out.printf("Determinant is % 3.6e \n", det);

        System.out.println("The inverse matrix:");
        double[][] inverseMatr = Gauss.inverseMatr(matr);
        Matrix.printMatr(inverseMatr);

        System.out.println("The product of the original and inverse matrix:");
        Matrix.printMatr(Matrix.multiple(inverseMatr, matr));

        System.out.println("The vector of residuals:");
        Matrix.printMatr(Matrix.diff(Matrix.multiple(matr, vectorCopy), vector));
    }
}