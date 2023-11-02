package lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void testFillRandom() {
        Matrix matrix = new Matrix(6, 6);
        matrix.fillRandom(-100.0, 100.0);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                assertTrue(matrix.getData()[i][j] >= -100.0 && matrix.getData()[i][j] <= 100.0);
            }
        }
    }

    @Test
    void testSetElement() {
        Matrix matrix = new Matrix(6, 6);
        matrix.setElement(2, 5, 32.456);
        assertEquals(32.456, matrix.getData()[2][5]);
    }

    @Test
    void testSetData() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{123.4, 234.5, 345.6}, {456.7, 567.8, 678.9}, {789.0, 890.1, 901.2}};
        matrix.setData(data);
        assertArrayEquals(data, matrix.getData());
    }
    @Test
    void testGetElement() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{123.4, 234.5, 345.6}, {456.7, 567.8, 678.9}, {789.0, 890.1, 901.2}};
        matrix.setData(data);
        assertEquals(567.8, matrix.getElement(1, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> matrix.getElement(3, 3));
    }

    @Test
    void testGetRow() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{123.4, 234.5, 345.6}, {456.7, 567.8, 678.9}, {789.0, 890.1, 901.2}};
        matrix.setData(data);
        assertArrayEquals(new double[]{456.7, 567.8, 678.9}, matrix.getRow(1));
        assertThrows(IndexOutOfBoundsException.class, () -> matrix.getRow(3));
    }

    @Test
    void testGetCol() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{123.4, 234.5, 345.6}, {456.7, 567.8, 678.9}, {789.0, 890.1, 901.2}};
        matrix.setData(data);
        assertArrayEquals(new double[]{234.5, 567.8, 890.1}, matrix.getCol(1));
        assertThrows(IndexOutOfBoundsException.class, () -> matrix.getCol(3));
    }
    @Test
    void testGetSize() {
        Matrix matrix = new Matrix(6, 7);
        assertEquals("6x7", matrix.getDimensions());
    }

    @Test
    void testEqualsAndHashCode() {
        Matrix matrix1 = new Matrix(2, 3);
        Matrix matrix2 = new Matrix(2, 3);
        Matrix matrix3 = new Matrix(6, 6);

        assertTrue(matrix1.equals(matrix2) && matrix2.equals(matrix1));
        assertFalse(matrix1.equals(matrix3) || matrix3.equals(matrix1));
        assertEquals(matrix1.hashCode(), matrix2.hashCode());
        assertNotEquals(matrix1.hashCode(), matrix3.hashCode());

    }

}