package lab2;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Matrix implements MatrixInt {
    private final int rows;
    private final int cols;
    private final double[][] data;

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
    public Matrix(MatrixInt matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Матриця не може бути null.");
        }
        this.rows = matrix.getRows();
        this.cols = matrix.getCols();
        this.data = new double[rows][cols];
        double[][] matrixData = matrix.getData();
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrixData[i], 0, this.data[i], 0, cols);
        }
    }

    // Матриця з двовимірного масиву
    public Matrix(double[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Пустий масив.");
        }
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (data[i].length != cols) {
                throw new IllegalArgumentException("Стовпчики різних розмірів.");
            }
            System.arraycopy(data[i], 0, this.data[i], 0, cols);
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
            throw new IndexOutOfBoundsException("Індекс виходить за розмірність матриці");
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
        double[][] copy = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, copy[i], 0, cols);
        }
        return copy;
    }

    // Отримання елемента за індексами
    public double getElement(int rowIndex, int colIndex) {
        if (rowIndex >= 0 && rowIndex < rows && colIndex >= 0 && colIndex < cols) {
            return data[rowIndex][colIndex];
        } else {
            throw new IndexOutOfBoundsException("Індекс виходить за розмірність матриці");
        }
    }

    // Отримання рядка за індексом
    public double[] getRow(int row) {
        if (row >= 0 && row < rows) {
            return data[row].clone(); // повертаємо копію рядка, щоб не змінювати елементи матриці
        } else {
            throw new IndexOutOfBoundsException("Індекс виходить за розмірність матриці");
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
            throw new IndexOutOfBoundsException("Індекс виходить за розмірність матриці");
        }
    }

    // Отримання розмірності матриці
    public String getDimensions() {
        return rows + "x" + cols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return rows == matrix.rows && cols == matrix.cols && Arrays.deepEquals(data, matrix.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, cols);
        result = (69 * result) + Arrays.deepHashCode(data);
        return result;
    }

    // Додавання матриць
    @Override
    public Matrix add(MatrixInt toAdd) {
        if (this.rows != toAdd.getRows() || this.cols != toAdd.getCols()) {
            throw new IllegalArgumentException("Розміри матриць повинні співпадати.");
        }

        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + toAdd.getElement(i, j);
            }
        }
        return result;
    }

    // Множення на скаляр
    @Override
    public Matrix multiply(double multiplier) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] * multiplier;
            }
        }
        return result;
    }

    @Override
    public Matrix multiply(MatrixInt matrix) {
        if (this.cols != matrix.getRows()) {
            throw new IllegalArgumentException("Кількість стовпців першої матриці повинна дорівнювати " +
                    "кількості рядків другої матриці для множення.");
        }
        double[][] resultData = new double[this.rows][matrix.getCols()];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                for (int k = 0; k < this.cols; k++) {
                    resultData[i][j] += this.data[i][k] * matrix.getElement(k, j);
                }
            }
        }
        return new Matrix(resultData);
    }

    public Matrix transpose() {
        double[][] transposedData = new double[this.cols][this.rows];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                transposedData[j][i] = this.data[i][j];
            }
        }
        return new Matrix(transposedData);
    }

    public static Matrix makeDiagonalMatrix(double[] vector) {
        double[][] data = new double[vector.length][vector.length];
        for (int i = 0; i < vector.length; i++) {
            data[i][i] = vector[i];
        }
        return new Matrix(data);
    }

}

