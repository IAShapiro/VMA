public class Main {

    public static void main(String[] args) {

        final double EPS = 0.00001;
        final int K = -1;
        double[][] matr = {{8.30, 2.62 + 0.20 * K, 4.10, 1.90},
                {3.92, 8.45, 7.78 - 0.20 * K, 2.46},
                {3.77, 7.21 + 0.20 * K, 8.04, 2.28},
                {2.21, 3.65 - 0.20 * K, 1.69, 6.99}};
        double[][] vector = {{-10.65 + 0.20 * K}, {12.21}, {15.45 - 0.20 * K}, {-8.35}};

        double normOfAtA = Matrix.norm(Matrix.multiple(Matrix.transpose(matr), matr));

        double[][] matrB = Matrix.diff(Matrix.getIdentityMatr(matr[0].length), Matrix.constMul(Matrix.multiple(Matrix.transpose(matr), matr), 1. / normOfAtA));

        double[][] vectorb = Matrix.constMul(Matrix.multiple(Matrix.transpose(matr), vector), 1. / normOfAtA);

        double[][] tmpForIter = new double[vectorb.length][1];
        for (int i = 0; i < vectorb.length; i++) {
                tmpForIter[i][0] = vectorb[i][0];
        }

        System.out.println("Matrix B:");
        Matrix.printMatr(matrB);
        System.out.println("Vector b:");
        Matrix.printMatr(vectorb);

        int numbOfIter = SimpleIter.solution(matrB, vectorb, EPS, tmpForIter);
        System.out.println("Vector of solution:");
        Matrix.printMatr(tmpForIter);
        System.out.println("Number of iteration: " + numbOfIter);

        System.out.println("_________________________________________________________________________________" );
        double[][] matrForJacoby = {{12.83, -2.17, 0.16, 1.52},
                {0.15, 1.44, -0.06, 0.18},
                {3.32, 2.69, 8.22, 1.74},
                {2.86, 4.54, -2.97, 18.69}};
        double[][] vectorForJacoby =  {{-37.35}, {-3.44}, {25.97}, {-40.7}};

        double[][] matrBJacoby = new double[matrForJacoby.length][matrForJacoby[0].length];

        double[][] vectorbJacoby = Jacoby.formMatrAndVectB(matrForJacoby, matrBJacoby, vectorForJacoby);

        double[][] tmpForJacoby = new double[vectorbJacoby.length][1];
        for (int i = 0; i < vectorbJacoby.length; i++) {
            tmpForJacoby[i][0] = vectorbJacoby[i][0];
        }

        System.out.println("Priori estimate: " + (int)(Math.ceil(Math.log(EPS*(1-Matrix.norm(matrBJacoby))/Matrix.norm(vectorbJacoby))/Math.log(Matrix.norm(matrBJacoby))) + 1));
        Matrix.printMatr(matrBJacoby);
        System.out.println("||B|| = " + Matrix.norm(matrBJacoby) + "\n");
        Matrix.printMatr(vectorbJacoby);
        System.out.println("||b|| = " + Matrix.norm(vectorbJacoby) + "\n");

        System.out.println("Number of iteration: " +  Jacoby.solution(matrBJacoby, vectorbJacoby, EPS, tmpForJacoby) + "\n");
        System.out.println("Vector of solution:");
        Matrix.printMatr(tmpForJacoby);
        System.out.println("Vector of residuals:");
        Matrix.printMatr(Matrix.diff(vector, Matrix.multiple(matr, tmpForJacoby)));
        System.out.println("_________________________________________________________________________________" );

        double[][] tmpForZeidel = new double[vector.length][1];
        for (int i = 0; i < vectorForJacoby.length; i++) {
            tmpForZeidel[i][0] = vectorForJacoby[i][0] / matrForJacoby[i][i];
        }

        System.out.println("Number of iteration: " +  GaussZeidel.solution(matrForJacoby, vectorForJacoby, EPS, tmpForZeidel) + "\n");
        System.out.println("Vector of solution:");
        Matrix.printMatr(tmpForZeidel);

    }
}