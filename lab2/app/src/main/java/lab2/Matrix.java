package lab2;

import java.util.Random;

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

    // Заповнення матриці випадковими числами від a до b
    public void fillRandom(double a, double b) {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = a + (b - a) * random.nextDouble();
            }
        }
    }

    // Встановлення значення елемента за індексом
    public void setElement(int row, int col, double value) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            data[row][col] = value;
        } else {
            throw new IndexOutOfBoundsException("Індекс виходить за межі розмірів матриці");
        }
    }

    // Встановлення значень елементів матриці двовимірним масивом
    public void setData(double[][] data) {
        if (data.length == rows && data[0].length == cols) {
            for (int i = 0; i < rows; i++) {
                if (data[i].length != cols) {
                    throw new IllegalArgumentException("Розміри вхідного масиву не відповідають розмірам матриці");
                }
                System.arraycopy(data[i], 0, this.data[i], 0, cols);
            }
        } else {
            throw new IllegalArgumentException("Розміри вхідного масиву не відповідають розмірам матриці");
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double[][] getData() {
        return data;
    }

    // Отримання елемента за індексами
    public double getElement(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return data[row][col];
        } else {
            throw new IndexOutOfBoundsException("Індекс виходить за межі розмірів матриці");
        }
    }

    // Отримання рядка за індексом
    public double[] getRow(int row) {
        if (row >= 0 && row < rows) {
            return data[row].clone(); // повертаємо копію рядка, щоб не змінювали зовнішнім чином матрицю
        } else {
            throw new IndexOutOfBoundsException("Індекс виходить за межі розмірів матриці");
        }
    }

    // Отримання стовпця за індексом
    public double[] getCol(int col) {
        if (col >= 0 && col < cols) {
            double[] column = new double[rows];
            for (int i = 0; i < rows; i++) {
                column[i] = data[i][col];
            }
            return column;
        } else {
            throw new IndexOutOfBoundsException("Індекс виходить за межі розмірів матриці");
        }
    }

}

