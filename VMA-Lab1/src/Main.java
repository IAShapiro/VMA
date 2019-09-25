import java.util.Formatter;

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

        double[][] E = {{1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};

        Gauss.printMatrix(matrCopy, vectorCopy);
        det = Gauss.solution(matrCopy, vectorCopy, E);
        Gauss.printMatrix(matrCopy, vectorCopy);

        Formatter frm = new Formatter();
        System.out.println(frm.format("%3.6e", det));
        Gauss.printMatrix(E, vectorCopy);

        Matrix.printMatr(Matrix.multiple(E, matr));//показывает единичную матрицу с погрешностью

        Matrix.printMatr(Matrix.diff(Matrix.multiple(matr, vectorCopy), vector));
    }
}
