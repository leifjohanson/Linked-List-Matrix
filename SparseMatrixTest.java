public class SparseMatrixTest {
    public void testCreateMatrixA() {
        int numberOfRows = 4;
        int numberOfColumns = 6;
        SparseMatrix matrixA = new SparseMatrix(4, 6);
        matrixA.insert(1,1,8);
        matrixA.insert(1,6,60);
        matrixA.insert(1,2,5);
        matrixA.insert(2,2,33);
        matrixA.insert(3,4,36);
        matrixA.insert(4,5,8);
        matrixA.insert(1,3,7);
        matrixA.print();
    }
}