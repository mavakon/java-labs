package lab2;

public class Matrix {
    private int rows;
    private int cols;
    private double[][] data;

    // Пуста матриця
    public Matrix() {
        this.rows = 0;
        this.cols = 0;
        this.data = new double[0][0];
    }

    // Матриця заданого розміру
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    // Копія іншої матриці
    public Matrix(Matrix matrix) {
        this.rows = matrix.rows;
        this.cols = matrix.cols;
        this.data = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix.data[i], 0, this.data[i], 0, cols);
        }
    }

}

