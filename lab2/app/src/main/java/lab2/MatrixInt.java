package lab2;

public interface MatrixInt {
    int getRows();
    int getCols();
    double[][] getData();
    double getElement(int row, int col);
    double[] getRow(int row);
    double[] getCol(int col);
    String getDimensions();
    MatrixInt add(MatrixInt toAdd);
    MatrixInt multiply(double multiplier);

}
