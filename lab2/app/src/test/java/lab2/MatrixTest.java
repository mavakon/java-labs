package lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void testFillRandom() {
        Matrix matrix = new Matrix(3, 3);
        matrix.fillRandom(1.0, 10.0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(matrix.getData()[i][j] >= 1.0 && matrix.getData()[i][j] <= 10.0);
            }
        }
    }

    @Test
    void testSetElement() {
        Matrix matrix = new Matrix(3, 3);
        matrix.setElement(1, 1, 5.0);
        assertEquals(5.0, matrix.getData()[1][1]);
    }

    @Test
    void testSetData() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        matrix.setData(data);
        assertArrayEquals(data, matrix.getData());
    }
    @Test
    void testGetElement() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        matrix.setData(data);
        assertEquals(5.0, matrix.getElement(1, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> matrix.getElement(3, 3));
    }

    @Test
    void testGetRow() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        matrix.setData(data);
        assertArrayEquals(new double[]{4.0, 5.0, 6.0}, matrix.getRow(1));
        assertThrows(IndexOutOfBoundsException.class, () -> matrix.getRow(3));
    }

    @Test
    void testGetCol() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        matrix.setData(data);
        assertArrayEquals(new double[]{2.0, 5.0, 8.0}, matrix.getCol(1));
        assertThrows(IndexOutOfBoundsException.class, () -> matrix.getCol(3));
    }
    @Test
    void testGetSize() {
        Matrix matrix = new Matrix(6, 7);
        assertEquals("6x7", matrix.getDimensions());
    }

}