package lab2;

public class Main {

    public static void main(String[] args) {

//        int getRows();
//        int getCols();
//        double[][] getData();
//        double getElement(int row, int col);
//        double[] getRow(int row);
//        double[] getCol(int col);
//        String getDimensions();
//        MatrixInt add(MatrixInt toAdd);
//        MatrixInt multiply(double multiplier);
//        MatrixInt multiply(MatrixInt matrix);
//        MatrixInt transpose();
//        MatrixInt inverse();

//        public void setElement(int row, int col, double value) {
//        public void setData(double[][] data)
//        public boolean equals(Object o)
//        public int hashCode()
//        public static Matrix makeDiagonalMatrix(double[] vector)
//        public static Matrix makeIdentityMatrix(int size)
//        public static Matrix makeRandomRowMatrix(int size, double lowerLimit, double upperLimit)
//        public static Matrix makeRandomColumnMatrix(int size, double lowerLimit, double upperLimit)


        Matrix matrix1 = new Matrix(new double[][]{
                {26, 12, 43, 12},
                {17, 10, 30, 17},
                {36, 16, 59, 14},
                {12, 17, 26, 30}
        });
        Matrix matrix2 = new Matrix(new double[][]{
                {1, 2, 3, 7},
                {5, 2, 8, 1},
                {8, 3, 1, 1},
                {5, 4, 2, 9}
        });
        ImmutableMatrix matrix3 = new ImmutableMatrix(matrix1);

        System.out.println("\nПерша матриця:");
        System.out.print(matrix1);
        System.out.println("Хеш-код:");
        System.out.println(matrix1.hashCode());
        System.out.println("\nДруга матриця:");
        System.out.print(matrix2);
        System.out.println("Хеш-код:");
        System.out.println(matrix2.hashCode());
        System.out.println("\nТретя матриця:");
        System.out.print(matrix3);
        System.out.println("Хеш-код:");
        System.out.println(matrix3.hashCode());

        System.out.println("\nЧи equals перша матриця до третьої:");
        System.out.println(matrix1.equals(matrix3));

        matrix1.setElement(0,3, -100);
        System.out.println("\nТретя матриця:");
        System.out.print(matrix3);

        System.out.println("\nСума першої і другої:");
        System.out.println(matrix1.add(matrix2));
        System.out.println("\nМноження першої на скаляр:");
        System.out.println(matrix1.multiply(2));
        System.out.println("\nМноження на матрицю (1 і 2):");
        System.out.println(matrix1.multiply(matrix2));
        System.out.println("\nТранспонуємо першу матрицю:");
        System.out.println(matrix1.transpose());
        System.out.println("\nОбернена до першої матриці:");
        System.out.println(matrix1.inverse());


//        MatrixGen<Double> doubleMatrixGeneric = new MatrixGen<>(3, 3, Double.class);
//
//        Double[][] newData = {
//                {7.0, 8.0, 9.0},
//                {10.0, 11.0, 12.0},
//                {13.0, 14.0, 15.0}
//        };
//        doubleMatrixGeneric.setData(newData);
//        doubleMatrixGeneric.setElement(0, 0, 1.0);
//        Double value = doubleMatrixGeneric.getElement(0, 1);
//        System.out.println("Value at (0,1): " + value);
//
//        // Print out the matrix
//        printMatrix(doubleMatrixGeneric);
//    }
//
//    public static void printGenericMatrix(MatrixGen<Double> matrix) {
//        Double[][] data = matrix.getData();
//        for (int i = 0; i < matrix.getRows(); i++) {
//            for (int j = 0; j < matrix.getCols(); j++) {
//                System.out.print(data[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}